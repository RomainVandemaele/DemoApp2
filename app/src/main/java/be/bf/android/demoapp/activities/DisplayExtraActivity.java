package be.bf.android.demoapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import be.bf.android.demoapp.R;
import be.bf.android.demoapp.databinding.ActivityDisplayExtraBinding;

public class DisplayExtraActivity extends AppCompatActivity {

    private ActivityDisplayExtraBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayExtraBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle extra = this.getIntent().getExtras();
        if(extra != null) {
            //Log.d("EXTRA",extra.getString("text"));
            binding.tvExtraDisplay.setText(extra.getString("text").toString());
        }
    }
}