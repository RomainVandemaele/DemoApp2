package be.bf.android.demoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import be.bf.android.demoapp.R;
import be.bf.android.demoapp.databinding.ActivityLoggedInBinding;

public class LoggedInActivity extends AppCompatActivity {

    private ActivityLoggedInBinding binding;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityLoggedInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extras = this.getIntent().getExtras();
        if(extras != null) {
            this.username = extras.getString("username");
            binding.tvLogedinUsername.setText("Username : "+username);
            this.password = extras.getString("password");
            binding.tvLogedinPassword.setText("Password : "+password);
        }
    }
}