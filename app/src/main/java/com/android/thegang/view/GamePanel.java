package com.android.thegang.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.android.thegang.GameActivity;
import com.android.thegang.assets.Bitmaps;
import com.android.thegang.controller.GameThread;
import com.android.thegang.model.Block;
import com.android.thegang.model.Cloud;
import com.android.thegang.model.Floor;
import com.android.thegang.model.Gangster;
import com.android.thegang.model.NinjaGangster;

import java.util.ArrayList;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread gameThread = null;
    private Gangster gangster;
    private ArrayList<Block> viewBlocks = new ArrayList<Block>();

    private int screenXMax = 0;
    private int screenYMax = 0;
    private int screenXCenter = 0;
    private int screenYCenter = 0;
    private int screenXOffset = 0;
    private int screenYOffset = 0;

    private int groundSpeed = 40;

    private GameActivity gameActivity;

    public GamePanel(GameActivity activity) {
        super(activity);

        getHolder().addCallback(this);
        updateWindowState(activity);
        setFocusable(true);

        gameActivity = activity;
        gameThread = new GameThread(getHolder(), this);

        gangster = new NinjaGangster(
                screenXCenter * 2 / 3 - Bitmaps.gangster0_idle[0].getWidth(),
                screenYMax - screenYOffset - Bitmaps.gangster0_idle[0].getHeight(),
                Bitmaps.gangster0_idle[0]);

        bgPaint.setColor(Color.rgb(0xB8, 0xDB, 0xFF));

        addFloorBlock();
        addCloudBlocks();
        addRockBlocks();
        addGistBlocks();
        addGangsterBlock();

        gangster.setState(Gangster.GANGSTER_STATE_RUN);
        viewBlocks.add(gangster);
    }

    private void addFloorBlock() {
        Floor floor = new Floor(screenXMax, screenYMax - screenYOffset);
        floor.setXSpeed(groundSpeed);
        viewBlocks.add(floor);
    }

    private void addCloudBlocks() {
        for (int i = 0; i < 6; i++) {
            viewBlocks.add(new Cloud(screenXMax, screenYCenter * 2 / 3));
        }
    }

    private void addRockBlocks() {

    }

    private void addGistBlocks() {

    }

    private void addGangsterBlock() {

    }

    private void updateWindowState(GameActivity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        screenXMax = display.getWidth();
        screenYMax = display.getHeight();
        screenXCenter = (screenXMax / 2);
        screenYCenter = (screenYMax / 2);
        screenYOffset = 50;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                gameThread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }

    private Paint bgPaint = new Paint();

    public void doDraw(Canvas canvas) {
        if (canvas != null) {

            /* Draw Background */
            canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), bgPaint);

            for (Block block : viewBlocks) {
                block.doDraw(canvas);
            }
        }
    }

    public void onFling(MotionEvent start, MotionEvent finish, float xVelocity, float yVelocity) {
        if (start.getRawY() >= finish.getRawY()) {
            if (gangster != null) {
                gangster.setState(Gangster.GANGSTER_STATE_JUMP);
            }
        }
    }
}
