package com.example.asus.raceoffire.dome;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.asus.raceoffire.framework.FMXGame;
import com.example.asus.raceoffire.framework.FMXGraphics;
import com.example.asus.raceoffire.framework.FMXImage;
import com.example.asus.raceoffire.framework.FMXInput;
import com.example.asus.raceoffire.framework.FMXScreen;

import java.util.List;
import java.util.Random;

public class HorseRun extends FMXScreen {
    private double run, runC, runF, deley, peuw;
    private int runframeH, xxixx = 0, a = 0,ff,peuwa;
    private int lege = 18, bound = 50, pluss = 200;
    private int[] h = new int[10], r = new int[10];
    double[] speed = new double[25];
    Random randomtime = new Random();
    FMXImage ready, ready2, endtable, endbg, endbt, crows,igol,igor;
    private int cpaint = 0;

    public HorseRun(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        constan.BG = g.newImage("bg 5.jpg", FMXGraphics.ImageFormat.ARGB4444);

        constan.test[0] = g.newImage("horse01.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[1] = g.newImage("horse02.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[2] = g.newImage("horse03.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[3] = g.newImage("horse04.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[4] = g.newImage("horse05.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[5] = g.newImage("horse06.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[6] = g.newImage("horse07.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[7] = g.newImage("horse08.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[8] = g.newImage("horse09.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.test[9] = g.newImage("horse010.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.starto = g.newImage("start.png", FMXGraphics.ImageFormat.ARGB4444);
        ready2 = g.newImage("ready2.png", FMXGraphics.ImageFormat.ARGB4444);
        ready = g.newImage("ready.png", FMXGraphics.ImageFormat.ARGB4444);
        endtable = g.newImage("endbg2.png", FMXGraphics.ImageFormat.ARGB4444);
        endbg = g.newImage("endbg.png", FMXGraphics.ImageFormat.ARGB4444);
        endbt = g.newImage("finish bt.png", FMXGraphics.ImageFormat.ARGB4444);
        crows = g.newImage("crown.png", FMXGraphics.ImageFormat.ARGB4444);
        igol=g.newImage("fire left.png",FMXGraphics.ImageFormat.ARGB4444);
        igor=g.newImage("fire right.png",FMXGraphics.ImageFormat.ARGB4444);
        for (int i = 0; i < constan.speed.length; i++) {
            r[i] = 0;
            constan.runCamera = 0;
        }
        deley = 0;
        run = 0;
        for (int i = 0; i < 5; i++) {
            constan.status.add(constan.winners.get(i));
        }
        Log.i("usigfl", "HorseRun: " + constan.status);
//        constan.mamaza.add(new mamamamama(0));
//        constan.mamaza.add(new mamamamama(1));
//        constan.mamaza.add(new mamamamama(2));
//        constan.mamaza.add(new mamamamama(3));
//        constan.mamaza.add(new mamamamama(4));
//        constan.mamaza.add(new mamamamama(5));
//        constan.mamaza.add(new mamamamama(6));
//        constan.mamaza.add(new mamamamama(7));
//        constan.mamaza.add(new mamamamama(8));
//        constan.mamaza.add(new mamamamama(9));

    }

    @Override
    public void update(float deltaTime) {
        checkTouch();
        for (int i = 0; i <= constan.mamaza.size() - 1; i++) {
            constan.mamaza.get(i).tick(deltaTime);
        }
        runF+=deltaTime * 0.01*20;
        ff= (int) (runF%5);
        if (deley<=0.5)
        deley += deltaTime * 0.01;
        run += deltaTime * 0.01 * 10;

        if (run <= 20) {
            for (int i = 0; i < h.length; i++) {
                h[i] = randomtime.nextInt(bound + 50) + pluss;
            }
            peuw += deltaTime * 0.01 * 2;
            peuwa= (int) peuw%4;
        }

        if (run >= 20) {
            cpaint = 1;
            if (deley > 0.5) {
                for (int i = 0; i < h.length; i++) {

                    if (constan.winners.get(0) - 1 == i) {
                        h[i] = randomtime.nextInt(bound) + (pluss + 80);
                    }
                    if (constan.winners.get(1) - 1 == i) {
                        h[i] = randomtime.nextInt(bound) + (pluss + 70);
                    }
                    if (constan.winners.get(2) - 1 == i) {
                        h[i] = randomtime.nextInt(bound) + (pluss + 60);
                    }
                    if (constan.winners.get(3) - 1 == i) {
                        h[i] = randomtime.nextInt(bound) + (pluss + 50);
                    }
                    if (constan.winners.get(4) - 1 == i) {
                        h[i] = randomtime.nextInt(bound) + (pluss + 40);
                    }
                    if (i != constan.winners.get(4) - 1 && i != constan.winners.get(3) - 1 && i != constan.winners.get(2) - 1 && i != constan.winners.get(1) - 1 && i != constan.winners.get(0) - 1)
                        h[i] = randomtime.nextInt(bound) + pluss;
                }
                deley = 0;
            }
            runframeH = (int) (run % 4);// sprite Horse
            for (int i = 0; i < constan.speed.length; i++) {
//                r[i] += deltaTime * 0.01 * constan.speed[i][rapeak];
                r[i] += deltaTime * 0.01 * h[i];
                if (r[i] - constan.runCamera >= constan.SCREEN_HEIGHT / 2 - 138 && constan.runCamera <= 2791 - constan.SCREEN_HEIGHT) {
                    constan.runCamera += deltaTime * 0.01 * h[i];
                    a = 0;
                }
                if (r[i] - constan.runCamera >= constan.SCREEN_HEIGHT - 250)
                    a = 1;
            }

        }
    }

    @Override
    public void paint(float deltaTime) {

        FMXGraphics g = game.getGraphics();
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(10);
        g.drawImage(constan.BG, 0, 0, (int) (0 + constan.runCamera), 0, constan.SCREEN_HEIGHT, constan.SCREEN_WIDTH);
        for (int i = 0; i <= constan.mamaza.size() - 1; i++) {
            constan.mamaza.get(i).paint(g);
        }

        for (int i = 0, x = 9; i < constan.test.length; i++, x--) {
            g.drawImage(constan.test[i], (int) (r[i] - constan.runCamera), constan.SCREEN_WIDTH - 104 - lege * x, 138 * runframeH, 0, 138, 104);
        }

        g.drawImage(constan.starto, (int) (0 - constan.runCamera), constan.SCREEN_WIDTH - 372);
        if (cpaint == 0) {
            g.drawImage(ready, constan.SCREEN_HEIGHT / 2 - 125, constan.SCREEN_WIDTH / 2 - 109);
            g.drawImage(ready2, constan.SCREEN_HEIGHT / 2 - 78, constan.SCREEN_WIDTH / 2 - 40, 157*peuwa, 0, 157, 136);

        }
        if (a == 1)
            showwin(g);
    }

    private void showwin(FMXGraphics g) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(20);
        g.drawRectBG(0,0,constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,Color.BLACK,155);
        g.drawString("win" + constan.payout, constan.SCREEN_HEIGHT / 2, constan.SCREEN_WIDTH, paint);
        g.drawImage(igol,0,constan.SCREEN_WIDTH-411,327*ff,0,327,411);
        g.drawImage(igor,constan.SCREEN_HEIGHT-327,constan.SCREEN_WIDTH-411,327*ff,0,327,411);
        g.drawImage(endtable, constan.SCREEN_HEIGHT / 2 - 134, constan.SCREEN_WIDTH / 2 - 220);
        for (int i = 0; i < constan.winners.size(); i++) {
            if (constan.winners.get(0) - 1 == i)
                g.drawImage(constan.test[i], constan.SCREEN_HEIGHT / 2 - 69, constan.SCREEN_WIDTH / 2 - 120, 138 * runframeH, 0, 138, 104);
        }
        g.drawImage(endbt, constan.SCREEN_HEIGHT - 180, constan.SCREEN_WIDTH - 70, 0, 0, 141, 51);
        g.drawImage(crows, constan.SCREEN_HEIGHT / 2, constan.SCREEN_WIDTH / 2 - 160);
        g.drawString("เดิมพันต่ำ : " + constan.bet_sub[11], constan.SCREEN_HEIGHT / 2 - 125, constan.SCREEN_WIDTH / 2 + 35, paint);
        g.drawString("เดิมพันสูง : " + constan.bet_sub[10], constan.SCREEN_HEIGHT / 2 - 125, constan.SCREEN_WIDTH / 2 + 35 * 2, paint);
        g.drawString("เดิมพันคู่ : " + constan.bet_sub[12], constan.SCREEN_HEIGHT / 2 - 125, constan.SCREEN_WIDTH / 2 + 35 * 3, paint);
        g.drawString("เดิมพันคี่ : " + constan.bet_sub[13], constan.SCREEN_HEIGHT / 2 - 125, constan.SCREEN_WIDTH / 2 + 35 * 4, paint);
        g.drawString("เดิมพันม้า" + constan.winners.get(0) + " : " + constan.bet_sub[constan.winners.get(0) - 1], constan.SCREEN_HEIGHT / 2 - 125, constan.SCREEN_WIDTH / 2 + 35 * 5, paint);
        g.drawString("ชนะ" + (constan.payout - constan.bet_amount), constan.SCREEN_HEIGHT / 2, constan.SCREEN_WIDTH / 2 + 35 * 6, paint);

    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 180, constan.SCREEN_WIDTH - 70, 141, 51) && a == 1) {
                    game.setScreen(new mode1(game));
                }
            }
        }
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {

    }
}
