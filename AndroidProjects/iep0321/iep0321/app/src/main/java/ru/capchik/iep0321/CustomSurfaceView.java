package ru.capchik.iep0321;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.Calendar;

public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "CustomSurfaceView";

    public CustomSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        calendar = Calendar.getInstance();
    }

    private final int frameLength = 0; // 1000 / 30
    private long nextFrameTime;
    private final Calendar calendar;
    private Thread loopThread;
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Log.d(TAG, "created");
        loopThread = new Thread(() -> {
            try {
                while (!loopThread.isInterrupted()) {
                    long currentTime = calendar.getTimeInMillis();
                    if (currentTime < nextFrameTime) {
                        Thread.sleep(nextFrameTime - currentTime);
                    }
                    nextFrameTime = calendar.getTimeInMillis() + frameLength;
                    Canvas canvas = holder.lockCanvas();
                    if (canvas == null) {
                        continue;
                    }
                    renderFrame(canvas);
                    holder.unlockCanvasAndPost(canvas);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "RenderGameLoop");
        loopThread.start();

    }
    private Paint paint = new Paint();
    private final int circleColor = Color.parseColor("#009933");

    private int circleX;
    private int circleY;
    private float circleSpeed = 0.1f;
    private int touchX;
    private int touchY;
    private void renderFrame(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        paint.setColor(circleColor);

        circleX += (touchX - circleX) * circleSpeed;
        circleY += (touchY - circleY) * circleSpeed;
        canvas.drawCircle(circleX, circleY, 40, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = Math.round(event.getX());
        touchY = Math.round(event.getY());
        return true;
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        circleX = width / 2;
        circleY = height / 2;
        Log.d(TAG, "changed");
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        Log.d(TAG, "destroyed");
        loopThread.interrupt();
    }
}
