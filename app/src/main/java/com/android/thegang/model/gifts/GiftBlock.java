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

package com.android.thegang.model.gifts;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.android.thegang.controller.GameThread;
import com.android.thegang.model.SpriteBlock;

import static java.lang.Math.abs;

public abstract class GiftBlock extends SpriteBlock {

    public GiftBlock(int x, int y, int maxX, Bitmap[] bitmaps) {
        super(x, y, bitmaps, false);
        this.maxX = maxX;

        setWidth(bitmaps[0].getWidth());
        setHeight(bitmaps[0].getHeight());
    }

    private int maxX;
    private int weight = 0;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();
        switch (state) {
            case BLOCK_STATE_IDLE:
                stateIndex = (stateIndex + 1) % idleBitmaps.length;
                canvas.drawBitmap(idleBitmaps[stateIndex], getX(), getY(), null);
                break;
        }

        if (getX() < 0 && getWidth() <= abs(getX())) {
            setX(maxX + GameThread.random.nextInt(Integer.MAX_VALUE) % 1000);
        }
    }

    public int catchMe() {
        setX(maxX + GameThread.random.nextInt(Integer.MAX_VALUE) % 1000);
        return getWidth();
    }
}
