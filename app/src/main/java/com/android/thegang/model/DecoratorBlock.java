package com.android.thegang.model;

import android.graphics.Canvas;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.controller.GameThread;

import static java.lang.Math.abs;

/**
 * Created by anwarelmakrahy on 1/25/15.
 */
public class DecoratorBlock extends Block {

    private int maxX;

    public DecoratorBlock(int x, int y, int maxX) {
        super(x, y, Bitmaps.misc[GameThread.random.nextInt(31) % Bitmaps.misc.length], false);
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
            bitmap = Bitmaps.misc[GameThread.random.nextInt(31) % Bitmaps.misc.length];
            setY(getY() - bitmap.getHeight());
        }
    }
}
