
package be.bf.android.demoapp.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import be.bf.android.demoapp.R;
import be.bf.android.demoapp.configs.Config;
import be.bf.android.demoapp.databinding.ActivityPersistenceBinding;

public class PersistenceActivity extends AppCompatActivity {

    ActivityPersistenceBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersistenceBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

//        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
//        pref.edit()
//                .putBoolean("connected",true)
//                .putString("username","Romain")
//                .apply();

        binding.btnPersistenceSharedPref.setOnClickListener(this::onSharedPrefAction);
        binding.btnPersistenceFile.setOnClickListener(this::onFileAction);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String message = "email : " + preferences.getString(Config.Preferences.EMAIL_PREF_KEY,"you@home.be") + "\n password : " + preferences.getString(Config.Preferences.PASSWORD_PREF_KEY,"password") + "\nchecked : " + preferences.getBoolean(Config.Preferences.CHECKED_PREF_KEY,false);
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void onFileAction(View view) {
        Intent intent = new Intent(PersistenceActivity.this,FilePersistenceActivity.class);
        this.startActivity(intent);
    }

    private void onSharedPrefAction(View view) {
        Intent intent = new Intent(PersistenceActivity.this,SharedPreferenceActivity.class);
        this.startActivity(intent);
    }
}