package com.android.thegang.assets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.thegang.R;

public class Bitmaps {
    public static Bitmap[] gangster0_idle = new Bitmap[10];
    public static Bitmap[] gangster0_run = new Bitmap[10];
    public static Bitmap[] gangster0_jump = new Bitmap[10];
    public static Bitmap[] rocks = new Bitmap[2];
    public static Bitmap[] clouds = new Bitmap[1];
    public static Bitmap grass;

    public static void loadBitmapStore(Context context) {
        gangster0_idle[0] = createScaledBitmap(0.3f, R.drawable.gang0_idle_0, gangster0_idle[0], context);
        gangster0_idle[1] = createScaledBitmap(0.3f, R.drawable.gang0_idle_1, gangster0_idle[1], context);
        gangster0_idle[2] = createScaledBitmap(0.3f, R.drawable.gang0_idle_2, gangster0_idle[2], context);
        gangster0_idle[3] = createScaledBitmap(0.3f, R.drawable.gang0_idle_3, gangster0_idle[3], context);
        gangster0_idle[4] = createScaledBitmap(0.3f, R.drawable.gang0_idle_4, gangster0_idle[4], context);
        gangster0_idle[5] = createScaledBitmap(0.3f, R.drawable.gang0_idle_5, gangster0_idle[5], context);
        gangster0_idle[6] = createScaledBitmap(0.3f, R.drawable.gang0_idle_6, gangster0_idle[6], context);
        gangster0_idle[7] = createScaledBitmap(0.3f, R.drawable.gang0_idle_7, gangster0_idle[7], context);
        gangster0_idle[8] = createScaledBitmap(0.3f, R.drawable.gang0_idle_8, gangster0_idle[8], context);
        gangster0_idle[9] = createScaledBitmap(0.3f, R.drawable.gang0_idle_9, gangster0_idle[9], context);

        gangster0_run[0] = createScaledBitmap(0.3f, R.drawable.gang0_run_0, gangster0_run[0], context);
        gangster0_run[1] = createScaledBitmap(0.3f, R.drawable.gang0_run_1, gangster0_run[1], context);
        gangster0_run[2] = createScaledBitmap(0.3f, R.drawable.gang0_run_2, gangster0_run[2], context);
        gangster0_run[3] = createScaledBitmap(0.3f, R.drawable.gang0_run_3, gangster0_run[3], context);
        gangster0_run[4] = createScaledBitmap(0.3f, R.drawable.gang0_run_4, gangster0_run[4], context);
        gangster0_run[5] = createScaledBitmap(0.3f, R.drawable.gang0_run_5, gangster0_run[5], context);
        gangster0_run[6] = createScaledBitmap(0.3f, R.drawable.gang0_run_6, gangster0_run[6], context);
        gangster0_run[7] = createScaledBitmap(0.3f, R.drawable.gang0_run_7, gangster0_run[7], context);
        gangster0_run[8] = createScaledBitmap(0.3f, R.drawable.gang0_run_8, gangster0_run[8], context);
        gangster0_run[9] = createScaledBitmap(0.3f, R.drawable.gang0_run_9, gangster0_run[9], context);

        gangster0_jump[0] = createScaledBitmap(0.3f, R.drawable.gang0_jump_0, gangster0_jump[0], context);
        gangster0_jump[1] = createScaledBitmap(0.3f, R.drawable.gang0_jump_1, gangster0_jump[1], context);
        gangster0_jump[2] = createScaledBitmap(0.3f, R.drawable.gang0_jump_2, gangster0_jump[2], context);
        gangster0_jump[3] = createScaledBitmap(0.3f, R.drawable.gang0_jump_3, gangster0_jump[3], context);
        gangster0_jump[4] = createScaledBitmap(0.3f, R.drawable.gang0_jump_4, gangster0_jump[4], context);
        gangster0_jump[5] = createScaledBitmap(0.3f, R.drawable.gang0_jump_5, gangster0_jump[5], context);
        gangster0_jump[6] = createScaledBitmap(0.3f, R.drawable.gang0_jump_6, gangster0_jump[6], context);
        gangster0_jump[7] = createScaledBitmap(0.3f, R.drawable.gang0_jump_7, gangster0_jump[7], context);
        gangster0_jump[8] = createScaledBitmap(0.3f, R.drawable.gang0_jump_8, gangster0_jump[8], context);
        gangster0_jump[9] = createScaledBitmap(0.3f, R.drawable.gang0_jump_9, gangster0_jump[9], context);

        rocks[0] = createScaledBitmap(0.3f, R.drawable.rocks_0, rocks[0], context);
        rocks[1] = createScaledBitmap(0.3f, R.drawable.rocks_1, rocks[1], context);

        clouds[0] = createScaledBitmap(0.3f, R.drawable.clouds_0, clouds[0], context);

        grass = createScaledBitmap(1f, R.drawable.grass, grass, context);
    }

    private static Bitmap createScaledBitmap(float scale, int resourceId, Bitmap bitmap, Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        return Bitmap.createScaledBitmap(
                bitmap, (int) (bitmap.getWidth() * scale), (int) (bitmap.getHeight() * scale), false);
    }
}
