package ru.capchik.iep0621android.parallel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;

import android.content.res.Resources;
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

import ru.capchik.iep0621android.R;

public class TryParallelActivity extends AppCompatActivity {
    private static final String TAG = "TryParallelActivity";

    private int hardCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_parallel);

        Button networkButton = findViewById(R.id.network_button);
        networkButton.setOnClickListener(v -> {
            new Thread(() -> {
                String urlString = "https://7e83-37-230-157-10.ngrok.io/heroes";
                try {
                    Log.i(TAG, "start request");
                    URL url = new URL(urlString);
                    InputStream inputStream = url.openStream();
                    Scanner scanner = new Scanner(inputStream);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        Log.i(TAG, line);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        });


        Button hardCounterButton = findViewById(R.id.parallel_hard_counter);
        hardCounterButton.setOnClickListener(v -> {
            Log.i(TAG, String.format("click, thread %s",
                    Thread.currentThread().getName()));
            String resourceValue =
                    getResources().getString(R.string.parallel_hard_counter_text, ++hardCounter);
            Log.i(TAG, resourceValue);
            hardCounterButton.setText(resourceValue);
        });


        Handler handler = HandlerCompat.createAsync(Looper.getMainLooper());

        Button runThreadButton = findViewById(R.id.run_thread_button);
        TextView textView = findViewById(R.id.parallel_counter);
        textView.setText("Hello text");
        runThreadButton.setOnClickListener(v -> {
            Log.i(TAG, String.format("click, thread %s",
                    Thread.currentThread().getName()));
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i(TAG, String.format("thread %s i %d"
                            , Thread.currentThread().getName(), i));
                    final int localI = i;
                    handler.post(() -> {
                        Log.i(TAG, String.format("post handle in thread %s"
                                , Thread.currentThread().getName()));
                        textView.setText("Hello counter " + localI);
                    });
                }

            }, "background thread").start();
        });
    }
}