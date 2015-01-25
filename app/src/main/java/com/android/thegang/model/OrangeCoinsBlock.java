package com.android.thegang.model;

import com.android.thegang.assets.Bitmaps;


public class OrangeCoinsBlock extends GiftBlock {

    public OrangeCoinsBlock(int x, int y, int maxX) {
        super(x, y, maxX, Bitmaps.coins_orange[0]);
        setIdleBitmaps(Bitmaps.coins_orange);
    }
}
