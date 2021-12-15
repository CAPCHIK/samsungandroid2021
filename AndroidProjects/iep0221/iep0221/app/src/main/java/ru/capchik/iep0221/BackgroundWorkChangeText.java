package ru.capchik.iep0221;

import android.widget.TextView;

public class BackgroundWorkChangeText implements Runnable {
    private TextView tv;
    private int i;

    public BackgroundWorkChangeText(TextView tv, int i) {
        this.tv = tv;
        this.i = i;
    }

    @Override
    public void run() {
        tv.setText("Iteration: #" + i);
    }
}
