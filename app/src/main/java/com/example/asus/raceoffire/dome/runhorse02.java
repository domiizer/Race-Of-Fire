package com.example.asus.raceoffire.dome;

import android.graphics.Color;
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

public class runhorse02 extends FMXScreen {
    FMXImage floor02, h01, h02, h03, finline;
    double rrr, floorsie, pilsuk01, pilsuk02, pilsuk03, linesie, delauy, floorsiez = 1211,distime;
    int runframeH, x = 0, y = constan.SCREEN_WIDTH, horsew = 138, horseh = 104, cnn = 0, posNow = 0;
    int ddda = 1, dddb = 1, dddc = 1, dddd = 1, ddde = 1, s1, s2;
    boolean test = true;
    Random random = new Random();

    public runhorse02(FMXGame game) {
        super(game);

        FMXGraphics g = game.getGraphics();
        floor02 = g.newImage("floorrun2.png", FMXGraphics.ImageFormat.ARGB4444);
        h01 = g.newImage("horse01.png", FMXGraphics.ImageFormat.ARGB4444);
        h02 = g.newImage("horse02.png", FMXGraphics.ImageFormat.ARGB4444);
        h03 = g.newImage("horse03.png", FMXGraphics.ImageFormat.ARGB4444);
        finline = g.newImage("line.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.winners = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            constan.winners.add(i);
        }

        Collections.shuffle(constan.winners);
        Log.i("sdgsdg", "runhorse02: " + constan.winners);
    }

    @Override
    public void update(float deltaTime) {
//        if (test==true)
        delauy += deltaTime * 0.01;
//        if (constan.SCREEN_HEIGHT-linesie<=constan.SCREEN_HEIGHT/2)
//            test=false;
        finish(deltaTime);
        if (delauy >= 5) {
            posNow = random.nextInt(100);
            delauy = 0;
        }
        runset(deltaTime);
        /////////////////////////////////////Floor
        if (s1 - floorsie <= -1111) {
            s1 = constan.SCREEN_HEIGHT;
            floorsie = 0;
        }
        if (s2 - floorsiez <= -1111) {
            s2 = constan.SCREEN_HEIGHT;
            floorsiez = 0;
        }
        //////////////////////////////////////End Flor
        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.clearScreen(Color.BLACK);
        g.drawImage(floor02, (int) (s1 - floorsie), constan.SCREEN_WIDTH - 187);
        g.drawImage(floor02, (int) (s2 - floorsiez), constan.SCREEN_WIDTH - 187);
//        if (cnn>=15)
//        g.drawImage(finline, (int) (constan.SCREEN_HEIGHT-linesie),constan.SCREEN_WIDTH - 187);
        g.drawImage(h01, (int) ((x + pilsuk01)-distime), y - 280, 138 * runframeH, 0, horsew, horseh);
//        g.drawImage(h02, (int) (x + pilsuk02), y - 250, horsew * runframeH, 0, horsew, horseh);
//        g.drawImage(h03, (int) (x + pilsuk03), y - 220, horsew * runframeH, 0, horsew, horseh);

    }

    public void runset(Float deltaTime) {
        rrr += deltaTime * 0.01 * 20;
        runframeH = (int) (rrr % 4);
//        if (pilsuk01-cnn>=constan.SCREEN_HEIGHT/2)
        floorsie += deltaTime * 0.01 * 550;
        floorsiez += deltaTime * 0.01 * 550;

        pilsuk01 += deltaTime * 0.01 * 50;
        distime+=deltaTime * 0.01 * 50;
//        if (posNow >= 70) {
//            pilsuk01 -= deltaTime * 0.01 * 50;
//        }
//        if (posNow < 70) {
//            pilsuk01 += deltaTime * 0.01 * 50;
//        }
//
//        if (posNow >= 50) {
//            pilsuk02 -= deltaTime * 0.01 * 50;
//        }
//        if (posNow < 50) {
//            pilsuk02 += deltaTime * 0.01 * 50;
//        }

//        if (cnn>15)
//            linesie += deltaTime * 0.01 * 550;
//        if (floorsie > 1211 - constan.SCREEN_HEIGHT){
//            floorsie = 0;
//            cnn++;
//            Log.i("y5rev", "update: "+cnn);
//        }
//
//        if (ddda==1) {
//            pilsuk01 += deltaTime * 0.01 * 100;
//            if (pilsuk01>=constan.SCREEN_HEIGHT/2-horsew/2)
//                ddda=0;
//        }else if (ddda==0){
//            pilsuk01 -= deltaTime * 0.01 * 50;
//            if (pilsuk01<=horsew/2)
//                ddda=1;
//        }
//
//
//        if (dddb==1) {
//            pilsuk02 += deltaTime * 0.01 * 80;
//            if (pilsuk02>=constan.SCREEN_HEIGHT/2-horsew/2)
//                dddb=0;
//        }else if (dddb==0){
//            pilsuk02 -= deltaTime * 0.01 * 40;
//            if (pilsuk02<=horsew/2)
//                dddb=1;
//        }
//
//
//        if (dddc==1) {
//            pilsuk03 += deltaTime * 0.01 * 60;
//            if (pilsuk03>=constan.SCREEN_HEIGHT/2-horsew/2)
//                dddc=0;
//        }else if (dddc==0){
//            pilsuk03 -= deltaTime * 0.01 * 30;
//            if (pilsuk03<=horsew/2)
//                dddc=1;
//        }
    }

    public void finish(Float deltaTime) {

    }

    public void setpos() {

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

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {

                if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2, 0, constan.SCREEN_WIDTH / 2, constan.SCREEN_HEIGHT / 2)) {
                    Log.i("sdsdg", "checkTouch: ");
                }
                if (dome.inBounds(event, 0, 0, constan.SCREEN_WIDTH / 2, constan.SCREEN_HEIGHT / 2)) {
                    Log.i("sadgsdg", "checkTouch: ");
                }

            }
        }
    }
}
