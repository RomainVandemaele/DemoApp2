package be.bf.android.demoapp.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import be.bf.android.demoapp.R;
import be.bf.android.demoapp.databinding.ActivityLoginBinding;
import be.bf.android.demoapp.databinding.ActivityMainBinding;
import be.bf.android.demoapp.models.LogInForm;
import be.bf.android.demoapp.models.LoginModel;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnReset;

    private @NonNull ActivityLoginBinding binding;
    private LoginModel model;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());


//        etUsername = findViewById(R.id.textEdit_username);
//        etPassword = findViewById(R.id.textEdit_password);
//        btnLogin = findViewById(R.id.button_register_login);
//        btnLogin.setOnClickListener(this::login);
//        btnReset = findViewById(R.id.button_register_reset);
//        btnReset.setOnClickListener(this::reset);

        this.binding.buttonRegisterReset.setOnClickListener(this::reset);
        this.binding.buttonRegisterLogin.setOnClickListener(this::login);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void login(View view) {
        String username = binding.textEditUsername.getText().toString();
        String password = binding.textEditPassword.getText().toString();

        LogInForm form = new LogInForm(username, password);

        if(form.isValid() ){
            Toast.makeText(this,"Welcome "+form.getUsername(),Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Connexion refused",Toast.LENGTH_SHORT).show();
        }
    }


    public void reset(View view) {
        binding.textEditUsername.setText("");
        binding.textEditPassword.setText("");
    }
}