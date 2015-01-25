package com.android.thegang.model;

import android.graphics.Bitmap;

import com.android.thegang.assets.Bitmaps;


public class NinjaGangsterBlock extends GangsterBlock {
    public NinjaGangsterBlock(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);

        setIdleBitmaps(Bitmaps.gangster0_idle);
        setRunBitmaps(Bitmaps.gangster0_run);
        setJumpBitmaps(Bitmaps.gangster0_jump);
        setAttackBitmaps(Bitmaps.gangster0_attack);
        setSlideBitmaps(Bitmaps.gangster0_slide);
    }
}
