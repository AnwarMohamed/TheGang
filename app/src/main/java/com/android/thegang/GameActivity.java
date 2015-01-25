package com.android.thegang;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.view.GamePanel;


public class GameActivity extends Activity implements GestureDetector.OnGestureListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bitmaps.loadBitmapStore(this);

        gamePanel = new GamePanel(this);
        setContentView(gamePanel);

        gDetector = new GestureDetector(getBaseContext(), this);
    }

    private GestureDetector gDetector;
    private GamePanel gamePanel;

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d("GameActivity", "Destroying...");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.d("GameActivity", "Stopping...");
        super.onStop();
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onFling(MotionEvent start, MotionEvent finish, float xVelocity, float yVelocity) {
        gamePanel.onFling(start, finish, xVelocity, yVelocity);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gDetector.onTouchEvent(event);
    }
}