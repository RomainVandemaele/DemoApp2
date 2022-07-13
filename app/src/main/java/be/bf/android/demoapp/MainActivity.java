package be.bf.android.demoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import be.bf.android.demoapp.databinding.ActivityMainBinding;
import be.bf.android.demoapp.utils.Code;

public class MainActivity extends AppCompatActivity {

    private TextView tvHello;
    private Button btnLogin;
    private Button btnRegister;
    private Button btnGoChoice;

    private ActivityMainBinding binding;

    private static final int REQUEST_CODE_CHOICE_BUTTON = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("BLOP","onCreate : " + "demo");
        Log.e("BLIP","error");
        //Toast.makeText(this,"BLOP",Toast.LENGTH_SHORT).show();
        Log.d("LIFECYCLE","ON_CREATE");
        String welcomeMessage = getResources().getString(R.string.welcome_message);
        Log.d("GAME",Application.GAME_SERVICE);
        ( (DemoApplication) getApplication()).getHello();

        tvHello = findViewById(R.id.textView);
        tvHello.setText("Blop");
        btnLogin = findViewById(R.id.button_login);
        btnLogin.setOnClickListener(this::goLogin);
        btnRegister = findViewById(R.id.button_register);
        btnRegister.setOnClickListener(this::goRegister);
        btnGoChoice = findViewById(R.id.button_GoChoice);
        btnGoChoice.setOnClickListener(this::goChoice);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonGoChoice.setOnClickListener(this::goChoice);
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

    public void goLogin(View view) {
        Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
        MainActivity.this.startActivity(loginIntent);
    }

    public void goRegister(View view) {
        Intent loginIntent = new Intent(MainActivity.this,RegisterActivity.class);
        MainActivity.this.startActivity(loginIntent);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //getResources().getInteger(R.code)
        switch (requestCode) {
            case MainActivity.REQUEST_CODE_CHOICE_BUTTON :
                switch (resultCode) {
                    case R.integer.RESULT_VALIDATED:
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

    public void goChoice(View view) {
        Intent myIntent = new Intent(MainActivity.this,ChoiceButtonActivity.class);
        MainActivity.this.startActivityForResult(myIntent,MainActivity.REQUEST_CODE_CHOICE_BUTTON );
    }
}