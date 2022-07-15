package be.bf.android.demoapp.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import be.bf.android.demoapp.R;
import be.bf.android.demoapp.databinding.ActivitySharedPreferenceBinding;

import static be.bf.android.demoapp.configs.Config.Preferences;

public class SharedPreferenceActivity extends AppCompatActivity {

    private ActivitySharedPreferenceBinding binding;
//    private final String EMAIL_PREF_KEY = "email";
//    private final String PASSWORD_PREF_KEY = "password";
//    private final String CHECKED_PREF_KEY = "checked";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivitySharedPreferenceBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        this.binding.btnSharedLogin.setOnClickListener(this::onLoginAction);
    }

    private void onLoginAction(View view) {
        String email = this.binding.etSharedEmail.getText().toString();
        String password = this.binding.etSharedPassword.getText().toString();
        boolean isChecked = this.binding.cbSharedRemenberMe.isChecked();
        if(email==null || email.isEmpty() || password==null || password.isEmpty() ) {
            Toast.makeText(this,"You must fill both email and password",Toast.LENGTH_SHORT).show();
        }else {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            preferences.edit()
                    .putString(Preferences.EMAIL_PREF_KEY,email)
                    .putString(Preferences.PASSWORD_PREF_KEY,password)
                    .putBoolean(Preferences.CHECKED_PREF_KEY,isChecked)
                    .apply();
            Intent intent = new Intent(SharedPreferenceActivity.this,PersistenceActivity.class);
            startActivity(intent);
        }

    }
}