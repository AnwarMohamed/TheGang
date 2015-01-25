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
import com.android.thegang.model.CloudBlock;
import com.android.thegang.model.DecoratorBlock;
import com.android.thegang.model.FloorBlock;
import com.android.thegang.model.GangsterBlock;
import com.android.thegang.model.GiftBlock;
import com.android.thegang.model.NinjaGangsterBlock;
import com.android.thegang.model.RockBlock;
import com.android.thegang.model.YellowCoinsBlock;

import java.util.ArrayList;

import static java.lang.Math.max;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread gameThread = null;
    private GangsterBlock gangsterBlock;
    private ArrayList<Block> viewBlocks = new ArrayList<Block>();

    private int screenXMax = 0;
    private int screenYMax = 0;
    private int screenXCenter = 0;
    private int screenYCenter = 0;
    private int screenXOffset = 0;
    private int screenYOffset = 0;

    private int groundSpeed = 30;

    private GameActivity gameActivity;
    private boolean pauseGround = false;

    public GamePanel(GameActivity activity) {
        super(activity);

        getHolder().addCallback(this);
        updateWindowState(activity);
        setFocusable(true);

        gameActivity = activity;
        gameThread = new GameThread(getHolder(), this);

        gangsterBlock = new NinjaGangsterBlock(
                screenXCenter * 2 / 3 - Bitmaps.gangster0_idle[0].getWidth(),
                screenYMax - screenYOffset - Bitmaps.gangster0_idle[0].getHeight(),
                Bitmaps.gangster0_idle[0]);

        bgPaint.setColor(Color.rgb(0xB8, 0xDB, 0xFF));


        addFloorBlock();
        addCloudBlocks();
        //addRockBlocks();
        addMiscBlocks();
        addGiftBlocks();
        addGangsterBlock();

        gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_RUN);
        viewBlocks.add(gangsterBlock);
    }

    private void addMiscBlocks() {
        for (int i = 0; i < 6; i++) {
            viewBlocks.add(new DecoratorBlock(
                    GameThread.random.nextInt(31) % (screenXMax * 2),
                    screenYMax - screenYOffset + 15, screenXMax));
        }
    }

    private void addFloorBlock() {
        FloorBlock floorBlock = new FloorBlock(screenXMax, screenYMax - screenYOffset - 5);
        floorBlock.setXSpeed(groundSpeed);
        viewBlocks.add(floorBlock);
    }

    private void addCloudBlocks() {
        for (int i = 0; i < 6; i++) {
            viewBlocks.add(new CloudBlock(screenXMax, screenYCenter * 2 / 3));
        }
    }

    private void addRockBlocks() {
        for (int i = 0; i < 6; i++) {
            viewBlocks.add(new RockBlock(
                    GameThread.random.nextInt(31) % (screenXMax * 2),
                    screenYMax - screenYOffset, screenXMax));
        }
    }

    private void addGiftBlocks() {
        int oldX = (GameThread.random.nextInt(31) % (screenXMax * 2));
        for (int i = 0; i < 8; i++) {
            viewBlocks.add(new YellowCoinsBlock(oldX, screenYCenter, screenXMax));
            oldX += max(GameThread.random.nextInt(31) % (screenXMax * 2), 120);
        }
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
            canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), bgPaint);

            for (Block block : viewBlocks) {
                if (block instanceof FloorBlock || block instanceof RockBlock ||
                        block instanceof DecoratorBlock || block instanceof GiftBlock) {
                    block.setXSpeed(pauseGround ? 0 : groundSpeed);
                } else if (block instanceof GangsterBlock) {
                    GangsterBlock gangsterBlock = (GangsterBlock) block;
                    pauseGround = (gangsterBlock.getState() == GangsterBlock.GANGSTER_STATE_ATTACK);
                }

                block.doDraw(canvas);
            }
        }
    }

    public void onFling(MotionEvent start, MotionEvent finish, float xVelocity, float yVelocity) {
        if (start.getRawY() >= finish.getRawY()) {
            if (gangsterBlock != null) {
                switch (gangsterBlock.getState()) {
                    case GangsterBlock.GANGSTER_STATE_RUN:
                        gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_JUMP);
                        break;
                }
            }
        }
    }

    public void onSingleTapUp(MotionEvent motionEvent) {
        if (gangsterBlock != null) {
            switch (gangsterBlock.getState()) {
                case GangsterBlock.GANGSTER_STATE_RUN:
                    gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_ATTACK);
                    break;
            }
        }
    }
}
