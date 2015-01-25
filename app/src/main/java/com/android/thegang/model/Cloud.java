package com.android.thegang.model;

import android.graphics.Canvas;

import com.android.thegang.assets.Bitmaps;

import static java.lang.Math.abs;


public class Cloud extends Block {

    private int maxX, maxY;

    public Cloud(int maxX, int maxY) {
        super(
                (int) System.currentTimeMillis() % maxX,
                (int) System.currentTimeMillis() % maxY,
                Bitmaps.clouds[(int) System.currentTimeMillis() % Bitmaps.clouds.length],
                false);

        setXSpeed((int) System.currentTimeMillis() % 10 + 1);
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();
        super.doDraw(canvas);

        if (getX() < 0 && getWidth() <= abs(getX())) {
            setX(maxX + 100);
            setY((int) System.currentTimeMillis() % maxY);

            bitmap = Bitmaps.clouds[(int) System.currentTimeMillis() % Bitmaps.clouds.length];
        }
    }
}
