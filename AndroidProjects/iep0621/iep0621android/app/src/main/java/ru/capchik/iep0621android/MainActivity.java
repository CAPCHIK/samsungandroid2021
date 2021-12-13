package ru.capchik.iep0621android;

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

import ru.capchik.iep0621android.parallel.TryParallelActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText firstText;
    private EditText secondText;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "current thread name: " + Thread.currentThread().getName() +
                " current thread id : " + Thread.currentThread().getId());

        setContentView(R.layout.activity_main);

        /// В рамках практики 2021.12.13 нам нужен сразу второй экран
        startActivity(new Intent(this, TryParallelActivity.class));
        if (true) {
            return;
        }
        ///

        Button activity2Button = findViewById(R.id.start_second_activity_button);
        activity2Button.setOnClickListener(v -> {
            Log.i(TAG, "BUTTON  !!! current thread name: " + Thread.currentThread().getName() +
                    " current thread id : " + Thread.currentThread().getId());

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("some_value", "Hello from extra");
            startActivity(intent);
        });

        Button anotherIntent = findViewById(R.id.another_intent);
        anotherIntent.setOnClickListener(v -> {
            Uri address = Uri.parse("https://rtuitlab.dev");
            Intent intent = new Intent(Intent.ACTION_VIEW, address);

            ComponentName componentName = intent.resolveActivity(getPackageManager());
            Log.i(TAG, componentName.toString());
            if (componentName != null) {
                startActivity(intent);
            } else {
                Log.d(TAG, "Not found component");
            }
        });

        Button sendText = findViewById(R.id.send_text);
        sendText.setOnClickListener(v -> {

            Intent sendTextIntent = new Intent(Intent.ACTION_SEND);
            sendTextIntent.putExtra(Intent.EXTRA_TEXT, "Text to share");
            sendTextIntent.setType("text/plain"); // MIME тип

            sendTextIntent.putExtra(Intent.EXTRA_TITLE, "Поделиться!!!");

            Intent shareIntent = Intent.createChooser(sendTextIntent, "Заголовок?");
            startActivity(shareIntent);
        });

        setupCalculator();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "activity pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "activity stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "activity start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "activity resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "activity restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "activity destroy");
    }

    private void setupCalculator() {
        Button minusButton = findViewById(R.id.minus_button);
        Button plusButton = findViewById(R.id.plus_button);

        firstText = findViewById(R.id.first_number);
        secondText = findViewById(R.id.second_number);

        resultText = findViewById(R.id.result_text);

        minusButton.setOnClickListener(v -> handleCalculation((a, b) -> a - b));
        plusButton.setOnClickListener(v -> handleCalculation((a, b) -> a + b));
    }

    private void handleCalculation(NumbersAction action) {
        try {
            int firstArgument = Integer.parseInt(firstText.getText().toString());
            int secondArgument = Integer.parseInt(secondText.getText().toString());
            resultText.setText(getString(R.string.result_is) + action.action(firstArgument, secondArgument));
        } catch (Exception exception) {
            Log.w(TAG, "incorrect user input", exception);
            Toast
                .makeText(this, "Проверьте правильность введенных значений", Toast.LENGTH_LONG)
                .show();
        }
    }
    private interface NumbersAction {
        int action(int arg1, int arg2);
    }
}