package ru.capchik.iep0221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText firstValueEdit;
    private EditText secondValueEdit;

    private Button plusButton;
    private Button minusButton;

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupCalculator();

        Button goToSecondActivity = findViewById(R.id.go_to_second_activity);
        goToSecondActivity.setOnClickListener(v -> {
            Intent startSecondActivity = new Intent(this,
                    SecondActivity.class);
            startSecondActivity.putExtra("chatId", "some_chat_identifier");
            startActivity(startSecondActivity);
        });

        Button openUri = findViewById(R.id.open_uri);
        openUri.setOnClickListener(v -> {
            Uri uri = Uri.parse("http://vk.com/rtuitlab");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            ComponentName componentName = intent.resolveActivity(getPackageManager());
            Log.d(TAG, componentName.toString());
            if (componentName != null) {
                startActivity(intent);
            } else {
                Log.w(TAG, "Sorry");
            }
        });
        Button shareText = findViewById(R.id.share_text);
        EditText shareEditText = findViewById(R.id.share_edit_text);
        shareText.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, shareEditText.getText().toString());
            intent.setType("text/plain"); // MIME type

            Intent share = Intent.createChooser(intent, "Share");

            startActivity(share);
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    private void setupCalculator() {
        firstValueEdit = findViewById(R.id.first_value_edit);
        secondValueEdit = findViewById(R.id.second_value_edit);

        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);

        resultText = findViewById(R.id.result_text);

        plusButton.setOnClickListener(v -> calculateResults((a, b) -> a + b));
        minusButton.setOnClickListener(v -> calculateResults((a, b) -> a - b));
    }

    private void calculateResults(CalculationAction action) {
        try {
            int firstArgument = Integer.parseInt(firstValueEdit.getText().toString());
            int secondArgument = Integer.parseInt(secondValueEdit.getText().toString());
            int result = action.calculate(firstArgument, secondArgument);
            resultText.setText("" + result);
        } catch (NumberFormatException numberFormatException) {
            Log.w(TAG, "can't calculate result", numberFormatException);
            Toast.makeText(this, "Please type correct values", Toast.LENGTH_LONG)
                    .show();
        }
    }

    private interface CalculationAction {
        int calculate(int firstArgument, int secondArgument);
    }
}