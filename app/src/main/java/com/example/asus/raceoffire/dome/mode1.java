package com.example.asus.raceoffire.dome;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.asus.raceoffire.framework.FMXGame;
import com.example.asus.raceoffire.framework.FMXGraphics;
import com.example.asus.raceoffire.framework.FMXImage;
import com.example.asus.raceoffire.framework.FMXInput;
import com.example.asus.raceoffire.framework.FMXScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class mode1 extends FMXScreen {
    private FMXImage horse2, bar2, button, userbar, table1, table2, shiftbar, chip, bgbet, bghorse, lal;
    private int horseW = 72, horseH = 178, chipSize = 72, add = 0, betW = 120, rass, xxixx = 0, abs;
    private double exid;
    private boolean numC;
    private int price, bytouch, ddsi = 138;
    public float distance = 0, olddis;
    public float time = 0;
    public float velocity = 0;
    float[] checktime = new float[10];
    Random rn = new Random();
    Integer[] checkshowbet = {0, 0, 0, 0};
    Integer[] checkshowhosre = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer[] arrnum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    Integer[] arr1st = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    //    double[][] speed=new double[10][18];
    Random randomtime = new Random();
    double aeiou;
    private int centos;
    private boolean showpayout = false;
    private boolean sound = true;
    private int amd = 1;

    public mode1(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();

        bar2 = g.newImage("bar2.png", FMXGraphics.ImageFormat.ARGB4444);
        button = g.newImage("button.png", FMXGraphics.ImageFormat.ARGB4444);
        userbar = g.newImage("user bar.png", FMXGraphics.ImageFormat.ARGB4444);
        table1 = g.newImage("table 1.png", FMXGraphics.ImageFormat.ARGB4444);
        table2 = g.newImage("table 2.png", FMXGraphics.ImageFormat.ARGB4444);
        shiftbar = g.newImage("Shift bar.png", FMXGraphics.ImageFormat.ARGB4444);
        bgbet = g.newImage("bar1.png", FMXGraphics.ImageFormat.ARGB4444);
        bghorse = g.newImage("horse1.png", FMXGraphics.ImageFormat.ARGB4444);

        lal = g.newImage("05_username_credit_box.png", FMXGraphics.ImageFormat.ARGB4444);
//        g.drawImage(bghorse,constan.SCREEN_HEIGHT/2-382,47);
//        g.drawImage(horse2,constan.SCREEN_HEIGHT/2-357,50,0,0,714,176);//horse
//        g.drawImage(bgbet,constan.SCREEN_HEIGHT/2-264,226);
//        g.drawImage(bar2,constan.SCREEN_HEIGHT/2-241,226,0,0,482,132);//bet odd etc
        constan.winners = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            constan.winners.add(i);
        }

        Collections.shuffle(constan.winners);
        bytouch = 0;
        clear();
    }

    @Override
    public void update(float deltaTime) {

        for (int i = 0; i <= constan.chipsReds.size() - 1; i++) {
            constan.chipsReds.get(i).tick(deltaTime);
        }
        exid += deltaTime * 0.01 * 50;
        if (exid >= 20)
            exid = 0;

    }

    int c = 0, d = 0, a = 0;

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(10);
        g.drawImage(constan.mainbg, 0, 0);
        g.drawImage(constan.betroom, constan.SCREEN_HEIGHT - 400, 0, 0, 45 * constan.selectbetroom, 255, 45);
        g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 60, +10);
        g.drawImage(constan.iicon, constan.SCREEN_HEIGHT - 55, +12, 18 * amd, 0, 18, 20);
        g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 100, +10);
        g.drawImage(constan.iicon, constan.SCREEN_HEIGHT - 95, +12, 0, 0, 18, 20);
        g.drawImage(bghorse, constan.SCREEN_HEIGHT / 2 - 384, 49);
        g.drawImage(constan.horse, constan.SCREEN_HEIGHT / 2 - 360, 50, 0, 0, horseW*10, horseH);//horse
        g.drawImage(bgbet, constan.SCREEN_HEIGHT / 2 - 264, 226);
        g.drawImage(bar2, constan.SCREEN_HEIGHT / 2 - 241, 226, 0, 0, 482, 132);//bet odd etc
        g.drawImage(table1, constan.SCREEN_HEIGHT / 2 - 383, 226, 0, 0, 138, 223);//win rate
        g.drawImage(table2, constan.SCREEN_HEIGHT / 2 + 246, 226, 0, 0, 138, 223);//stat
        if (constan.status.size() > 0)
            for (int i = constan.status.size(), nl = 0, nt = 4; i > 0; i--, nt--) {
                if (i % 5 == 0) {
                    nl++;
                    nt = 4;
                }
                g.drawString("" + constan.status.get(i - 1), constan.SCREEN_HEIGHT / 2 + 256 + 25 * (nt), 226 + 40 + 30 * nl, paint);
            }
        g.drawImage(userbar, constan.SCREEN_HEIGHT / 2 - 392, constan.SCREEN_WIDTH - 31);
        g.drawImage(shiftbar, constan.SCREEN_HEIGHT / 2 - 244, constan.SCREEN_WIDTH - 92);

        clicked1();
        if (numC == false)
            for (int i = 0; i < 5; i++) {
                g.drawImage(constan.point, (constan.SCREEN_HEIGHT / 2 - 223) + chipSize * i, (int) ((constan.SCREEN_WIDTH - ddsi) + exid));
            }
        if (numC == true) {
            g.drawImage(constan.point, (constan.SCREEN_HEIGHT / 2 - 223) + chipSize * centos, (int) ((constan.SCREEN_WIDTH - ddsi) + exid));
            g.drawImage(constan.fxchip, (constan.SCREEN_HEIGHT / 2 - 223 - 27) + chipSize * centos, (constan.SCREEN_WIDTH - ddsi) + 38);
        }
        if (constan.selectbetroom == 0) {
            g.drawImage(constan.chip1, constan.SCREEN_HEIGHT / 2 - 235, constan.SCREEN_WIDTH - 86);//chipsred
            g.drawImage(constan.chip2, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 1, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip3, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 2, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip4, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 3, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip5, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 4, constan.SCREEN_WIDTH - 86);//chipsaquar
        }
        if (constan.selectbetroom == 1) {
            g.drawImage(constan.chip01, constan.SCREEN_HEIGHT / 2 - 235, constan.SCREEN_WIDTH - 86);//chipsred
            g.drawImage(constan.chip02, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 1, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip03, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 2, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip04, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 3, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip05, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 4, constan.SCREEN_WIDTH - 86);//chipsaquar
        }

        if (constan.selectbetroom == 2) {
            g.drawImage(constan.chip25, constan.SCREEN_HEIGHT / 2 - 235, constan.SCREEN_WIDTH - 86);//chipsred
            g.drawImage(constan.chip50, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 1, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip100, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 2, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip500, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 3, constan.SCREEN_WIDTH - 86);//chipsaquar
            g.drawImage(constan.chip1k, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 4, constan.SCREEN_WIDTH - 86);//chipsaquar
        }

        g.drawImage(button, constan.SCREEN_HEIGHT / 2 + 136, constan.SCREEN_WIDTH - 92, 0, 30 * 0, 96, 30);//clear
        g.drawImage(button, constan.SCREEN_HEIGHT / 2 + 136, constan.SCREEN_WIDTH - 62, 0, 30 * 1, 96, 30);//clear all
        g.drawImage(button, constan.SCREEN_HEIGHT / 2 - 362, constan.SCREEN_WIDTH - 30, 0, 30 * 3, 96, 30);//back
        g.drawImage(button, constan.SCREEN_HEIGHT / 2 + (245 + 69 - 48), constan.SCREEN_WIDTH - 30, 0, 30 * 2, 96, 30);//cf

        g.drawString("" + constan.winners.get(0), constan.SCREEN_HEIGHT / 2 + 246 + 10, 226 + 40, paint);
        g.drawString("" + constan.winners.get(1), constan.SCREEN_HEIGHT / 2 + 246 + 35, 226 + 40, paint);
        g.drawString("" + constan.winners.get(2), constan.SCREEN_HEIGHT / 2 + 246 + 60, 226 + 40, paint);
        g.drawString("" + constan.winners.get(3), constan.SCREEN_HEIGHT / 2 + 246 + 85, 226 + 40, paint);
        g.drawString("" + constan.winners.get(4), constan.SCREEN_HEIGHT / 2 + 246 + 110, 226 + 40, paint);

        for (int i = 0; i <= constan.chipsReds.size() - 1; i++) {
            constan.chipsReds.get(i).paint(g);
        }

        for (int i = 0; i <= constan.arrShowChips1.size() - 1; i++) {
            constan.arrShowChips1.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips2.size() - 1; i++) {
            constan.arrShowChips2.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips3.size() - 1; i++) {
            constan.arrShowChips3.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips4.size() - 1; i++) {
            constan.arrShowChips4.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips5.size() - 1; i++) {
            constan.arrShowChips5.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips6.size() - 1; i++) {
            constan.arrShowChips6.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips7.size() - 1; i++) {
            constan.arrShowChips7.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips8.size() - 1; i++) {
            constan.arrShowChips8.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips9.size() - 1; i++) {
            constan.arrShowChips9.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips10.size() - 1; i++) {
            constan.arrShowChips10.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips11.size() - 1; i++) {
            constan.arrShowChips11.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips12.size() - 1; i++) {
            constan.arrShowChips12.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips13.size() - 1; i++) {
            constan.arrShowChips13.get(i).paint(g);
        }
        for (int i = 0; i <= constan.arrShowChips14.size() - 1; i++) {
            constan.arrShowChips14.get(i).paint(g);
        }
        g.drawImage(lal, 0, 0);
        g.drawImage(lal, 150, 0);
        g.drawString("Bet : " + constan.bet_amount, constan.SCREEN_HEIGHT / 2 - 150, constan.SCREEN_WIDTH - 10, paint);
        g.drawString("" + constan.user, 50, 20, paint);
        g.drawString("Credit : " + constan.credit, 160, 20, paint);

        for (int i = 0; i < 10; i++) {
            g.drawString("" + (constan.shows[i]), constan.SCREEN_HEIGHT / 2 - 315, constan.SCREEN_WIDTH / 2 + 34 + 18 * i, paint);
        }
        if (showpayout == true)
            g.drawImage(constan.shpayout, constan.SCREEN_HEIGHT / 2 - 384, constan.SCREEN_WIDTH / 2 - 240);
        checkTouch();
    }

    void clicked1() {
        FMXGraphics g = game.getGraphics();
        if (numC == true && a == 1) {
            for (int i = 0; i < 10; i++) {
                if (c == i) {
                    if (add == 1) {
                        float startX = (float) (constan.SCREEN_HEIGHT / 2 - 235),
                                startY = (float) constan.SCREEN_WIDTH - 86,
                                endX = (float) constan.SCREEN_HEIGHT / 2 - 322 - 24 + 71 * c,
                                endY = 188 - 24;
                        float distance = (float) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                        float directionX = ((endX - startX) / distance);
                        float directionY = ((endY - startY) / distance);
                        double speed = 7000;
                        float elapsed = 0.01f;
                        double X = startX;
                        double Y = startY;
                        if (constan.credit - price >= 0 && constan.bet_amount + price <= constan.maxroom) {
                            constan.chipsReds.add(new chipsRed(startX, startY, X, Y, endX, endY, speed, distance, directionX, directionY, elapsed, price, c + 1));
                            constan.credit -= price;
                            constan.bet_amount += price;
                        }
                        add = 0;
                    }
                }
            }
        } else if (numC == true && a == 2) {
            for (int i = 0; i < 4; i++) {
                if (d == i) {
                    if (add == 1) {
                        float startX = (float) (constan.SCREEN_HEIGHT / 2),
                                startY = (float) constan.SCREEN_WIDTH,
                                endX = (float) constan.SCREEN_HEIGHT / 2 - 205 + 120 * d,
                                endY = 226 + 66;
                        float distance = (float) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
                        float directionX = ((endX - startX) / distance);
                        float directionY = ((endY - startY) / distance);
                        double speed = 7000;
                        float elapsed = 0.01f;
                        double X = startX;
                        double Y = startY;
                        if (constan.credit - price >= 0&& constan.bet_amount + price <= constan.maxroom) {
                            constan.chipsReds.add(new chipsRed(startX, startY, X, Y, endX, endY, speed, distance, directionX, directionY, elapsed, price, d + 11));
                            constan.credit -= price;
                            constan.bet_amount += price;
                        }
                        add = 0;
                    }
                }
            }
        } else
            add = 0;
        for (int i = 0; i < checkshowhosre.length; i++) {
            if (checkshowhosre[i] > 0)
                g.drawImage(constan.horse, constan.SCREEN_HEIGHT / 2 - 360 + horseW * (i), 50, horseW * (i), horseH, horseW, horseH);
        }
        for (int i = 0; i < checkshowbet.length; i++) {
            if (checkshowbet[i] > 0)
                g.drawImage(bar2, (constan.SCREEN_HEIGHT / 2 - 241) + betW * (i), 226, 120 * (i), 132, betW, 132);//h
        }
    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                //Check Touch by area
                //event  //imagepositionX ///imagepositionY ///imagesizeWidth ///imagesizeHeight
                if (price > 0 && constan.bet_amount + price <= constan.maxroom) {
                    for (int j = 0; j < checkshowhosre.length; j++) {
                        if (dome.inBounds(event, (constan.SCREEN_HEIGHT/2) - 360 + (horseW * j), 50, horseW, horseH) && constan.credit > 0) {
                            Log.i("sdgsag", "checkTouch: "+(horseW*j));
                            add = 1;
                            c = j;
                            a = 1;
                            checkshowhosre[j] = 1;
                        }
                    }
                    for (int j = 0; j < checkshowbet.length; j++) {
                        if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 241) + 120 * (j), 226, 120, 132) && constan.credit > 0) {
                            Log.i("ss5o1", "checkTouch: height");
                            add = 1;
                            a = 2;
                            d = j;
                            checkshowbet[j] = 1;
                        }
                    }
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235), constan.SCREEN_WIDTH - 86, 44, 44)) {
                    Log.i("ss5o1", "checkTouch: 25");
                    numC = true;
                    price = constan.price1;
                    centos = 0;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 1, constan.SCREEN_WIDTH - 86, 48, 48)) {
                    Log.i("ss5o1", "checkTouch: 50");
                    numC = true;
                    price = constan.price2;
                    centos = 1;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 2, constan.SCREEN_WIDTH - 86, 48, 48)) {
                    Log.i("ss5o1", "checkTouch: 100");
                    numC = true;
                    price = constan.price3;
                    centos = 2;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 3, constan.SCREEN_WIDTH - 86, 48, 48)) {
                    Log.i("ss5o1", "checkTouch: 500");
                    numC = true;
                    price = constan.price4;
                    centos = 3;
                }
                if (dome.inBounds(event, (constan.SCREEN_HEIGHT / 2 - 235) + chipSize * 4, constan.SCREEN_WIDTH - 86, 48, 48)) {
                    Log.i("ss5o1", "checkTouch: 1K");
                    numC = true;
                    price = constan.price5;
                    centos = 4;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + (246 + 100 - 48), constan.SCREEN_WIDTH - 30, 96, 30)&&constan.eieiza==1) {
                    Log.i("ss5o1", "checkTouch: CF");
                    game.setScreen(new HorseRun(game));
                    calculate();
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + 136 + 50, constan.SCREEN_WIDTH - 62, 96, 30)) {
                    Log.i("hohohoho", "checkTouch: ");
                    bytouch = 1;
                    clear();
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 75, 10, 30, 30) && showpayout == false) {
                    showpayout = true;
                } else if (dome.inBounds(event, constan.SCREEN_HEIGHT - 75, 10, 30, 30) && showpayout == true) {
                    showpayout = false;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT - 35, 10, 35, 30) && sound == true) {
                    sound = false;
                    amd = 2;
                } else if (dome.inBounds(event, constan.SCREEN_HEIGHT - 35, 10, 35, 30) && sound == false) {
                    sound = true;
                    amd = 1;
                }
                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 362, constan.SCREEN_WIDTH - 30, 100, 40)) {
                    bytouch = 1;
                    clear();
                    game.setScreen(new Select(game));
                }
            }
        }
    }

    public void calculate() {
        constan.count++;
        constan.rounds[constan.winners.get(0) - 1]++;
        for (int i = 0; i < constan.shows.length; i++) {
            constan.shows[i] = (int) ((constan.rounds[i] / constan.count) * 100);
        }
        arr1st[constan.count - 1] = constan.winners.get(0);

        if (constan.winners.get(0) % 2 == 0) {
            constan.payout += constan.bet_sub[12] * 2;
            Log.i("payout[12]", "calculate: even" + constan.bet_sub[12]);
        }

        if (constan.winners.get(0) % 2 == 1) {
            constan.payout += constan.bet_sub[13] * 2;
            Log.i("payout[13]", "calculate: odd" + constan.bet_sub[13]);
        }

        if (constan.winners.get(0) > 5) {
            constan.payout += constan.bet_sub[11] * 2;
            Log.i("payout[11]", "calculate: height" + constan.bet_sub[11]);
        } else {
            constan.payout += constan.bet_sub[10] * 2;
            Log.i("payout[10]", "calculate: low" + constan.bet_sub[10]);
        }

        constan.payout += constan.bet_sub[constan.winners.get(0) - 1] * 6;
        constan.credit += constan.payout;
    }

    public void clear() {
        for (int i = 0; i < checkshowhosre.length; i++) {
            checkshowhosre[i] = 0;
        }
        for (int i = 0; i < checkshowbet.length; i++) {
            checkshowbet[i] = 0;
        }
        c = 0;
        d = 0;
        a = 0;
        if (bytouch == 1)
            constan.credit += constan.bet_amount;

        constan.bet_amount = 0;
        for (int i = 0; i < constan.bet_sub.length; i++) {
            constan.bet_sub[i] = 0;
        }
        constan.arrShowChips1.clear();
        constan.arrShowChips2.clear();
        constan.arrShowChips3.clear();
        constan.arrShowChips4.clear();
        constan.arrShowChips5.clear();
        constan.arrShowChips6.clear();
        constan.arrShowChips7.clear();
        constan.arrShowChips8.clear();
        constan.arrShowChips9.clear();
        constan.arrShowChips10.clear();
        constan.arrShowChips11.clear();
        constan.arrShowChips12.clear();
        constan.arrShowChips13.clear();
        constan.arrShowChips14.clear();
        constan.payout = 0;
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
