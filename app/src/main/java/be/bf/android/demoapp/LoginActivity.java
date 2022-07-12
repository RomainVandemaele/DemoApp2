package be.bf.android.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnReset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.textEdit_username);
        etPassword = findViewById(R.id.textEdit_password);

        btnLogin = findViewById(R.id.button_login);
        btnLogin.setOnClickListener(this::login);
        btnReset = findViewById(R.id.button_reset);
        btnReset.setOnClickListener(this::reset);


    }

    public void login(View view) {
        String username = String.valueOf(etUsername.getText());
        String password = String.valueOf(etPassword.getText());
        if(username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this,"No field should be empty",Toast.LENGTH_SHORT).show();
        }else if(password.length() < 4) {
            Toast.makeText(this,"Password must be at least 4 characters",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Welcome "+username,Toast.LENGTH_SHORT).show();
            Log.d("username", username );
            Log.d("password", password);
        }
    }


    public void reset(View view) {
        etUsername.setText("");
        etPassword.setText("");
    }
}