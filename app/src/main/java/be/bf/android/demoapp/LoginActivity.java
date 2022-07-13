package be.bf.android.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import be.bf.android.demoapp.models.SignInForm;

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
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        SignInForm form = new SignInForm(etUsername.getText().toString(), etPassword.getText().toString());

        if(form.isValid() ){
            Toast.makeText(this,"Welcome "+form.getUsername(),Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Connexion refused",Toast.LENGTH_SHORT).show();
        }
    }


    public void reset(View view) {
        etUsername.setText("");
        etPassword.setText("");
    }
}