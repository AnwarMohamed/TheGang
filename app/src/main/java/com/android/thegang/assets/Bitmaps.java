/*
 *  Copyright (C) 2015
 *                      Abdallah Elerian  <abdallah.elerian@gmail.com>
 *                      Ahmed Samir       <ahmedsamir.93@gmail.com>
 *                      Anwar Mohamed     <anwarelmakrahy@gmail.com>
 *                      Moataz Hammouda   <moatazhammouda4@gmail.com>
 *                      Yasmine Elhabashi <yasmine.elhabashi@gmail.com>
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to authors.
 *
 */

package com.android.thegang.assets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.thegang.R;

public class Bitmaps {
    public static Bitmap[] gangster0_idle = new Bitmap[10];
    public static Bitmap[] gangster0_run = new Bitmap[10];
    public static Bitmap[] gangster0_jump = new Bitmap[10];
    public static Bitmap[] gangster0_attack = new Bitmap[10];
    public static Bitmap[] gangster0_slide = new Bitmap[10];
    public static Bitmap[] gangster0_dying = new Bitmap[10];

    public static Bitmap[] gangster1_dying = new Bitmap[10];
    public static Bitmap[] gangster1_attack = new Bitmap[10];
    public static Bitmap[] gangster1_idle = new Bitmap[10];
    
    public static Bitmap[] rocks = new Bitmap[4];
    public static Bitmap[] clouds = new Bitmap[1];
    public static Bitmap grass;
    public static Bitmap[] misc = new Bitmap[4];
    public static Bitmap[] coins_orange = new Bitmap[10];
    public static Bitmap[] coins_yellow = new Bitmap[10];

    public static Bitmap[] monster_0 = new Bitmap[14];
    public static Bitmap[] monster_1 = new Bitmap[14];
    public static Bitmap info_life, info_coin;

    public static Bitmap[] eggs = new Bitmap[2];

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

        gangster0_attack[0] = createScaledBitmap(0.3f, R.drawable.gang0_attack_0, gangster0_attack[0], context);
        gangster0_attack[1] = createScaledBitmap(0.3f, R.drawable.gang0_attack_1, gangster0_attack[1], context);
        gangster0_attack[2] = createScaledBitmap(0.3f, R.drawable.gang0_attack_2, gangster0_attack[2], context);
        gangster0_attack[3] = createScaledBitmap(0.3f, R.drawable.gang0_attack_3, gangster0_attack[3], context);
        gangster0_attack[4] = createScaledBitmap(0.3f, R.drawable.gang0_attack_4, gangster0_attack[4], context);
        gangster0_attack[5] = createScaledBitmap(0.3f, R.drawable.gang0_attack_5, gangster0_attack[5], context);
        gangster0_attack[6] = createScaledBitmap(0.3f, R.drawable.gang0_attack_6, gangster0_attack[6], context);
        gangster0_attack[7] = createScaledBitmap(0.3f, R.drawable.gang0_attack_7, gangster0_attack[7], context);
        gangster0_attack[8] = createScaledBitmap(0.3f, R.drawable.gang0_attack_8, gangster0_attack[8], context);
        gangster0_attack[9] = createScaledBitmap(0.3f, R.drawable.gang0_attack_9, gangster0_attack[9], context);

        gangster0_slide[0] = createScaledBitmap(0.3f, R.drawable.gang0_slide_0, gangster0_slide[0], context);
        gangster0_slide[1] = createScaledBitmap(0.3f, R.drawable.gang0_slide_1, gangster0_slide[1], context);
        gangster0_slide[2] = createScaledBitmap(0.3f, R.drawable.gang0_slide_2, gangster0_slide[2], context);
        gangster0_slide[3] = createScaledBitmap(0.3f, R.drawable.gang0_slide_3, gangster0_slide[3], context);
        gangster0_slide[4] = createScaledBitmap(0.3f, R.drawable.gang0_slide_4, gangster0_slide[4], context);
        gangster0_slide[5] = createScaledBitmap(0.3f, R.drawable.gang0_slide_5, gangster0_slide[5], context);
        gangster0_slide[6] = createScaledBitmap(0.3f, R.drawable.gang0_slide_6, gangster0_slide[6], context);
        gangster0_slide[7] = createScaledBitmap(0.3f, R.drawable.gang0_slide_7, gangster0_slide[7], context);
        gangster0_slide[8] = createScaledBitmap(0.3f, R.drawable.gang0_slide_8, gangster0_slide[8], context);
        gangster0_slide[9] = createScaledBitmap(0.3f, R.drawable.gang0_slide_9, gangster0_slide[9], context);

        gangster0_dying[0] = createScaledBitmap(0.3f, R.drawable.gang0_dead_0, gangster0_dying[0], context);
        gangster0_dying[1] = createScaledBitmap(0.3f, R.drawable.gang0_dead_1, gangster0_dying[1], context);
        gangster0_dying[2] = createScaledBitmap(0.3f, R.drawable.gang0_dead_2, gangster0_dying[2], context);
        gangster0_dying[3] = createScaledBitmap(0.3f, R.drawable.gang0_dead_3, gangster0_dying[3], context);
        gangster0_dying[4] = createScaledBitmap(0.3f, R.drawable.gang0_dead_4, gangster0_dying[4], context);
        gangster0_dying[5] = createScaledBitmap(0.3f, R.drawable.gang0_dead_5, gangster0_dying[5], context);
        gangster0_dying[6] = createScaledBitmap(0.3f, R.drawable.gang0_dead_6, gangster0_dying[6], context);
        gangster0_dying[7] = createScaledBitmap(0.3f, R.drawable.gang0_dead_7, gangster0_dying[7], context);
        gangster0_dying[8] = createScaledBitmap(0.3f, R.drawable.gang0_dead_8, gangster0_dying[8], context);
        gangster0_dying[9] = createScaledBitmap(0.3f, R.drawable.gang0_dead_9, gangster0_dying[9], context);

               
        gangster1_idle[0] = createScaledBitmap(0.3f, R.drawable.gang1_idle_0, gangster1_idle[0], context);
        gangster1_idle[1] = createScaledBitmap(0.3f, R.drawable.gang1_idle_1, gangster1_idle[1], context);
        gangster1_idle[2] = createScaledBitmap(0.3f, R.drawable.gang1_idle_2, gangster1_idle[2], context);
        gangster1_idle[3] = createScaledBitmap(0.3f, R.drawable.gang1_idle_3, gangster1_idle[3], context);
        gangster1_idle[4] = createScaledBitmap(0.3f, R.drawable.gang1_idle_4, gangster1_idle[4], context);
        gangster1_idle[5] = createScaledBitmap(0.3f, R.drawable.gang1_idle_5, gangster1_idle[5], context);
        gangster1_idle[6] = createScaledBitmap(0.3f, R.drawable.gang1_idle_6, gangster1_idle[6], context);
        gangster1_idle[7] = createScaledBitmap(0.3f, R.drawable.gang1_idle_7, gangster1_idle[7], context);
        gangster1_idle[8] = createScaledBitmap(0.3f, R.drawable.gang1_idle_8, gangster1_idle[8], context);
        gangster1_idle[9] = createScaledBitmap(0.3f, R.drawable.gang1_idle_9, gangster1_idle[9], context);

        gangster1_dying[0] = createScaledBitmap(0.3f, R.drawable.gang1_dead_0, gangster1_dying[0], context);
        gangster1_dying[1] = createScaledBitmap(0.3f, R.drawable.gang1_dead_1, gangster1_dying[1], context);
        gangster1_dying[2] = createScaledBitmap(0.3f, R.drawable.gang1_dead_2, gangster1_dying[2], context);
        gangster1_dying[3] = createScaledBitmap(0.3f, R.drawable.gang1_dead_3, gangster1_dying[3], context);
        gangster1_dying[4] = createScaledBitmap(0.3f, R.drawable.gang1_dead_4, gangster1_dying[4], context);
        gangster1_dying[5] = createScaledBitmap(0.3f, R.drawable.gang1_dead_5, gangster1_dying[5], context);
        gangster1_dying[6] = createScaledBitmap(0.3f, R.drawable.gang1_dead_6, gangster1_dying[6], context);
        gangster1_dying[7] = createScaledBitmap(0.3f, R.drawable.gang1_dead_7, gangster1_dying[7], context);
        gangster1_dying[8] = createScaledBitmap(0.3f, R.drawable.gang1_dead_8, gangster1_dying[8], context);
        gangster1_dying[9] = createScaledBitmap(0.3f, R.drawable.gang1_dead_9, gangster1_dying[9], context);

        gangster1_attack[0] = createScaledBitmap(0.3f, R.drawable.gang1_attack_0, gangster1_attack[0], context);
        gangster1_attack[1] = createScaledBitmap(0.3f, R.drawable.gang1_attack_1, gangster1_attack[1], context);
        gangster1_attack[2] = createScaledBitmap(0.3f, R.drawable.gang1_attack_2, gangster1_attack[2], context);
        gangster1_attack[3] = createScaledBitmap(0.3f, R.drawable.gang1_attack_3, gangster1_attack[3], context);
        gangster1_attack[4] = createScaledBitmap(0.3f, R.drawable.gang1_attack_4, gangster1_attack[4], context);
        gangster1_attack[5] = createScaledBitmap(0.3f, R.drawable.gang1_attack_5, gangster1_attack[5], context);
        gangster1_attack[6] = createScaledBitmap(0.3f, R.drawable.gang1_attack_6, gangster1_attack[6], context);
        gangster1_attack[7] = createScaledBitmap(0.3f, R.drawable.gang1_attack_7, gangster1_attack[7], context);
        gangster1_attack[8] = createScaledBitmap(0.3f, R.drawable.gang1_attack_8, gangster1_attack[8], context);
        gangster1_attack[9] = createScaledBitmap(0.3f, R.drawable.gang1_attack_9, gangster1_attack[9], context);


        rocks[0] = createScaledBitmap(0.2f, R.drawable.rocks_0, rocks[0], context);
        rocks[1] = createScaledBitmap(0.1f, R.drawable.rocks_1, rocks[1], context);
        rocks[2] = createScaledBitmap(0.8f, R.drawable.rocks_2, rocks[2], context);
        rocks[3] = createScaledBitmap(1f, R.drawable.rocks_3, rocks[3], context);

        misc[0] = createScaledBitmap(0.3f, R.drawable.grass_0, misc[0], context);
        misc[1] = createScaledBitmap(0.3f, R.drawable.grass_1, misc[1], context);
        misc[2] = createScaledBitmap(0.3f, R.drawable.grass_2, misc[2], context);
        misc[3] = createScaledBitmap(0.7f, R.drawable.grass_3, misc[3], context);
        //misc[4] = createScaledBitmap(0.5f, R.drawable.grass_4, misc[4], context);

        clouds[0] = createScaledBitmap(0.3f, R.drawable.clouds_0, clouds[0], context);
        grass = createScaledBitmap(1f, R.drawable.grass, grass, context);

        Bitmap coins_orange_s = BitmapFactory.decodeResource(context.getResources(), R.drawable.coins_0);
        Bitmap coins_yellow_s = null;
        coins_yellow_s = createScaledBitmap(0.85f, R.drawable.coins_1, coins_yellow_s, context);

        int bitmapHeight_0 = coins_yellow_s.getHeight(), bitmapWidth_0 = coins_yellow_s.getWidth() / 10;
        int bitmapHeight_1 = coins_orange_s.getHeight(), bitmapWidth_1 = coins_orange_s.getWidth() / 10;

        for (int i = 0; i < 10; i++) {
            coins_orange[i] = Bitmap.createBitmap(coins_orange_s, i * bitmapWidth_1, 0, bitmapWidth_1, bitmapHeight_1);
            coins_yellow[i] = Bitmap.createBitmap(coins_yellow_s, i * bitmapWidth_0, 0, bitmapWidth_0, bitmapHeight_0);
        }

        info_life = createScaledBitmap(0.06f, R.drawable.heart, info_life, context);
        info_coin = Bitmap.createScaledBitmap(coins_yellow[9],
                (int) (coins_yellow[9].getWidth() * 0.7),
                (int) (coins_yellow[9].getHeight() * 0.7), false);

        Bitmap monster_0_s = null, monster_1_s = null;
        monster_0_s = createScaledBitmap(0.4f, R.drawable.birds_0, monster_0_s, context);
        monster_1_s = createScaledBitmap(0.8f, R.drawable.birds_1, monster_1_s, context);

        bitmapHeight_0 = monster_0_s.getHeight() / 3;
        bitmapWidth_0 = monster_0_s.getWidth() / 5;
        bitmapHeight_1 = monster_1_s.getHeight() / 3;
        bitmapWidth_1 = monster_1_s.getWidth() / 5;

        for (int i = 0; i < 14; i++) {
            monster_0[i] = Bitmap.createBitmap(
                    monster_0_s, (4 - (i % 5)) * bitmapWidth_0, (i / 5) * bitmapHeight_0,
                    bitmapWidth_0, bitmapHeight_0);

            monster_1[i] = Bitmap.createBitmap(
                    monster_1_s, (4 - (i % 5)) * bitmapWidth_1, (i / 5) * bitmapHeight_1,
                    bitmapWidth_1, bitmapHeight_1);
        }

        eggs[0] = createScaledBitmap(0.1f, R.drawable.egg_0, eggs[0], context);
        eggs[1] = createScaledBitmap(0.1f, R.drawable.egg_1, eggs[1], context);

        /*
        Bitmap monster = null;
        monster = createScaledBitmap(1.5f, R.drawable.monster_0, monster, context);

        bitmapHeight_0 = monster.getHeight() / 4;
        bitmapWidth_0 = monster.getWidth() / 4;

        for (int i = 4; i < 8; i++) {
            monster_0[2 * (i - 4)] = Bitmap.createBitmap(
                    monster, (i % 4) * bitmapWidth_0, (i / 4) * bitmapHeight_0,
                    bitmapWidth_0, bitmapHeight_0);
            monster_0[2 * (i - 4) + 1] = Bitmap.createBitmap(
                    monster, (i % 4) * bitmapWidth_0, (i / 4) * bitmapHeight_0,
                    bitmapWidth_0, bitmapHeight_0);
        }
        */
    }

    //public static Bitmap[] monster_0 = new Bitmap[8];

    private static Bitmap createScaledBitmap(float scale, int resourceId, Bitmap bitmap, Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
        return Bitmap.createScaledBitmap(
                bitmap, (int) (bitmap.getWidth() * scale), (int) (bitmap.getHeight() * scale), false);
    }
}
