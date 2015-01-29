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
import com.android.thegang.model.Block;
import com.android.thegang.model.decorators.CloudBlock;
import com.android.thegang.model.decorators.DecoratorBlock;
import com.android.thegang.model.gifts.GiftBlock;
import com.android.thegang.model.monsters.FireBlock;
import com.android.thegang.model.monsters.MonsterBlock;

import java.util.LinkedList;

import static com.android.thegang.controller.GameThread.getRandom;
import static java.lang.Math.max;


public class BlockPool {

    private LinkedList<Block> giftBlocks = new LinkedList<Block>();
    private LinkedList<Block> decoratorBlocks = new LinkedList<Block>();
    private LinkedList<Block> monsterBlocks = new LinkedList<Block>();
    private LinkedList<Block> cloudBlocks = new LinkedList<Block>();
    private LinkedList<Block> fireBlocks = new LinkedList<Block>();

    private static int maxSize, maxX, maxY;

    private static BlockPool instance = null;

    public static BlockPool getInstance(int max, int maxX, int maxY) {
        if (instance == null) {
            instance = new BlockPool(max, maxX, maxY);
        }

        BlockPool.maxX = maxX;
        BlockPool.maxY = maxY;

        return instance;
    }

    public static BlockPool getInstance() {
        return instance;
    }

    public BlockPool(int max, int maxX, int maxY) {
        maxSize = max;

        int oldX = (getRandom(maxX * 2));
        for (int i = 0; i < max; i++) {
            giftBlocks.addLast(GiftFactory.makeGift(
                    GiftFactory.GIFT_TYPE_RANDOM, oldX, maxY / 2, maxX));

            monsterBlocks.addLast(MonsterFactory.makeMonster(
                    MonsterFactory.MONSTER_TYPE_RANDOM, maxX, maxY));
            monsterBlocks.getLast().setX(oldX);

            oldX += max(getRandom(maxX * 2), 120);

            decoratorBlocks.addLast(DecoratorFactory.makeDecor(getRandom(maxX * 2), maxY - 35, maxX));
            cloudBlocks.addLast(new CloudBlock(maxX, maxY / 3));

            fireBlocks.addLast(new FireBlock(
                    maxX / 2, maxY / 2, Bitmaps.eggs[getRandom(Bitmaps.eggs.length)]));
        }

    }

    public final static int BLOCKPOOL_TYPE_DECORATOR = 0;
    public final static int BLOCKPOOL_TYPE_GIFT = 1;
    public final static int BLOCKPOOL_TYPE_CLOUD = 2;
    public final static int BLOCKPOOL_TYPE_FIRE = 3;
    public final static int BLOCKPOOL_TYPE_MONSTER = 4;

    public Block getBlock(int type) {
        switch (type) {
            case BLOCKPOOL_TYPE_CLOUD:
                return cloudBlocks.removeFirst();
            case BLOCKPOOL_TYPE_DECORATOR:
                return decoratorBlocks.removeFirst();
            case BLOCKPOOL_TYPE_FIRE:
                return fireBlocks.removeFirst();
            case BLOCKPOOL_TYPE_GIFT:
                return giftBlocks.removeFirst();
            case BLOCKPOOL_TYPE_MONSTER:
                return monsterBlocks.removeFirst();
        }

        return null;
    }

    public void addBlock(Block block) {
        if (block instanceof DecoratorBlock) {
            decoratorBlocks.addLast(block);;
        } else if (block instanceof GiftBlock) {
            giftBlocks.addLast(block);
        } else if (block instanceof CloudBlock) {
            cloudBlocks.addLast(block);
        } else if (block instanceof FireBlock) {
            fireBlocks.addLast(block);
        } else if (block instanceof MonsterBlock) {
            monsterBlocks.addLast(block);
        }
    }
}
