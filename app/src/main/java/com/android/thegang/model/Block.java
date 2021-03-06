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

import android.graphics.Canvas;

public abstract class Block {

    private int x = 0, y = 0;
    private int width = 0;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int height = 0;
    protected boolean clockwise;

    public final static int BLOCK_STATE_IDLE = 0;

    public int getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    private int xSpeed = 1;

    public int getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    private int ySpeed = 0;

    public Block(int x, int y) {
        this(x, y, true);
    }

    public Block(int x, int y, boolean clockwise) {
        this.x = x;
        this.y = y;
        this.clockwise = clockwise;

        setState(BLOCK_STATE_IDLE);
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void stepX() {
        setX(x + (xSpeed * (clockwise ? 1 : -1)));
    }

    public void stepY() {
        setY(y + (ySpeed * (clockwise ? 1 : -1)));
    }

    public abstract void doDraw(Canvas canvas);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    protected int state, stateIndex;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        stateIndex = 0;
    }

    public abstract int catchMe();
}
