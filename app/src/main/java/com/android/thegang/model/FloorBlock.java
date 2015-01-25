package com.android.thegang.model;

import android.graphics.Canvas;

import com.android.thegang.assets.Bitmaps;

import static java.lang.Math.abs;

public class FloorBlock extends Block {

    private int maxX;

    public FloorBlock(int maxX, int y) {
        super(0, y, Bitmaps.grass, false);
        this.maxX = maxX;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();
        super.doDraw(canvas);

        if (getX() < 0 && getWidth() - abs(getX()) <= maxX) {
            setX(0);
        }
    }
}
