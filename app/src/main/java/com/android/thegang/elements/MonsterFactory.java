package com.android.thegang.elements;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.controller.GameThread;
import com.android.thegang.model.MonsterBlock;

import static java.lang.Math.max;

public class MonsterFactory {

    public final static int MONSTER_TYPE_BIRD_0 = 0;
    public final static int MONSTER_TYPE_BIRD_1 = 1;
    public final static int MONSTER_TYPE_DRAGON = 2;
    public final static int MONSTER_TYPE_RANDOM = 3;

    public static MonsterBlock makeMonster(int type, int maxX, int maxY) {

        if (type == MONSTER_TYPE_RANDOM) {
            type = GameThread.random.nextInt(Integer.MAX_VALUE) % MONSTER_TYPE_RANDOM;
        }

        MonsterBlock monsterBlock = null;

        switch (type) {
            case MONSTER_TYPE_BIRD_0:
            case MONSTER_TYPE_BIRD_1:
                monsterBlock = new MonsterBlock(
                        GameThread.random.nextInt(Integer.MAX_VALUE) % (maxX * 2),
                        GameThread.random.nextInt(Integer.MAX_VALUE) % (maxY / 2),
                        type == MONSTER_TYPE_BIRD_0 ? Bitmaps.bird_0 : Bitmaps.bird_1,
                        false);
                break;
            case MONSTER_TYPE_DRAGON:
                monsterBlock = new MonsterBlock(
                        GameThread.random.nextInt(Integer.MAX_VALUE) % (maxX * 2),
                        GameThread.random.nextInt(Integer.MAX_VALUE) % (maxY / 2),
                        Bitmaps.monster_0, false);
                break;
        }

        monsterBlock.setMaxXY(maxX, maxY / 2);
        monsterBlock.setXSpeed(max(GameThread.random.nextInt() % 40 + 1, 20));
        return monsterBlock;
    }
}
