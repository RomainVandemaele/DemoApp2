package be.bf.android.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvHello;
    private Button btn;

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
        btn = findViewById(R.id.button);

        //Listener 1 emetteur 1 ecoutant != observable
        btn.setOnClickListener( (View v) -> {
            Log.d("click","ON CLICK");
        } );

        btn.setOnClickListener(this::changeText);


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


    public void changeText(View view) {
        tvHello.setText(getResources().getString(R.string.app_name));
        Intent myIntent = new Intent(MainActivity.this,RegisterActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}