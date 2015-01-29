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

package com.android.thegang.model.monsters;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.android.thegang.elements.BlockPool;
import com.android.thegang.model.StaticBlock;
import com.android.thegang.view.GamePanel;

public class FireBlock extends StaticBlock {

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;

        setXSpeed(speed);

        if (type == FIRE_TYPE_DOWN) {
            setYSpeed(-1 * speed);
        }
    }

    private int speed = 1;
    private int maxX, maxY;

    private int type = FIRE_TYPE_DOWN;

    public final static int FIRE_STATE_IDLE = 0;
    public final static int FIRE_STATE_RUNNING = 1;

    public final static int FIRE_TYPE_DOWN = 0;
    public final static int FIRE_TYPE_LEFT = 1;

    public FireBlock(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap, false);
        setState(FIRE_STATE_RUNNING);
    }

    public void setMaxXY(int x, int y) {
        maxX = x;
        maxY = y;
    }

    public void setFireType(int type) {
        this.type = type;
    }

    @Override
    public void doDraw(Canvas canvas) {
        if (getState() == FIRE_STATE_RUNNING) {
            if (getX() > 0 && getY() < maxY) {
                stepX();
                stepY();

                super.doDraw(canvas);
            } else {
                setState(FIRE_STATE_IDLE);

                BlockPool.getInstance().addBlock(this);
                GamePanel.getInstance().getRemoveViewBlocks().add(this);
            }
        }
    }
}
