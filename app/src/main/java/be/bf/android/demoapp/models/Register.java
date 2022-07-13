package be.bf.android.demoapp.models;

import android.widget.EditText;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Register {
    private EditText username;
    private EditText password;

    public String getUsername() { return this.username.getText().toString(); }

    public void setUsername(String username) {
        this.username.setText(username);
    }

}
