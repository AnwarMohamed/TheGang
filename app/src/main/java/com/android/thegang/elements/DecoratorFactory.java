package com.android.thegang.elements;

import com.android.thegang.model.DecoratorBlock;

/**
 * Created by anwarelmakrahy on 1/25/15.
 */
public class DecoratorFactory {

    public static DecoratorBlock makeDecor(int x, int y, int maxX) {
        return new DecoratorBlock(x, y, maxX);
    }
}
