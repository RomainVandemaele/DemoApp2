
package be.bf.android.demoapp.persistence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.List;

import be.bf.android.demoapp.R;
import be.bf.android.demoapp.configs.Config;
import be.bf.android.demoapp.databinding.ActivityPersistenceBinding;

import be.bf.android.demoapp.persistence.dal.UserDAO;
import be.bf.android.demoapp.persistence.entities.User;
import io.reactivex.rxjava3.core.Single;

import static be.bf.android.demoapp.configs.Config.DBLite;

public class PersistenceActivity extends AppCompatActivity {

    ActivityPersistenceBinding binding;
    //private AppDatabase appDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersistenceBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        binding.btnPersistenceSharedPref.setOnClickListener(this::onSharedPrefAction);
        binding.btnPersistenceFile.setOnClickListener(this::onFileAction);


        try (UserDAO dao = new UserDAO(this)) {
            dao.openWritable();
            //dao.insert(new User(binding.email.getText().toString(), binding.password.getText().toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //getApplicationContext().getApplicationContext().deleteDatabase(DBLite.DB_NAME);

//        this.appDB = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, DBLite.DB_NAME).build();
//        UserDAO userDAO = this.appDB.userDAO();
//        User user = new User("Romain","Vandemale");
//        userDAO.insertAll(user);
//
//        //DatabaseThread thread = new DatabaseThread();
//        //thread.setDao(userDAO);
//        //thread.start();
//
//        //userDAO.insertAll(user);
//        Single<List<User>> users = userDAO.getAll();
//        List<User> userlist = users.blockingGet();
//        Log.d("YEP", String.valueOf(userlist.size()));

    }



    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String message = "email : " + preferences.getString(Config.Preferences.EMAIL_PREF_KEY,"you@home.be") + "\n password : " + preferences.getString(Config.Preferences.PASSWORD_PREF_KEY,"password") + "\nchecked : " + preferences.getBoolean(Config.Preferences.CHECKED_PREF_KEY,false);
        //Snackbar.make(binding.layoutPersistence,message, Snackbar.LENGTH_SHORT).show();
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