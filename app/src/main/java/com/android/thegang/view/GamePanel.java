/*
 *  Copyright (C) 2015
 *                      Abdallah Elerian  <abdallah.elerian@gmail.com>
 *                      Ahmed Samir       <ahmedsamir.93@gmail.com>
 *                      Anwar Mohamed     <anwarelmakrahy@gmail.com>
 *                      Moataz Hammouda   <moatazhammouda4@gmail.com>
 *                      Yasmine Elhabashi <yasmine.elhabashi@gmail.com>
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to authors.
 *
 */

package com.android.thegang.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.android.thegang.GameActivity;
import com.android.thegang.assets.Bitmaps;
import com.android.thegang.controller.GameThread;
import com.android.thegang.elements.DecoratorFactory;
import com.android.thegang.elements.GiftFactory;
import com.android.thegang.elements.MonsterFactory;
import com.android.thegang.model.Block;
import com.android.thegang.model.decorators.CloudBlock;
import com.android.thegang.model.decorators.DecoratorBlock;
import com.android.thegang.model.decorators.FloorBlock;
import com.android.thegang.model.gangsters.GangsterBlock;
import com.android.thegang.model.gangsters.NinjaGangsterBlock;
import com.android.thegang.model.gifts.GiftBlock;
import com.android.thegang.model.monsters.FireBlock;
import com.android.thegang.model.monsters.MonsterBlock;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import static com.android.thegang.controller.GameThread.getRandom;
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

    private int groundSpeed = 15;

    private GameActivity gameActivity;
    private boolean pauseGround = false;
    private boolean gameOver = false;
    private boolean monsterMode = false;

    private int coinsScore = 0;
    private int lifeScore = 5;

    private Queue<Block> removeQueue = new ArrayDeque<Block>();
    private Queue<Block> addQueue = new ArrayDeque<Block>();

    public GamePanel(GameActivity activity) {
        super(activity);

        getHolder().addCallback(this);
        updateWindowState(activity);
        setFocusable(true);

        gameActivity = activity;
        gameThread = new GameThread(getHolder(), this);

        bgPaint.setColor(Color.rgb(0xB8, 0xDB, 0xFF));

        addFloorBlock();
        addCloudBlocks();
        addDecoratorBlocks();
        addGiftBlocks();
        addMonsters();
        addGangsterBlock();

        coinPaint.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.BOLD));
        coinPaint.setTextSize(45);
    }

    private void addMonsters() {
        int oldX = (getRandom(screenXMax * 2));
        for (int i = 0; i < 6; i++) {
            viewBlocks.add(MonsterFactory.makeMonster(
                    MonsterFactory.MONSTER_TYPE_RANDOM, screenXMax, screenYMax));
            viewBlocks.get(viewBlocks.size() - 1).setX(oldX);
            oldX += max(getRandom(screenXMax * 2), 200);
        }

    }

    private void addDecoratorBlocks() {
        for (int i = 0; i < 6; i++) {
            viewBlocks.add(DecoratorFactory.makeDecor(
                    getRandom(screenXMax * 2),
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

    private void addGiftBlocks() {
        int oldX = (getRandom(screenXMax * 2));
        for (int i = 0; i < 15; i++) {
            viewBlocks.add(GiftFactory.makeGift(
                    GiftFactory.GIFT_TYPE_RANDOM, oldX, screenYCenter, screenXMax));
            oldX += max(getRandom(screenXMax * 2), 120);
        }
    }

    private void addGangsterBlock() {
        gangsterBlock = new NinjaGangsterBlock(
                screenXCenter * 2 / 3 - Bitmaps.gangster0_idle[0].getWidth(),
                screenYMax - screenYOffset - Bitmaps.gangster0_idle[0].getHeight());

        gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_RUN);
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

    private void gameOver(Canvas canvas) {

        gamePaint.setTypeface(Typeface.create(Typeface.MONOSPACE, Typeface.BOLD));
        gamePaint.setTextSize(150);

        int xPos = screenXCenter - 400;
        int yPos = (int) (screenYCenter - ((gamePaint.descent() + gamePaint.ascent()) / 2));

        canvas.drawText("GAME OVER", xPos, yPos, gamePaint);
    }

    private Paint bgPaint = new Paint();
    private Paint gamePaint = new Paint();

    private int intersectDelay = 0;

    public void doDraw(Canvas canvas) {
        if (canvas != null) {
            canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), bgPaint);

            for (Block block : viewBlocks) {
                if (block instanceof FloorBlock || block instanceof DecoratorBlock ||
                        block instanceof GiftBlock) {
                    block.setXSpeed(pauseGround ? 0 : groundSpeed);
                }

                if (block instanceof GiftBlock) {
                    if (gangsterBlock.intersects(block)) {
                        coinsScore += block.catchMe();
                    }
                } else if (block instanceof MonsterBlock) {
                    MonsterBlock monsterBlock = (MonsterBlock) block;
                    if (gangsterBlock.intersects(block)) {
                        if (gangsterBlock.getState() == GangsterBlock.GANGSTER_STATE_ATTACK) {
                            monsterBlock.getCaught();
                        } else {
                            monsterBlock.getCaught();

                            if (--lifeScore == 0) {
                                gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_DYING);
                            }
                        }
                    } else {

                        if (getRandom(screenXMax) > block.getX()) {
                            if (monsterBlock.canFire(gangsterBlock.getX(), gangsterBlock.getY())) {
                                addQueue.add(monsterBlock.fire());
                            }
                        }
                    }
                } else if (block instanceof FireBlock) {
                    FireBlock fireBlock = (FireBlock) block;

                    if (gangsterBlock.intersects(block)) {
                        if (gangsterBlock.getState() == GangsterBlock.GANGSTER_STATE_ATTACK) {
                            removeQueue.add(block);
                        } else {

                            removeQueue.add(block);

                            if (--lifeScore == 0) {
                                gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_DYING);
                            }
                        }
                    } else if (fireBlock.getState() == FireBlock.FIRE_STATE_IDLE) {
                        removeQueue.add(block);
                    }
                }

                block.doDraw(canvas);
            }

            while (!addQueue.isEmpty()) {
                viewBlocks.add(addQueue.remove());
            }

            while (!removeQueue.isEmpty()) {
                viewBlocks.remove(removeQueue.remove());
            }

            int oldX = screenXMax - 10;
            for (int i = 0; i < lifeScore; i++) {
                canvas.drawBitmap(Bitmaps.info_life, oldX - Bitmaps.info_life.getWidth(), 20, null);
                oldX -= 60;
            }

            canvas.drawBitmap(Bitmaps.info_coin, 10, 20, null);
            canvas.drawText("x" + coinsScore, 75, 65, coinPaint);

            if (gangsterBlock.getState() == GangsterBlock.GANGSTER_STATE_DIED) {
                gameOver = true;
                pauseGround = true;
            }

            if (gameOver) {
                gameOver(canvas);
            } else {
                gangsterBlock.doDraw(canvas);
                pauseGround = gangsterBlock.getState() == GangsterBlock.GANGSTER_STATE_ATTACK ||
                        gangsterBlock.getState() == GangsterBlock.GANGSTER_STATE_DYING;
            }

            if ((coinsScore + 1)% 5 == 0) {
                MonsterBlock girlMonsterBlock = MonsterFactory.makeMonster(
                        MonsterFactory.MONSTER_TYPE_GIRL, screenXMax, screenYMax);
                girlMonsterBlock.setXSpeed(0);
                girlMonsterBlock.setYSpeed(0);

                viewBlocks.add(girlMonsterBlock);

                pauseGround = true;
                monsterMode = true;

                gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_IDLE);
            }
        }
    }

    private Paint coinPaint = new Paint();

    public void onFling(MotionEvent start, MotionEvent finish, float xVelocity, float yVelocity) {
        if (start.getRawY() >= finish.getRawY()) {
            if (gangsterBlock != null) {
                switch (gangsterBlock.getState()) {
                    case GangsterBlock.GANGSTER_STATE_RUN:
                        gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_JUMP);
                        break;
                }
            }
        } else {
            if (gangsterBlock != null) {
                switch (gangsterBlock.getState()) {
                    case GangsterBlock.GANGSTER_STATE_RUN:
                        gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_SLIDE);
                        break;
                }
            }
        }
    }

    public void onSingleTapUp(MotionEvent motionEvent) {
        if (gameOver) {
            gameActivity.finish();
        } else {
            if (gangsterBlock != null) {
                switch (gangsterBlock.getState()) {
                    case GangsterBlock.GANGSTER_STATE_RUN:
                        gangsterBlock.setState(GangsterBlock.GANGSTER_STATE_ATTACK);
                        break;
                }
            }
        }
    }
}
