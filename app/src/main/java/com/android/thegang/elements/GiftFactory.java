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

import com.android.thegang.model.gifts.GiftBlock;
import com.android.thegang.model.gifts.OrangeCoinsBlock;
import com.android.thegang.model.gifts.YellowCoinsBlock;

import static com.android.thegang.controller.GameThread.getRandom;

public class GiftFactory {

    public final static int GIFT_TYPE_COIN = 0;
    public final static int GIFT_TYPE_RANDOM = 1;

    public final static int GIFT_TYPE_COIN_ORANGE = 0;
    public final static int GIFT_TYPE_COIN_YELLOW = 1;

    public static GiftBlock makeGift(int type, int x, int y, int maxX) {

        if (type == GIFT_TYPE_RANDOM) {
            type = getRandom(GIFT_TYPE_RANDOM);
        }

        switch (type) {
            case GIFT_TYPE_COIN:
                switch (getRandom(2)) {
                    case GIFT_TYPE_COIN_ORANGE:
                        return new OrangeCoinsBlock(x, y, maxX);
                    case GIFT_TYPE_COIN_YELLOW:
                        return new YellowCoinsBlock(x, y, maxX);
                }
                break;
        }

        return null;
    }
}
