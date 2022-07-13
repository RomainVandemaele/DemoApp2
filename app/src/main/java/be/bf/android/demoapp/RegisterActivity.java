package be.bf.android.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import be.bf.android.demoapp.models.RegisterForm;

public class RegisterActivity extends AppCompatActivity {


    private EditText etFirstName;
    private EditText etLastName;
    private EditText etBirthDate;
    private EditText etUsername;
    private EditText etPassword;

    private Button btnRegister;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etFirstName = findViewById(R.id.textEdit_firstName);
        etLastName = findViewById(R.id.textEdit_lastName);
        etBirthDate = findViewById(R.id.textEdit_birthday);
        etUsername = findViewById(R.id.textEdit_username);
        etPassword = findViewById(R.id.textEdit_password);

        btnRegister = findViewById(R.id.button_register_register);
        btnRegister.setOnClickListener(this::register);
        btnReset = findViewById(R.id.button_register_reset);
        btnReset.setOnClickListener(this::reset);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    public void register(View view) {
        Log.d("TEST","REGISTER");
        Map<String,String> fields = new HashMap<>();
        fields.put("firstName",String.valueOf(etFirstName.getText()));
        fields.put("lastName",String.valueOf(etLastName.getText()));
        fields.put("birthdate",String.valueOf(etBirthDate.getText()));
        fields.put("username",String.valueOf(etUsername.getText()));
        fields.put("password",String.valueOf(etPassword.getText()));

        RegisterForm form = new RegisterForm();
        form.setFirstName(fields.get("firstName"))
            .setLastName(fields.get("lastName"))
            .setBirthDate(fields.get("birthdate"))
            .setUsername(fields.get("username"))
            .setPassword(fields.get("password"));


        if(form.isValid() ){
            Toast.makeText(this,"You are now registered "+form.getUsername(),Toast.LENGTH_LONG).show();
            //RegisterActivity.this.startActivity(new Intent(RegisterActivity.this,MainActivity.class));
        }else {
            Toast.makeText(this,"Register refused",Toast.LENGTH_LONG).show();
        }

    }


    public void reset(View view) {
        etFirstName.setText("");
        etLastName.setText("");
        etBirthDate.setText("");
        etUsername.setText("");
        etPassword.setText("");
    }
}