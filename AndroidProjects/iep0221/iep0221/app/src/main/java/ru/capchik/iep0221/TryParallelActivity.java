package ru.capchik.iep0221;

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

public class TryParallelActivity extends AppCompatActivity {

    private static final String TAG = "TryParallelActivity";

    private int counter = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_parallel);

        printCurrentThread("onCreate");


        Button downloadButton = findViewById(R.id.download_button);
        downloadButton.setOnClickListener(v -> {
            String address = "http://10.0.2.2:3000/heroes";
            new Thread(() -> {
                try {
                    URL url = new URL(address);
                    InputStream inputStream = url.openStream();
                    Scanner scanner = new Scanner(inputStream);
                    while (scanner.hasNextLine()){
                        Log.i(TAG, scanner.nextLine());
                    }
                    Log.i(TAG, "DONE!!!!❤❤❤");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        });


        Button counterButton = findViewById(R.id.counter_button);
        TextView counterTextView = findViewById(R.id.counter_view);

        counterButton.setOnClickListener(v -> {
            counterTextView.setText(getResources().getString(R.string.counter_template, counter++));
        });


        Button button = findViewById(R.id.run_thread_button);
        TextView tv = findViewById(R.id.long_process_indicator);

        Handler handler = HandlerCompat.createAsync(Looper.getMainLooper());

        button.setOnClickListener(v -> {
            printCurrentThread("click listener");
            tv.setText("Starting...");
            new Thread(() -> {
                printCurrentThread("from worker");
                for (int i = 0; i < 10; i++) {
                    printCurrentThread("work iteration " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final int localI = i;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            printCurrentThread("from post");
                            tv.setText("Iteration: #" + localI);
                        }
                    });
//                    BackgroundWorkChangeText r = new BackgroundWorkChangeText(tv, i);
//                    handler.post(r);
                }
            }, "custom worker").start();
        });
    }

    private void printCurrentThread(String from) {
        Log.i(TAG, String.format("%s: thread name: %s id: %d",
                from, Thread.currentThread().getName(), Thread.currentThread().getId()));
    }
}