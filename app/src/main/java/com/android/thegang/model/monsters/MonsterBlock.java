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

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.elements.MonsterFactory;
import com.android.thegang.model.SpriteBlock;

import static com.android.thegang.controller.GameThread.getRandom;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class MonsterBlock extends SpriteBlock {

    private int maxX;
    private int maxY;
    private int type;

    public void setType(int type) {
        this.type = type;
    }

    public void setMaxXY(int x, int y) {
        maxX = x;
        maxY = y;
    }

    public MonsterBlock(int x, int y, Bitmap[] bitmaps, boolean clockwise) {
        super(x, y, bitmaps, clockwise);
    }

    public void getCaught() {
        setX(maxX + (max(getRandom(500), 100)));

        switch (type) {
            case MonsterFactory.MONSTER_TYPE_BIRD_0:
            case MonsterFactory.MONSTER_TYPE_BIRD_1:
                setY(max(getRandom(maxY / 2), 100));
                break;
            default:
                setY(max(getRandom(maxY), 100));
                break;
        }

        fireCount = origFireCount;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();

        super.doDraw(canvas);

        setWidth(idleBitmaps[stateIndex].getWidth());
        setHeight(idleBitmaps[stateIndex].getHeight());

        if (getX() < 0 && getWidth() + 100 < abs(getX())) {
            getCaught();
        }
    }

    private int fireCount, origFireCount;

    public boolean canFire(int x, int y) {
        return getX() > x && fireCount > 0;
    }

    public FireBlock fire() {
        FireBlock fireBlock = new FireBlock(getX() + getWidth() / 2, getY() + getHeight() / 2,
                Bitmaps.eggs[getRandom(Bitmaps.eggs.length)]);
        fireBlock.setMaxXY(maxX, maxY);
        fireBlock.setSpeed(max(getRandom(10), 5) + 1);
        fireBlock.setFireType(FireBlock.FIRE_TYPE_DOWN);

        fireCount--;
        return fireBlock;
    }

    public void setFireCount(int fireCount) {
        this.fireCount = fireCount;
        this.origFireCount = fireCount;
    }
}