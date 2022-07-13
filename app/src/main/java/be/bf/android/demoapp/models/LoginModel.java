package be.bf.android.demoapp.models;

import android.widget.EditText;

public class LoginModel implements FormModel {
    private EditText username;
    private EditText password;

    public LoginModel(EditText username, EditText password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username.getText().toString();
    }

    public LoginModel setUsername(String value) {
        this.username.setText(value);
        return this;
    }

    public String getPassword() {
        return this.password.getText().toString();
    }

    public LoginModel setPassword(String value) {
        this.password.setText(value);
        return this;
    }
}


