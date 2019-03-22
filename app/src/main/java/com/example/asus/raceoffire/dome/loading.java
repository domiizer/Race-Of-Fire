package com.example.asus.raceoffire.dome;

import com.example.asus.raceoffire.framework.FMXGame;
import com.example.asus.raceoffire.framework.FMXGraphics;
import com.example.asus.raceoffire.framework.FMXImage;
import com.example.asus.raceoffire.framework.FMXScreen;
import com.example.asus.raceoffire.framework.implementation.FMXAndroidGame;

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
        constan.ibg = g.newImage("menu_button_small.png", FMXGraphics.ImageFormat.ARGB4444);
        constan.iicon = g.newImage("iiconpng.png", FMXGraphics.ImageFormat.ARGB4444);
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
        constan.mainbg = g.newImage("bgmain.png", FMXGraphics.ImageFormat.ARGB4444);

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
