package ru.capchik.iep0221;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class WorkWithServicesActivity extends AppCompatActivity {
    private static final String TAG = "WorkWithServices";

    private GetCommentHandler handler = new GetCommentHandler();
    private TextView textView;
    private int lastCommentId = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_with_services);
        textView = findViewById(R.id.textView2);
        getComment(lastCommentId++);
        getComment(lastCommentId++);

        Button button = findViewById(R.id.button);
        button.setOnClickListener((v) -> {
            getComment(lastCommentId++);
        });
    }


    private void getComment(int commentId) {
        Intent intent = new Intent(this, ExampleService.class);
        intent.putExtra("id", commentId);
        intent.putExtra("handler", new Messenger(handler));
        startService(intent);
    }


    private class GetCommentHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.i(TAG, "message received " + msg.arg1);
            textView.setText("message received " + msg.arg1);
        }
    }
}