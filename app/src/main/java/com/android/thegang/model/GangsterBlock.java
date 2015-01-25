package com.android.thegang.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract class GangsterBlock extends Block {

    public GangsterBlock(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);
        originalX = x;
        originalY = y;
    }

    private Bitmap[] runBitmaps = null;
    private Bitmap[] idleBitmaps = null;
    private Bitmap[] jumpBitmaps = null;

    public Bitmap[] getSlideBitmaps() {
        return slideBitmaps;
    }

    public void setSlideBitmaps(Bitmap[] slideBitmaps) {
        this.slideBitmaps = slideBitmaps;
    }

    private Bitmap[] slideBitmaps = null;

    private int originalX, originalY;

    public Bitmap[] getAttackBitmaps() {
        return attackBitmaps;
    }

    public void setAttackBitmaps(Bitmap[] attackBitmaps) {
        this.attackBitmaps = attackBitmaps;
    }

    private Bitmap[] attackBitmaps = null;

    public final static int GANGSTER_STATE_IDLE = 0;
    public final static int GANGSTER_STATE_RUN = 1;
    public final static int GANGSTER_STATE_JUMP = 2;
    public final static int GANGSTER_STATE_ATTACK = 3;
    public final static int GANGSTER_STATE_SLIDE = 4;

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

    @Override
    public void doDraw(Canvas canvas) {
        switch (state) {
            case GANGSTER_STATE_IDLE:
                stateIndex = (stateIndex + 1) % idleBitmaps.length;
                canvas.drawBitmap(idleBitmaps[stateIndex], getX(), getY(), paint);
                break;
            case GANGSTER_STATE_JUMP:
                stateIndex = (stateIndex + 1) % jumpBitmaps.length;
                canvas.drawBitmap(jumpBitmaps[stateIndex], getX(), getY(), paint);
                setY(getY() + (45 * (stateIndex < jumpBitmaps.length / 2 ? -1 : 1)));
                setX(getX() + 15);

                if (stateIndex == 0) {
                    setState(GANGSTER_STATE_RUN);
                }
                break;
            case GANGSTER_STATE_RUN:
                stateIndex = (stateIndex + 1) % runBitmaps.length;
                canvas.drawBitmap(runBitmaps[stateIndex], getX(), getY(), paint);
                setX(getX() > originalX ? getX() - 50 : originalX);
                break;
            case GANGSTER_STATE_ATTACK:
                stateIndex = (stateIndex + 1) % attackBitmaps.length;
                canvas.drawBitmap(attackBitmaps[stateIndex], getX(), getY(), paint);

                if (stateIndex == 0) {
                    setState(GANGSTER_STATE_RUN);
                }
                break;
            case GANGSTER_STATE_SLIDE:
                stateIndex = (stateIndex + 1) % slideBitmaps.length;
                canvas.drawBitmap(slideBitmaps[stateIndex], getX(), getY(), paint);
                setY(getY() + (20 * (stateIndex < slideBitmaps.length / 2 ? 1 : -1)));
                setX(getX() + (15 * (stateIndex < slideBitmaps.length / 2 ? 1 : 0)));

                if (stateIndex == 0) {
                    setState(GANGSTER_STATE_RUN);
                }
                break;
        }
    }
}
