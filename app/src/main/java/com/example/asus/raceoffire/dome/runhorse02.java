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
    private FMXImage floor02, finline;
    private FMXImage[] horse = new FMXImage[10];
    private double rrr, floorsie, pilsuk01, pilsuk02, pilsuk03, linesie, delauy, floorsiez = 1200, distance=11000,floornekoya,s,v,t,tsst,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    private int  y = constan.SCREEN_WIDTH, horsew = 138, horseh = 104, cnn = 0, posNow = 0;
    private int ddda = 1, dddb = 1, dddc = 1, dddd = 1, ddde = 1, s1, s2, speed,bounds;
    private int[] controlrun = new int[10],x =new int[10],runframeH=new int[10];
    boolean test = true;
    private float[] tall = new float[10];
    private double[] speedhorse = new double[10];
    private double[] testhorseT=new double[10], testhorseT2 =new double[10],testhorseT3=new double[10],testhorseT4=new double[10],testhorseT5=new double[10],testhorseT6=new double[10],testhorseT7=new double[10],testhorseT8=new double[10],testhorseT9=new double[10],testhorseT10=new double[10];
   private Random random = new Random();

    public runhorse02(FMXGame game) {
        super(game);

        FMXGraphics g = game.getGraphics();
        floor02 = g.newImage("floorrun2.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[0] = g.newImage("horse01.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[1] = g.newImage("horse02.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[2] = g.newImage("horse03.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[3] = g.newImage("horse04.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[4] = g.newImage("horse05.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[5] = g.newImage("horse06.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[6] = g.newImage("horse07.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[7] = g.newImage("horse08.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[8] = g.newImage("horse09.png", FMXGraphics.ImageFormat.ARGB4444);
        horse[9] = g.newImage("horse010.png", FMXGraphics.ImageFormat.ARGB4444);
        finline = g.newImage("line.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.winners = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            constan.winners.add(i);
        }

        Collections.shuffle(constan.winners);
        controlrun[0]=500;
        controlrun[1]=450;
        controlrun[2]=480;
        for (int i = 0; i <speedhorse.length ; i++) {
            speedhorse[i]=0;
        }
        bounds=70;
        for (int i = 0; i < testhorseT.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT[i]);
            tall[0]+=v/1000;
        }

        for (int i = 0; i < testhorseT2.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT2[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+ testhorseT2[i]);
            tall[1]+=v/1000;
        }

        for (int i = 0; i < testhorseT3.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT3[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT3[i]);
            tall[2]+=v/1000;
        }

        for (int i = 0; i < testhorseT4.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT4[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT4[i]);
            tall[3]+=v/1000;
        }

        for (int i = 0; i < testhorseT5.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT5[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT5[i]);
            tall[4]+=v/1000;
        }

        for (int i = 0; i < testhorseT6.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT6[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT6[i]);
            tall[5]+=v/1000;
        }

        for (int i = 0; i < testhorseT7.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT7[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT7[i]);
            tall[6]+=v/1000;
        }

        for (int i = 0; i < testhorseT8.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT8[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT8[i]);
            tall[7]+=v/1000;
        }

        for (int i = 0; i < testhorseT9.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT9[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT9[i]);
            tall[8]+=v/1000;
        }

        for (int i = 0; i < testhorseT10.length; i++) {
            v=random.nextInt(bounds)+100;
            testhorseT10[i]=v/1000;
            Log.i("testhorseT", "runhorse02: "+testhorseT10[i]);
            tall[9]+=v/1000;
        }

        Log.i("ssssss", "iiiiiiiiii"+tall[0]+"/"+tall[1]+"/"+tall[2]+"/"+tall[3]+"/"+tall[4]+"/"+tall[5]+"/"+tall[6]+"/"+tall[7]+"/"+tall[8]+"/"+tall[9]);


    }

    @Override
    public void update(float deltaTime) {
        if (speedhorse[0]<distance-70) {

            delauy += deltaTime * 0.01;
            if (delauy>2)
//            runset(deltaTime);
            runset2(deltaTime);
            finish(deltaTime);
            /////////////////////////////////////Floor
            if (constan.SCREEN_HEIGHT - floorsie < -1150) {
                floorsie = 0;
            }
            if (constan.SCREEN_HEIGHT - floorsiez < -1150) {
                floorsiez = 0;
            }
            //////////////////////////////////////End Flor

        }
        checkTouch();

    }



    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.clearScreen(Color.BLACK);
        g.drawImage(floor02, (int) (constan.SCREEN_HEIGHT - floorsie), constan.SCREEN_WIDTH - 187);
        g.drawImage(floor02, (int) (constan.SCREEN_HEIGHT - floorsiez), constan.SCREEN_WIDTH - 187);
        Log.i("sdfdsadf", "update: "+(distance-linesie));

        g.drawImage(finline, (int) (distance - linesie), constan.SCREEN_WIDTH - 187);
        for (int i = 0; i <horse.length ; i++) {
//            g.drawImage(horse[1], (int) (speedhorse[1]- floornekoya)-80, y - 250, horsew * runframeH[1], 0, horsew, horseh);
            g.drawImage(horse[i], (int) (speedhorse[i]- floornekoya)-80, constan.SCREEN_WIDTH - 104 - 18 * (9-i), 138 * runframeH[i], 0, 138, 104);

        }
//        g.drawImage(horse[0], (int) (speedhorse[0] -floornekoya)-80, y - 280, 138 * runframeH[0], 0, horsew, horseh);
//        g.drawImage(horse[1], (int) (speedhorse[1]- floornekoya)-80, y - 250, horsew * runframeH[1], 0, horsew, horseh);
//        g.drawImage(horse[2], (int) (speedhorse[2]- floornekoya)-80, y - 220, horsew * runframeH[2], 0, horsew, horseh);
    }

    public void runset(Float deltaTime) {
        for (int i = 0; i <runframeH.length ; i++) {
            rrr += deltaTime * 0.01 * controlrun[i]/100;
            runframeH[i] = (int) (rrr % 4);
        }
        for (int i = 0; i <10 ; i++) {
            speedhorse[i]+= deltaTime*0.01* controlrun[i];
//            x[i]= (int) speedhorse[i];
            if (speedhorse[i]-floornekoya>=constan.SCREEN_HEIGHT/2){
                floorsie += deltaTime * 0.01 * controlrun[i];
                floorsiez += deltaTime * 0.01 * controlrun[i];
                floornekoya+=deltaTime*0.01* controlrun[i];
                linesie+=deltaTime*0.01* controlrun[i];
            }
        }
    }

    private void runset2(float deltaTime) {
if (cnn<=9) {

    speedhorse[0] += deltaTime * testhorseT[cnn] * 30;
    speedhorse[1] += deltaTime * testhorseT2[cnn] * 30;
    speedhorse[2] += deltaTime * testhorseT3[cnn] * 30;
    speedhorse[3] += deltaTime * testhorseT4[cnn] * 30;
    speedhorse[4] += deltaTime * testhorseT5[cnn] * 30;
    speedhorse[5] += deltaTime * testhorseT6[cnn] * 30;
    speedhorse[6] += deltaTime * testhorseT7[cnn] * 30;
    speedhorse[7] += deltaTime * testhorseT8[cnn] * 30;
    speedhorse[8] += deltaTime * testhorseT9[cnn] * 30;
    speedhorse[9] += deltaTime * testhorseT10[cnn] * 30;
    for (int i = 0; i <runframeH.length ; i++) {
        rrr += deltaTime * 0.01 * controlrun[i]/100;
        runframeH[i] = (int) (rrr % 4);
    }
    Log.i("sdfsa", "runset2: "+cnn);
    for (int i = 0; i < 10; i++) {
        if (speedhorse[i] - floornekoya >= constan.SCREEN_HEIGHT / 2) {
            floorsie += deltaTime * testhorseT[cnn] * 30;
            floorsiez += deltaTime * testhorseT[cnn] * 30;
            floornekoya += deltaTime * testhorseT[cnn] * 30;
            linesie += deltaTime * testhorseT[cnn] * 30;
        }
    }
}
else {
    speedhorse[0] += deltaTime *testhorseT2[9] * 30;
    speedhorse[1] += deltaTime * testhorseT2[9] * 30;
    speedhorse[2] += deltaTime * testhorseT2[9] * 30;
    speedhorse[3] += deltaTime * testhorseT2[9] * 30;
    speedhorse[4] += deltaTime * testhorseT2[9] * 30;
    speedhorse[5] += deltaTime * testhorseT2[9] * 30;
    speedhorse[6] += deltaTime * testhorseT2[9] * 30;
    speedhorse[7] += deltaTime * testhorseT2[9] * 30;
    speedhorse[8] += deltaTime * testhorseT2[9] * 30;
    speedhorse[9] += deltaTime * testhorseT2[9] * 30;

}
        tsst+=deltaTime*0.01;
        if (tsst>=4&&cnn<=9) {
            cnn++;
            tsst=0;
        }
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
