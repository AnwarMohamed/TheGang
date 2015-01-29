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
import com.android.thegang.elements.BlockPool;
import com.android.thegang.elements.MonsterFactory;
import com.android.thegang.model.SpriteBlock;
import com.android.thegang.view.GamePanel;

import static com.android.thegang.controller.GameThread.getRandom;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class MonsterBlock extends SpriteBlock {

    private int maxX;
    private int maxY;

    public int getType() {
        return type;
    }

    private int type;

    public void setFireType(int fireType) {
        this.fireType = fireType;
    }

    private int fireType = FireBlock.FIRE_TYPE_DOWN;

    public void setType(int type) {
        this.type = type;

        switch (type) {
            case MonsterFactory.MONSTER_TYPE_BIRD_0:
            case MonsterFactory.MONSTER_TYPE_BIRD_1:
                break;
        }
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

            BlockPool.getInstance().addBlock(this);
            GamePanel.getInstance().getRemoveViewBlocks().add(this);
        }
    }

    private int fireCount, origFireCount;

    public boolean canFire(int x, int y) {
        return getX() > x && fireCount > 0;
    }

    public FireBlock fire() {

        FireBlock fireBlock = (FireBlock)BlockPool.getInstance().getBlock(BlockPool.BLOCKPOOL_TYPE_FIRE);
        fireBlock.setX(getX() + getWidth() / 2);
        fireBlock.setY(getY() + getHeight() / 2);
        fireBlock.setBitmap(Bitmaps.eggs[getRandom(Bitmaps.eggs.length)]);

        if (type == FireBlock.FIRE_TYPE_LEFT) {
            fireBlock.setX(getX());
            fireBlock.setY(getY() + 50);
        }

        fireBlock.setMaxXY(maxX, maxY);
        fireBlock.setSpeed(max(getRandom(10), 5) + 1);
        fireBlock.setFireType(fireType);

        fireCount--;
        return fireBlock;
    }

    public void setFireCount(int fireCount) {
        this.fireCount = fireCount;
        this.origFireCount = fireCount;
    }
}