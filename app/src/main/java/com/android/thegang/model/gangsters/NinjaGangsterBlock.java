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

package com.android.thegang.model.gangsters;

import com.android.thegang.assets.Bitmaps;


public class NinjaGangsterBlock extends GangsterBlock {
    public NinjaGangsterBlock(int x, int y) {
        super(x, y, Bitmaps.gangster0_idle);

        setRunBitmaps(Bitmaps.gangster0_run);
        setJumpBitmaps(Bitmaps.gangster0_jump);
        setAttackBitmaps(Bitmaps.gangster0_attack);
        setSlideBitmaps(Bitmaps.gangster0_slide);
        setDyingBitmaps(Bitmaps.gangster0_dying);
    }

    private static NinjaGangsterBlock instance = null;

    public static NinjaGangsterBlock getInstance() {
        if (instance == null) {
            instance = new NinjaGangsterBlock(100, 0);
        }

        return instance;
    }
}
