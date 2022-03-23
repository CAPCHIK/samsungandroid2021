package ru.capchik.iep0321;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class LearnDrawActivity extends AppCompatActivity {
    private static final String TAG = "LearnDrawActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View customView = new ExampleView(this.getApplicationContext());
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(customView);
        setContentView(new CustomSurfaceView(getApplicationContext()));

        Log.d(TAG, "draw activity");
//        setContentView(R.layout.activity_learn_draw);
    }
}