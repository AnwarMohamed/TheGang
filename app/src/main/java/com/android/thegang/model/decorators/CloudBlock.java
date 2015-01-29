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

package com.android.thegang.model.decorators;

import android.graphics.Canvas;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.controller.GameThread;
import com.android.thegang.model.StaticBlock;

import static java.lang.Math.abs;


public class CloudBlock extends StaticBlock {

    private int maxX, maxY;

    public CloudBlock(int maxX, int maxY) {
        super(
                GameThread.random.nextInt() % maxX,
                GameThread.random.nextInt() % maxY,
                Bitmaps.clouds[GameThread.random.nextInt() % Bitmaps.clouds.length],
                false);

        setXSpeed(GameThread.random.nextInt() % 10 + 1);
        this.maxX = maxX;
        this.maxY = maxY;
        this.width = bitmap.getWidth();
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();
        super.doDraw(canvas);

        if (getX() < 0 && getWidth() < abs(getX())) {
            setX(maxX + GameThread.random.nextInt() % 500);
            setY(GameThread.random.nextInt() % maxY);

            bitmap = Bitmaps.clouds[GameThread.random.nextInt() % Bitmaps.clouds.length];
        }
    }
}
