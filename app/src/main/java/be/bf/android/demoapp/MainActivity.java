package be.bf.android.demoapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Application;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.security.Permission;

import be.bf.android.demoapp.activities.ChoiceButtonActivity;
import be.bf.android.demoapp.activities.DisplayExtraActivity;
import be.bf.android.demoapp.activities.LoginActivity;
import be.bf.android.demoapp.activities.RegisterActivity;
import be.bf.android.demoapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private TextView tvHello;
    private Button btnLogin;
    private Button btnRegister;
    private Button btnGoChoice;

    private ActivityMainBinding binding;

    private static final int REQUEST_CODE_CHOICE_BUTTON = 101;
    private static final int REQUEST_CODE_CALL_PERMISSION = 102;

    private ActivityResultLauncher<Intent> exLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_main);

        Log.v("BLOP","onCreate : " + "demo");
        //Log.e("BLIP","error");

        //Toast.makeText(this,"BLOP",Toast.LENGTH_SHORT).show();
        Log.d("LIFECYCLE","ON_CREATE");
        String welcomeMessage = getResources().getString(R.string.welcome_message);
        Log.d("GAME",Application.GAME_SERVICE);
        ( (DemoApplication) getApplication()).getHello();


//        btnLogin = findViewById(R.id.button_login);
//        btnLogin.setOnClickListener(this::goLogin);
//        btnRegister = findViewById(R.id.button_register);
//        btnRegister.setOnClickListener(this::goRegister);
//        btnGoChoice = findViewById(R.id.button_GoChoice);
//        btnGoChoice.setOnClickListener(this::goChoice);

        binding.buttonGoChoice.setOnClickListener(this::goChoice);
        binding.buttonLogin.setOnClickListener(this::goLogin);
        binding.buttonRegister.setOnClickListener(this::goRegister);
        binding.btnMainGoDisplayExtra.setOnClickListener(this::goExtra);
        binding.btnMainCall.setOnClickListener(this::call);
        binding.btnMainSearch.setOnClickListener(this::search);


        //On ActivityResult new way
        //exLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),this::ex1Result);
    }

    private ActivityResultLauncher<String> callLauncher = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(),
            (isGranted) -> {
                if(isGranted) {
                    this.executeCallPhone();
                }
            }
    );

    private void launchSearch() {
        String query = binding.etMainExtra.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEARCH)
                .putExtra(SearchManager.QUERY,query);
        if(intent.resolveActivity(getPackageManager()) != null) {
            MainActivity.this.startActivity(intent);
        }
    }

    private void search(View view) {
        launchSearch();
    }


//    public void ex1Result(ActivityResult result) {
//        Log.d("MainActivity", "exo1Result: " + result);
//        //result as all data, requestCode
//    }

    public void goExtra(View view) {
        Intent intent = new Intent(MainActivity.this, DisplayExtraActivity.class);
        intent.putExtra("text",binding.etMainExtra.getText().toString());
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==REQUEST_CODE_CALL_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                this.executeCallPhone();
            }
        }
    }

    private void call(View view) {
        //checkCallingPermission(Manifest.permission.CALL_PHONE);
        //if(checkPermission(Manifest.permission.CALL_PHONE,1,1) == PackageManager.PERMISSION_DENIED) {
//        if( ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED ) {
//            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CODE_CALL_PERMISSION);
//        }

        if(checkCallingPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            callLauncher.launch(Manifest.permission.CALL_PHONE);
            //requestPermissions(new String[] {Manifest.permission.CALL_PHONE},REQUEST_CODE_CALL_PERMISSION);
        }else {
            this.executeCallPhone();
        }
    }

    private void executeCallPhone() {
        String phoneNumber = binding.etMainExtra.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL); //or uri in constuctor
        intent.setData(Uri.parse("tel:"+phoneNumber));
        if(intent.resolveActivity(getPackageManager()) != null) {
            MainActivity.this.startActivity(intent);
        }
    }

    private void sendMessage() {
        String phoneNumber = binding.etMainExtra.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,phoneNumber);
        intent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(intent, null);
        startActivity(shareIntent);
    }

    public void goChoice(View view) {

        Intent myIntent = new Intent(MainActivity.this, ChoiceButtonActivity.class);
        MainActivity.this.startActivityForResult(myIntent,MainActivity.REQUEST_CODE_CHOICE_BUTTON );
        exLauncher.launch(myIntent);

    }

    public void goLogin(View view) {
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        loginIntent.putExtra("username","Romain");
        loginIntent.putExtra("password","password");
        MainActivity.this.startActivity(loginIntent);
    }

    public void goRegister(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        MainActivity.this.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE","ON_START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE","ON_RESUME");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE","ON_SPAUSE");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE","ON_STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE","ON_DESTROY");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //getResources().getInteger(R.code)
        switch (requestCode) {
            case MainActivity.REQUEST_CODE_CHOICE_BUTTON :
                switch (resultCode) {
                    case R.integer.RESULT_VALIDATED:
                        //Snackbar bar = Snackbar.make( binding.layMainGlobal ,"Validated",Snackbar.LENGTH_LONG);
                        Toast.makeText(this,"Validated",Toast.LENGTH_SHORT).show();
                        break;
                    case R.integer.RESULT_CANCELLED:
                        Toast.makeText(this,"Cancelled",Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            default:
                break;
        }
    }


}