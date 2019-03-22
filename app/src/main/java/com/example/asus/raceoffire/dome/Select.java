package com.example.asus.raceoffire.dome;

import android.util.Log;

import com.example.asus.raceoffire.framework.FMXGame;
import com.example.asus.raceoffire.framework.FMXGraphics;
import com.example.asus.raceoffire.framework.FMXImage;
import com.example.asus.raceoffire.framework.FMXInput;
import com.example.asus.raceoffire.framework.FMXScreen;

import java.util.List;


public class Select extends FMXScreen {
    private FMXImage background, bet1, bet2, bet3, bt1, bt2, bt3;
    private int mCurrentScreen = 0, egick;
    private double din01, din02, din03, gick;

    public Select(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        bet1 = g.newImage("mode1.png", FMXGraphics.ImageFormat.ARGB4444);
        bet2 = g.newImage("mode2.png", FMXGraphics.ImageFormat.ARGB4444);
        bet3 = g.newImage("mode3.png", FMXGraphics.ImageFormat.ARGB4444);
        bt1 = g.newImage("modebt1.png", FMXGraphics.ImageFormat.ARGB4444);
        bt2 = g.newImage("modebt2.png", FMXGraphics.ImageFormat.ARGB4444);
        bt3 = g.newImage("modebt3.png", FMXGraphics.ImageFormat.ARGB4444);
    }

    @Override
    public void update(float deltaTime) {
            gick += deltaTime * 0.01 * 5;
            egick = (int) (gick % 5);

        checkTouch();
    }

    @Override
    public void paint(float deltaTime) {
        FMXGraphics g = game.getGraphics();
        g.drawImage(constan.mainbg, 0, 0);
        g.drawImage(bt1, constan.SCREEN_HEIGHT / 2 - 398, constan.SCREEN_WIDTH / 2 - 173, (int) (256 * egick), 0, 256, 385);
        g.drawImage(bt2, constan.SCREEN_HEIGHT / 2 - 136, constan.SCREEN_WIDTH / 2 - 173, (int) (256 * egick), 0, 256, 385);
        g.drawImage(bt3, constan.SCREEN_HEIGHT / 2 + 126, constan.SCREEN_WIDTH / 2 - 173, (int) (256 * egick), 0, 256, 385);
//        g.drawImage(bet1,constan.SCREEN_HEIGHT/2-398, (int) (constan.SCREEN_WIDTH/2-173+din01));
//        g.drawImage(bet2,constan.SCREEN_HEIGHT/2-136, (int) (constan.SCREEN_WIDTH/2-173+din02));
//        g.drawImage(bet3,constan.SCREEN_HEIGHT/2+126, (int) (constan.SCREEN_WIDTH/2-173+din03));

    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN) {
                //Check Touch by area
                //event  //imagepositionX ///imagepositionY ///imagesizeWidth ///imagesizeHeight
                if (mCurrentScreen == 0) {
                    //1
                    if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 398, constan.SCREEN_WIDTH / 2 - 173, 272, 385)) {
                        mCurrentScreen = 1;
                        constan.price1 = 1;
                        constan.price2 = 5;
                        constan.price3 = 10;
                        constan.price4 = 25;
                        constan.price5 = 50;
                        constan.selectbetroom = 0;
                        constan.maxroom = 90;
                        game.setScreen(new mode1(game));
                    }
                    //2
                    if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 136, constan.SCREEN_WIDTH / 2 - 173, 272, 385)) {
                        mCurrentScreen = 2;
                        constan.price1 = 10;
                        constan.price2 = 25;
                        constan.price3 = 50;
                        constan.price4 = 100;
                        constan.price5 = 500;
                        constan.selectbetroom = 1;
                        constan.maxroom = 900;
                        game.setScreen(new mode1(game));
                    }
                    //3
                    if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + 126, constan.SCREEN_WIDTH / 2 - 173, 272, 385)) {
                        mCurrentScreen = 3;
                        constan.price1 = 25;
                        constan.price2 = 50;
                        constan.price3 = 100;
                        constan.price4 = 500;
                        constan.price5 = 1000;
                        constan.selectbetroom = 2;
                        constan.maxroom = 10000;
                        game.setScreen(new mode1(game));
                    }
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
