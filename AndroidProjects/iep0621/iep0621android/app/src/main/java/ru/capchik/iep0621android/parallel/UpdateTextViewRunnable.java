package ru.capchik.iep0621android.parallel;

import android.util.Log;
import android.widget.TextView;

public class UpdateTextViewRunnable implements Runnable {

    private final String TAG;
    private final TextView textView;
    private final int localI;

    public UpdateTextViewRunnable(String TAG,
                                  TextView textView,
                                  int localI){
        this.TAG = TAG;
        this.textView = textView;
        this.localI = localI;
    }

    @Override
    public void run() {
        Log.i(TAG, String.format("post handle in thread %s"
                , Thread.currentThread().getName()));
        textView.setText("Hello counter from my class " + localI);
    }
}
