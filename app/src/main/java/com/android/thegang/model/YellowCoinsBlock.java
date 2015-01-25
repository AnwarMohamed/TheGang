package com.android.thegang.model;

import com.android.thegang.assets.Bitmaps;


public class YellowCoinsBlock extends GiftBlock {

    public YellowCoinsBlock(int x, int y, int maxX) {
        super(x, y, maxX, Bitmaps.coins_yellow[0]);
        setIdleBitmaps(Bitmaps.coins_yellow);
    }
}
