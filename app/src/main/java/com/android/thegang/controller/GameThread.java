package com.android.thegang.controller;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.android.thegang.view.GamePanel;

import java.util.Random;

public class GameThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private GamePanel gamePanel;
    private boolean running;

    public static final Random random = new Random(System.currentTimeMillis());

    public GameThread(SurfaceHolder surfaceHolder, GamePanel gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private final static long FPS = 25;

    @Override
    public void run() {
        Canvas canvas;
        long startTime, sleepTime, ticksPS = 1000 / FPS;

        while (running) {
            canvas = null;
            startTime = System.currentTimeMillis();

            try {
                canvas = surfaceHolder.lockCanvas(null);
                synchronized (surfaceHolder) {

                    gamePanel.doDraw(canvas);
                }
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

            sleepTime = ticksPS - (System.currentTimeMillis() - startTime);
            try {
                if (sleepTime > 0) {
                    sleep(sleepTime);
                    random.setSeed(sleepTime);
                } else
                    sleep(17);
            } catch (Exception e) {
            }
        }
    }
}
