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


public class StaticBlock extends Block {

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    protected Bitmap bitmap;

    public StaticBlock(int x, int y, Bitmap bitmap, boolean clockwise) {
        super(x, y, clockwise);

        setBitmap(bitmap);

        if (bitmap != null) {
            setWidth(bitmap.getWidth());
            setHeight(bitmap.getHeight());
        }
    }

    @Override
    public void doDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, getX(), getY(), null);
    }

    @Override
    public int catchMe() {
        return 0;
    }
}
