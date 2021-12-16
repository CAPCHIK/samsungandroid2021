package ru.capchik.iep0321;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import ru.capchik.iep0321.WorkWithParallel.TryParallelActivity;

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
        // Только для практики, чтобы не тратить время
        // Делать так всегда - низя
        startActivity(new Intent(this, TryParallelActivity.class));
        if (true) {
            return;
        }
        ///

        setupCalculator();

        Button openSecondActivity= findViewById(R.id.open_second_activity_extra);
        openSecondActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra(SecondActivity.EXTRA_CHAT_ID, "some_chat_id");

            startActivity(intent);
        });
        Button openSecondActivityNoExtra = findViewById(R.id.open_second_activity_no_extra);
        openSecondActivityNoExtra.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });

        Button openUri = findViewById(R.id.openUri);
        openUri.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://t.me/joinchat/zMXSWGZ6tpUyYzYy");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        EditText textToShare = findViewById(R.id.text_to_share);
        textToShare.setText("TEXT: " + new Random().nextInt());
        Button shareTextButton = findViewById(R.id.share_text);
        shareTextButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, textToShare.getText().toString());
            intent.setType("text/plain"); // MIME TYPE

            Intent share_message = Intent.createChooser(intent, "Share message");

            startActivity(share_message);

        });



    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
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
        firstValueEdit = findViewById(R.id.first_value);
        secondValueEdit = findViewById(R.id.second_value);
        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        resultText = findViewById(R.id.result_text);

        plusButton.setOnClickListener(v -> calculateResult((a, b) -> a + b));
        minusButton.setOnClickListener(v -> calculateResult(new MinusAction()));
    }

    private void calculateResult(CalculateAction action) {
        try {
            int firstValue = Integer.parseInt(firstValueEdit.getText().toString());
            int secondValue = Integer.parseInt(secondValueEdit.getText().toString());

            int result = action.calculate(firstValue, secondValue);

            resultText.setText("" + result);
        } catch (NumberFormatException ex) {
            Log.w(TAG, "can't calculate results", ex);
            resultText.setText("Please type two correct values");
        }
    }

    private interface CalculateAction {
        int calculate(int first, int second);
    }
    private class MinusAction implements CalculateAction {
        @Override
        public int calculate(int first, int second) {
            return first - second;
        }
    }
}