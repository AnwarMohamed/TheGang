package com.android.thegang.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class Gangster extends Block {

    public Gangster(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);
    }

    private Bitmap[] runBitmaps = null;
    private Bitmap[] idleBitmaps = null;
    private Bitmap[] jumpBitmaps = null;

    public final static int GANGSTER_STATE_IDLE = 0;
    public final static int GANGSTER_STATE_RUN = 1;
    public final static int GANGSTER_STATE_JUMP = 2;

    public Bitmap[] getRunBitmaps() {
        return runBitmaps;
    }

    public void setRunBitmaps(Bitmap[] runBitmaps) {
        this.runBitmaps = runBitmaps;
    }

    public Bitmap[] getIdleBitmaps() {
        return idleBitmaps;
    }

    public void setIdleBitmaps(Bitmap[] idleBitmaps) {
        this.idleBitmaps = idleBitmaps;
    }

    public Bitmap[] getJumpBitmaps() {
        return jumpBitmaps;
    }

    public void setJumpBitmaps(Bitmap[] jumpBitmaps) {
        this.jumpBitmaps = jumpBitmaps;
    }

    private int state, stateIndex = 0;

    public void setState(int state) {
        this.state = state;
        stateIndex = 0;
    }

    @Override
    public void doDraw(Canvas canvas) {
        switch(state) {
            case GANGSTER_STATE_IDLE:
                stateIndex = (stateIndex + 1)% idleBitmaps.length;
                canvas.drawBitmap(idleBitmaps[stateIndex], getX(), getY(), paint);
                break;
            case GANGSTER_STATE_JUMP:
                stateIndex = (stateIndex + 1)% jumpBitmaps.length;
                canvas.drawBitmap(jumpBitmaps[stateIndex], getX(), getY(), paint);
                break;
            case GANGSTER_STATE_RUN:
                stateIndex = (stateIndex + 1)% runBitmaps.length;
                canvas.drawBitmap(runBitmaps[stateIndex], getX(), getY(), paint);
                break;
        }
    }
}
