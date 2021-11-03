package ru.capchik.iep0621android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String extra = intent.getStringExtra("some_value");
        Log.d(TAG, "extra is " + extra);
        if (extra == null) {
            Toast.makeText(this, "Невозможно отобразить данные", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        TextView textView = findViewById(R.id.text_for_extra);
        textView.setText(extra);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "activity destroy");
    }
}