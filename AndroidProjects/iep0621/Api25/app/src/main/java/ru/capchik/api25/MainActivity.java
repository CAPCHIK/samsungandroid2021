package ru.capchik.api25;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textViewId);
        TextView textView2 = (TextView) findViewById(R.id.buttonId);

        TextView textView3 = findViewById(R.id.textViewId);
        TextView textView4 = findViewById(R.id.buttonId);
    }


}