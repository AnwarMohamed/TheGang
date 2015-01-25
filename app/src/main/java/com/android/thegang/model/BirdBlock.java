package com.android.thegang.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BirdBlock extends Block {

    public Bitmap[] getIdleBitmaps() {
        return idleBitmaps;
    }

    public void setIdleBitmaps(Bitmap[] idleBitmaps) {
        this.idleBitmaps = idleBitmaps;
    }

    private Bitmap[] idleBitmaps;

    public BirdBlock(int x, int y, Bitmap[] bitmaps, boolean clockwise) {
        super(x, y, bitmaps[0], clockwise);
        idleBitmaps = bitmaps;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stateIndex = (stateIndex + 1) % idleBitmaps.length;
        canvas.drawBitmap(idleBitmaps[stateIndex], getX(), getY(), paint);
    }
}
