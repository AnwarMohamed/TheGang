package com.android.thegang.model;

import com.android.thegang.assets.Bitmaps;

import java.util.Random;

public class Rock extends Block {

    public Rock(int x, int y) {
        super(x, y, Bitmaps.rocks[(new Random()).nextInt() % 2], false);
    }
}
