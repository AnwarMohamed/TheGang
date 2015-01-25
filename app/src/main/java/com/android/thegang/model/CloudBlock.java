package com.android.thegang.model;

import android.graphics.Canvas;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.controller.GameThread;

import static java.lang.Math.abs;


public class CloudBlock extends Block {

    private int maxX, maxY;

    public CloudBlock(int maxX, int maxY) {
        super(
                GameThread.random.nextInt() % maxX,
                GameThread.random.nextInt() % maxY,
                Bitmaps.clouds[GameThread.random.nextInt() % Bitmaps.clouds.length],
                false);

        setXSpeed(GameThread.random.nextInt() % 10 + 1);
        this.maxX = maxX;
        this.maxY = maxY;
    }

    @Override
    public void doDraw(Canvas canvas) {
        stepX();
        super.doDraw(canvas);

        if (getX() < 0 && getWidth() <= abs(getX())) {
            setX(maxX + GameThread.random.nextInt() % 500);
            setY(GameThread.random.nextInt() % maxY);

            bitmap = Bitmaps.clouds[GameThread.random.nextInt() % Bitmaps.clouds.length];
        }
    }
}
