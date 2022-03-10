package ru.capchik.iep0321;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WorkWithServicesActivity extends AppCompatActivity {
    private static final String TAG = "WorkWithServices";

    private int lastId = 1;
    private TextView textView;
    private CommentsResultHandler commentsResultHandler
            = new CommentsResultHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_with_services);

        Button b = findViewById(R.id.button);
        textView = findViewById(R.id.textView2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        WorkWithServicesActivity.this,
                        ExampleIntentService.class);
                intent.putExtra("id", lastId++);
                Messenger messenger = new Messenger(commentsResultHandler);
                intent.putExtra("messenger", messenger);
                WorkWithServicesActivity.this.startService(intent);
            }
        });
    }
    private class CommentsResultHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.i(TAG, "received message arg1 is " + msg.arg1);
            Bundle data = msg.getData();
            String output = data.getString("output");
            textView.setText(output);
        }
    }
}