package be.bf.android.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

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

        btnRegister = findViewById(R.id.button_register);
        btnRegister.setOnClickListener(this::register);
        btnReset = findViewById(R.id.button_reset);
        btnReset.setOnClickListener(this::reset);
    }


    public void register(View view) {
        Map<String,String> fields = new HashMap<>();
        fields.put("firstName",String.valueOf(etFirstName.getText()));
        fields.put("lastName",String.valueOf(etLastName.getText()));
        fields.put("birthday",String.valueOf(etBirthDate.getText()));
        fields.put("username",String.valueOf(etUsername.getText()));
        fields.put("password",String.valueOf(etPassword.getText()));


//        if( fields.isEmpty() ) {
//            Toast.makeText(this,"No field should be empty",Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this,"Welcome "+username,Toast.LENGTH_SHORT).show();
//            Log.d("username", username );
//            Log.d("password", password);
//        }

    }


    public void reset(View view) {
        etFirstName.setText("");
        etLastName.setText("");
        etBirthDate.setText("");
        etUsername.setText("");
        etPassword.setText("");
    }
}