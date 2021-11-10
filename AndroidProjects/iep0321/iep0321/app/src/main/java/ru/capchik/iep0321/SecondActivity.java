package ru.capchik.iep0321;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";

    public static final String EXTRA_CHAT_ID = "chat_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.i(TAG, "onCreate");


        Intent intent = getIntent();
        String chatId = intent.getStringExtra(EXTRA_CHAT_ID);

        if (chatId == null) {
            Log.w(TAG, "Not found chat id, use '" + EXTRA_CHAT_ID + "' extra key");
            Toast.makeText(this,
                    "Can't show SecondActivity", Toast.LENGTH_LONG)
                    .show();
            finish();
            return;
        }

        TextView chatIdText =  findViewById(R.id.chat_id_text);
        chatIdText.setText(chatId);

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
}