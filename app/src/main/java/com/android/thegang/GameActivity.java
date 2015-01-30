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

package com.android.thegang;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

import com.android.thegang.assets.Bitmaps;
import com.android.thegang.view.GamePanel;


public class GameActivity extends Activity implements GestureDetector.OnGestureListener {

    public SoundPool getSounds() {
        return sounds;
    }

    private SoundPool sounds;
    private MediaPlayer player;

    public int getJumpID() {
        return jumpID;
    }

    public int getHitID() {
        return hitID;
    }

    private int jumpID, hitID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bitmaps.loadBitmapStore(this);

        sounds = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        player = MediaPlayer.create(this, R.raw.background);
        player.setLooping(true);
        player.start();

        jumpID = sounds.load(this, R.raw.jump, 1);
        hitID = sounds.load(this, R.raw.hit, 1);

        gamePanel = new GamePanel(this);
        setContentView(gamePanel);

        gDetector = new GestureDetector(getBaseContext(), this);
    }

    private GestureDetector gDetector;
    private GamePanel gamePanel;

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d("GameActivity", "Destroying...");
        super.onDestroy();
        player.pause();
        player.stop();
        player.release();
    }

    @Override
    protected void onStop() {
        Log.d("GameActivity", "Stopping...");
        super.onStop();
        player.pause();
        player.stop();
        player.release();
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        gamePanel.onSingleTapUp(motionEvent);
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float v, float v2) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onFling(MotionEvent start, MotionEvent finish, float xVelocity, float yVelocity) {
        gamePanel.onFling(start, finish, xVelocity, yVelocity);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gDetector.onTouchEvent(event);
    }
}