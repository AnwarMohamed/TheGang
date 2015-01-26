package com.android.thegang.elements;

import com.android.thegang.controller.GameThread;
import com.android.thegang.model.GiftBlock;
import com.android.thegang.model.OrangeCoinsBlock;
import com.android.thegang.model.YellowCoinsBlock;

public class GiftFactory {

    public final static int GIFT_TYPE_COIN = 0;
    public final static int GIFT_TYPE_RANDOM = 1;

    public final static int GIFT_TYPE_COIN_ORANGE = 0;
    public final static int GIFT_TYPE_COIN_YELLOW = 1;

    public static GiftBlock makeGift(int type, int x, int y, int maxX) {

        if (type == GIFT_TYPE_RANDOM) {
            type = GameThread.random.nextInt(Integer.MAX_VALUE) % GIFT_TYPE_RANDOM;
        }

        switch (type) {
            case GIFT_TYPE_COIN:
                switch (GameThread.random.nextInt(Integer.MAX_VALUE) % 2) {
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
