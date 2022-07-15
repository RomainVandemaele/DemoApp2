package be.bf.android.demoapp.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import be.bf.android.demoapp.R;
import be.bf.android.demoapp.databinding.ActivityFilePersistenceBinding;

public class FilePersistenceActivity extends AppCompatActivity {

    private ActivityFilePersistenceBinding binding;
    private final String path = "text.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFilePersistenceBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        binding.btnPersistenceFileDelete.setOnClickListener(this::onDeleteFileAction);
        binding.btnPersistenceFileSave.setOnClickListener(this::onSaveFileAction);
        binding.btnPersistenceFileDisplay.setOnClickListener(this::onDisplayFileAction);
    }

    private void onDisplayFileAction(View view) {
        BufferedReader bufferedReader = null;
        try(FileInputStream fis = openFileInput(this.path)) {
            bufferedReader = new BufferedReader(new InputStreamReader((fis)));
            StringBuilder message = new StringBuilder("File : \n");
            String line;
            while ( (line = bufferedReader.readLine()) != null) {
                message.append(line);
            }
            //bufferedReader.close();
            Toast.makeText(this,message.toString(),Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"file not found",Toast.LENGTH_LONG).show();
            //e.printStackTrace();
        }catch (IOException e) {
            Toast.makeText(this,"IOEXCEPTION " + e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    private void onSaveFileAction(View view) {
        try(FileOutputStream fos = openFileOutput(this.path,MODE_PRIVATE)) {
            BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(fos));
            fos.write(this.binding.etPersistenceFileText.getText().toString().getBytes());
            Toast.makeText(this,"File successfully saved ",Toast.LENGTH_LONG).show();
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(this,"file not found",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this,"IOEXCEPTION " + e.getMessage(),Toast.LENGTH_SHORT).show();
            //e.printStackTrace();
        }
    }

    private void onDeleteFileAction(View view) {
        try {
            Path path = Paths.get(getFilesDir()+ "/"+ this.path);
            if (Files.exists(Paths.get(getFilesDir()+ "/"+this.path))) {
                Log.d("DELETE", "onDeleteFileAction: EXISTS");
                Files.deleteIfExists(path);
            }
            Toast.makeText(this,"File succesfully deleted ",Toast.LENGTH_SHORT).show();
        }catch (Exception e) {
            Toast.makeText(this,"file not found",Toast.LENGTH_LONG).show();
        }
    }
}