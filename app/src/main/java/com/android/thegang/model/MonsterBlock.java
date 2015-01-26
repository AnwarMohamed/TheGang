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

package com.android.thegang.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.android.thegang.controller.GameThread;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class MonsterBlock extends Block {

    private int maxX, maxY;

    public void setMaxXY(int x, int y) {
        maxX = x;
        maxY = y;
    }

    public Bitmap[] getIdleBitmaps() {
        return idleBitmaps;
    }

    public void setIdleBitmaps(Bitmap[] idleBitmaps) {
        this.idleBitmaps = idleBitmaps;
    }

    private Bitmap[] idleBitmaps;

    public MonsterBlock(int x, int y, Bitmap[] bitmaps, boolean clockwise) {
        super(x, y, bitmaps[0], clockwise);
        idleBitmaps = bitmaps;
    }

    @Override
    public void doDraw(Canvas canvas) {
        if (getX() != maxX) {
            stepX();
        }

        stateIndex = (stateIndex + 1) % idleBitmaps.length;
        canvas.drawBitmap(idleBitmaps[stateIndex], getX(), getY(), paint);

        if (getX() < 0 && getWidth() <= abs(getX())) {
            setX(maxX + 200 + (GameThread.random.nextInt(Integer.MAX_VALUE) % 500));
            setY(max(GameThread.random.nextInt(Integer.MAX_VALUE) % (maxY), 100));
        }
    }
}