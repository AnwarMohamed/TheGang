package com.android.thegang.model;

import android.graphics.Canvas;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.controller.GameThread;

import static java.lang.Math.abs;

public class RockBlock extends Block {

    private int maxX;
    public RockBlock(int x, int y, int maxX) {
        super(x, y, Bitmaps.rocks[(int)(System.currentTimeMillis() % Bitmaps.rocks.length)], false);
        setY(getY() - bitmap.getHeight());
        this.maxX = maxX;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();
        super.doDraw(canvas);

        if (getX() < 0 && getWidth() <= abs(getX())) {
            setX(maxX + GameThread.random.nextInt(31) % 1000);

            setY(getY() + bitmap.getHeight());
            bitmap = Bitmaps.rocks[GameThread.random.nextInt(31) % Bitmaps.rocks.length];
            setY(getY() - bitmap.getHeight());
        }
    }
}
