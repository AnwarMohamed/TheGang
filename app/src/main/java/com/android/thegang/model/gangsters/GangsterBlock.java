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

package com.android.thegang.model.gangsters;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.android.thegang.model.Block;
import com.android.thegang.model.SpriteBlock;

public abstract class GangsterBlock extends SpriteBlock {

    public GangsterBlock(int x, int y, Bitmap[] bitmaps) {
        super(x, y, bitmaps, true);
        originalX = x;
        originalY = y;
    }

    private Bitmap[] runBitmaps = null;
    private Bitmap[] jumpBitmaps = null;
    private Bitmap[] attackBitmaps = null;

    public Bitmap[] getSlideBitmaps() {
        return slideBitmaps;
    }

    public void setSlideBitmaps(Bitmap[] slideBitmaps) {
        this.slideBitmaps = slideBitmaps;
    }

    private Bitmap[] slideBitmaps = null;

    private int originalX, originalY;

    public Bitmap[] getAttackBitmaps() {
        return attackBitmaps;
    }

    public void setAttackBitmaps(Bitmap[] attackBitmaps) {
        this.attackBitmaps = attackBitmaps;
    }

    public final static int GANGSTER_STATE_IDLE = 0;
    public final static int GANGSTER_STATE_RUN = 1;
    public final static int GANGSTER_STATE_JUMP = 2;
    public final static int GANGSTER_STATE_ATTACK = 3;
    public final static int GANGSTER_STATE_SLIDE = 4;
    public final static int GANGSTER_STATE_DYING = 5;

    public Bitmap[] getRunBitmaps() {
        return runBitmaps;
    }

    public void setRunBitmaps(Bitmap[] runBitmaps) {
        this.runBitmaps = runBitmaps;
    }

    public Bitmap[] getJumpBitmaps() {
        return jumpBitmaps;
    }

    public void setJumpBitmaps(Bitmap[] jumpBitmaps) {
        this.jumpBitmaps = jumpBitmaps;
    }

    @Override
    public void doDraw(Canvas canvas) {
        switch (state) {
            case GANGSTER_STATE_IDLE:
                stateIndex = (stateIndex + 1) % idleBitmaps.length;
                canvas.drawBitmap(idleBitmaps[stateIndex], getX(), getY(), null);

                setWidth(idleBitmaps[stateIndex].getWidth());
                setHeight(idleBitmaps[stateIndex].getHeight());

                break;
            case GANGSTER_STATE_JUMP:
                stateIndex = (stateIndex + 1) % jumpBitmaps.length;
                canvas.drawBitmap(jumpBitmaps[stateIndex], getX(), getY(), null);
                setY(getY() + (45 * (stateIndex < jumpBitmaps.length / 2 ? -1 : 1)));
                setX(getX() + 15);

                setWidth(jumpBitmaps[stateIndex].getWidth());
                setHeight(jumpBitmaps[stateIndex].getHeight());

                if (stateIndex == 0) {
                    setState(GANGSTER_STATE_RUN);
                }
                break;
            case GANGSTER_STATE_RUN:
                stateIndex = (stateIndex + 1) % runBitmaps.length;
                canvas.drawBitmap(runBitmaps[stateIndex], getX(), getY(), null);
                setX(getX() > originalX ? getX() - 50 : originalX);

                setWidth(runBitmaps[stateIndex].getWidth());
                setHeight(runBitmaps[stateIndex].getHeight());

                break;
            case GANGSTER_STATE_ATTACK:
                stateIndex = (stateIndex + 1) % attackBitmaps.length;
                canvas.drawBitmap(attackBitmaps[stateIndex], getX(), getY(), null);

                setWidth(attackBitmaps[stateIndex].getWidth());
                setHeight(attackBitmaps[stateIndex].getHeight());

                if (stateIndex == 0) {
                    setState(GANGSTER_STATE_RUN);
                }
                break;
            case GANGSTER_STATE_SLIDE:
                stateIndex = (stateIndex + 1) % slideBitmaps.length;
                canvas.drawBitmap(slideBitmaps[stateIndex], getX(), getY(), null);
                setY(getY() + (20 * (stateIndex < slideBitmaps.length / 2 ? 1 : -1)));
                setX(getX() + (15 * (stateIndex < slideBitmaps.length / 2 ? 1 : 0)));

                setWidth(slideBitmaps[stateIndex].getWidth());
                setHeight(slideBitmaps[stateIndex].getHeight());

                if (stateIndex == 0) {
                    setState(GANGSTER_STATE_RUN);
                }
                break;
        }

        gangsterBlock.set(getX(), getY(), getX() + getWidth(), getY() + getHeight());
    }

    private Rect gangsterBlock = new Rect();
    private Rect intersectBlock = new Rect();

    public boolean intersects(Block block) {

        intersectBlock.set(block.getX(), block.getY(),
                block.getX() + block.getWidth(),
                block.getY() + block.getHeight());

        return gangsterBlock.intersect(intersectBlock);
    }
}
