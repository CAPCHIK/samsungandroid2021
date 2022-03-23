package ru.capchik.iep0321;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ExampleView extends View {
    private static final String TAG = "ExampleView";
    public ExampleView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 0x A-FF R-FF G-00 B-00
        canvas.drawColor(Color.RED);

        Paint paint = new Paint();
//        paint./

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        paint.setColor(Color.BLUE);
        canvas.drawCircle(xCenter, yCenter,
                Math.min(getWidth(), getHeight()) * 0.4f, paint);
        paint.setColor(Color.WHITE);
        paint.setTextSize(60);
        paint.setSubpixelText(false);
        for (int i = 0; i < 360; i += 360 / 36) {
            canvas.rotate(360 / 36, xCenter, yCenter);
            canvas.drawText("Hello world",xCenter, yCenter, paint);
        }

        Log.d(TAG, "draw!");
    }
}
