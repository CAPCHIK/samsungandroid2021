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
        SomeClass2 some = (SomeClass2) getSome();

        SomeClass2 arg = getSome2();
        doWork(getSome2());
    }

    private void doWork(SomeClass2 sc2) {

    }

    private SomeClass getSome(){ return new SomeClass2(); }
    private <T extends SomeClass> T getSome2(){ return null; }
    class SomeClass{}
    class SomeClass2 extends SomeClass{}
}