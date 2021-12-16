package ru.capchik.iep0321.WorkWithParallel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import ru.capchik.iep0321.R;

public class TryParallelActivity extends AppCompatActivity {
    private static final String TAG = "TryParallelActivity";
    private int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_parallel);

        Button downloadButton = findViewById(R.id.download_button);
        downloadButton.setOnClickListener(v -> {
            new Thread(() -> {
                String address = "http://10.0.2.2:3000/heroes";
                try {
                    URL url = new URL(address);
                    InputStream inputStream = url.openStream();
                    Scanner scanner = new Scanner(inputStream);
                    while (scanner.hasNextLine()) {
                        Log.i(TAG, scanner.nextLine());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        });


        Button counterButton = findViewById(R.id.counter_button);
        TextView counterTextView = findViewById(R.id.counter_text_view);
        counterButton.setOnClickListener(v -> {
            String template = getResources()
                    .getString(R.string.counter_text, this.counter++);
            counterTextView.setText(template);
        });

        printCurrentThread("onCreate");
        Button startThreadButton = findViewById(R.id.start_thread_button);
        TextView threadProgressTextView = findViewById(R.id.thread_progress_text);

        Handler handler = HandlerCompat.createAsync(Looper.getMainLooper());

        startThreadButton.setOnClickListener(v -> {
            printCurrentThread("click");
            threadProgressTextView.setText("Started!!!");
            new Thread(() -> {
                TryParallelActivity.this.printCurrentThread("from thread");
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final int localI = i;
                    handler.post(() -> {
                        printCurrentThread("in post");
                        threadProgressTextView.setText("background work #" + localI);
                    });
                    printCurrentThread("background work #" + i);
                }
            }).start();
        });
    }

    private void printCurrentThread(String from) {
        Log.i(TAG, String.format("%s | thread: %s id: %d",
                from,
                Thread.currentThread().getName(),
                Thread.currentThread().getId()));
//        Log.i(TAG, Thread.currentThread().getThreadGroup().getName());
    }
}