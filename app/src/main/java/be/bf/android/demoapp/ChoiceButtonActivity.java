package be.bf.android.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceButtonActivity extends AppCompatActivity {

    private Button btnValidate;
    private Button btnCancelled;

    private static final int RESULT_VALIDATED = 2;
    private static final int RESULT_CANCELLED = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_button);

        btnValidate = findViewById(R.id.btn_choiceButton_validate);
        btnValidate.setOnClickListener(this::clickValidate);
        btnCancelled = findViewById(R.id.btn_choiceButton_cancel);
        btnCancelled.setOnClickListener(this::clickCancel);
    }

    public void  clickCancel(View view) {
        setResult(RESULT_CANCELLED);
        finish();
    }

    public void  clickValidate(View view) {
        setResult(RESULT_VALIDATED);
        finish();
    }
}