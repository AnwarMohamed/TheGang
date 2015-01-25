package com.android.thegang.model;

import android.graphics.Bitmap;

import com.android.thegang.assets.Bitmaps;


public class NinjaGangster extends Gangster {
    public NinjaGangster(int x, int y, Bitmap bitmap) {
        super(x, y, bitmap);

        setIdleBitmaps(Bitmaps.gangster0_idle);
        setRunBitmaps(Bitmaps.gangster0_run);
        setJumpBitmaps(Bitmaps.gangster0_jump);
    }
}
