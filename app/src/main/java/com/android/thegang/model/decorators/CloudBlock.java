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
import com.android.thegang.elements.BlockPool;
import com.android.thegang.model.StaticBlock;
import com.android.thegang.view.GamePanel;

import static com.android.thegang.controller.GameThread.getRandom;
import static java.lang.Math.abs;


public class CloudBlock extends StaticBlock {

    private int maxX, maxY;

    public CloudBlock(int maxX, int maxY) {
        super(
                getRandom(maxX),
                getRandom(maxY),
                Bitmaps.clouds[getRandom(Bitmaps.clouds.length)],
                false);

        setXSpeed(getRandom(10) + 1);
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();
        super.doDraw(canvas);

        if (getX() < 0 && getWidth() < abs(getX())) {
            setX(maxX + getRandom(500));
            setY(getRandom(maxY));

            bitmap = Bitmaps.clouds[getRandom(Bitmaps.clouds.length)];

            BlockPool.getInstance().addBlock(this);
            GamePanel.getInstance().getRemoveViewBlocks().add(this);
        }
    }
}
