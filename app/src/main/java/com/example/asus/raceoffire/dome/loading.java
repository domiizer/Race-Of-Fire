package com.example.asus.raceoffire.dome;

import com.example.asus.raceoffire.framework.FMXGame;
import com.example.asus.raceoffire.framework.FMXGraphics;
import com.example.asus.raceoffire.framework.FMXImage;
import com.example.asus.raceoffire.framework.FMXScreen;

import java.util.ArrayList;

public class loading extends FMXScreen {
    FMXImage loadbg;
    private double timek;

    public loading(FMXGame load) {
        super(load);
        FMXGraphics g = game.getGraphics();
        loadbg = g.newImage("loadpic.jpg", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip25 = g.newImage("tile000.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip50 = g.newImage("tile001.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip100 = g.newImage("tile002.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip500 = g.newImage("tile003.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip1k = g.newImage("tile004.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.point = g.newImage("point.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.ibg = g.newImage("logo_iam.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.setbg = g.newImage("setting.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.shpayout = g.newImage("pay out.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.fxchip = g.newImage("chip_effect.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.betroom = g.newImage("bet room.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.mainbg = g.newImage("bgmain.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.horse = g.newImage("horse2.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip1 = g.newImage("tile100.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip2 = g.newImage("tile101.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip3 = g.newImage("tile102.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip4 = g.newImage("tile103.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip5 = g.newImage("tile104.png", FMXGraphics.ImageFormat.ARGB4444);

        constan.chip01 = g.newImage("tile010.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip02 = g.newImage("tile011.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip03 = g.newImage("tile012.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip04 = g.newImage("tile013.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.chip05 = g.newImage("tile014.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.lal = g.newImage("05_username_credit_box.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.statbody=g.newImage("statbody.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stathead=g.newImage("stathead.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.statline=g.newImage("statline.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.statenumber=g.newImage("statnumber.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.statposition=g.newImage("position.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.statbtnX=g.newImage("statbtnx.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.result=g.newImage("win lose.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.shhowto=g.newImage("howto.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[0]=g.newImage("pos01.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[1]=g.newImage("pos02.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[2]=g.newImage("pos03.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[3]=g.newImage("pos04.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[4]=g.newImage("pos05.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[5]=g.newImage("pos06.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[6]=g.newImage("pos07.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[7]=g.newImage("pos08.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[8]=g.newImage("pos09.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.stattest[9]=g.newImage("pos10.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.setBot=g.newImage("settingBot.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.arrow=g.newImage("arrow bt.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.exitAlert =g.newImage("exitalret.png",FMXGraphics.ImageFormat.ARGB4444);
        constan.exitBT=g.newImage("exitBT.png",FMXGraphics.ImageFormat.ARGB4444);

        for(int i = 0; i < 10; i++)  {
            constan.StatusHalf.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < 10; i++)  {
            constan.StatusFull.add(new ArrayList<Integer>());
        }

    }

    @Override
    public void update(float deltaTime) {
        timek += deltaTime * 0.01 * 5;
        if (timek >= 5)
            game.setScreen(new Select(game));

    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(loadbg, 0, 0);
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
