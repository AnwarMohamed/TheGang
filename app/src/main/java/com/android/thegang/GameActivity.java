package com.android.thegang;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.view.GamePanel;


public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bitmaps.loadBitmapStore(this);
        setContentView(new GamePanel(this));
    }

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
}