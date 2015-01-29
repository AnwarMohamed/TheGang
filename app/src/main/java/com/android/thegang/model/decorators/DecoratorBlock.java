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
import com.android.thegang.model.StaticBlock;

import static com.android.thegang.controller.GameThread.getRandom;
import static java.lang.Math.abs;

public class DecoratorBlock extends StaticBlock {

    private int maxX;

    public DecoratorBlock(int x, int y, int maxX) {
        super(x, y, null, false);

        setBitmap(Bitmaps.misc[getRandom(Bitmaps.misc.length)]);
        setY(getY() - bitmap.getHeight());

        setWidth(bitmap.getWidth());
        setHeight(bitmap.getHeight());

        this.maxX = maxX;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();

        super.doDraw(canvas);

        if (getX() < 0 && getWidth() + 100 < abs(getX())) {
            setX(maxX + 100 + getRandom(1000));

            setY(getY() + bitmap.getHeight());
            bitmap = Bitmaps.misc[getRandom(Bitmaps.misc.length)];
            setY(getY() - bitmap.getHeight());

            setWidth(bitmap.getWidth());
            setHeight(bitmap.getHeight());
        }
    }
}
