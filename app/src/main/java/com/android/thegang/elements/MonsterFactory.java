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

package com.android.thegang.elements;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.model.monsters.MonsterBlock;

import static com.android.thegang.controller.GameThread.getRandom;
import static java.lang.Math.max;

public class MonsterFactory {

    public final static int MONSTER_TYPE_BIRD_0 = 0;
    public final static int MONSTER_TYPE_BIRD_1 = 1;
    public final static int MONSTER_TYPE_DRAGON = 2;
    public final static int MONSTER_TYPE_RANDOM = 2;

    public static MonsterBlock makeMonster(int type, int maxX, int maxY) {

        if (type == MONSTER_TYPE_RANDOM) {
            type = getRandom(MONSTER_TYPE_RANDOM);
        }

        MonsterBlock monsterBlock = null;

        switch (type) {
            case MONSTER_TYPE_BIRD_0:
            case MONSTER_TYPE_BIRD_1:
                monsterBlock = new MonsterBlock(
                        max(maxX, getRandom(maxX * 2)) , getRandom(maxY / 2),
                        type == MONSTER_TYPE_BIRD_0 ? Bitmaps.monster_0 : Bitmaps.monster_1,
                        false);
                monsterBlock.setFireCount(1);
                break;
            /*
            case MONSTER_TYPE_DRAGON:
                monsterBlock = new MonsterBlock(
                        getRandom(maxX * 2), getRandom(maxY / 2),
                        Bitmaps.monster_0, false);
                break;
                */
        }

        monsterBlock.setMaxXY(maxX, maxY);
        monsterBlock.setXSpeed(max(getRandom(30) + 1, 20));
        return monsterBlock;
    }
}
