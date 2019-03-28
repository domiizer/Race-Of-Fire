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


public class Select extends FMXScreen {
    private FMXImage background, bet1, bet2, bet3, bt1, bt2, bt3;
    private int mCurrentScreen = 0, egick,showset=0,setnum=0,isClick=0;
    private double din01, din02, din03, gick,alphanox;
    private boolean canT=true;
    Paint paint = new Paint();

    public Select(FMXGame game) {
        super(game);
        FMXGraphics g = game.getGraphics();
        bet1 = g.newImage("mode1.png", FMXGraphics.ImageFormat.ARGB4444);
        bet2 = g.newImage("mode2.png", FMXGraphics.ImageFormat.ARGB4444);
        bet3 = g.newImage("mode3.png", FMXGraphics.ImageFormat.ARGB4444);
        bt1 = g.newImage("modebt1.png", FMXGraphics.ImageFormat.ARGB4444);
        bt2 = g.newImage("modebt2.png", FMXGraphics.ImageFormat.ARGB4444);
        bt3 = g.newImage("modebt3.png", FMXGraphics.ImageFormat.ARGB4444);
        paint.setColor(Color.WHITE);
        paint.setTextSize(10);
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
        g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 60, 5,48,0,48,48);
        g.drawImage(constan.lal, 10, 10);
        g.drawImage(constan.lal, 170, 10);
        g.drawString("" + constan.user, 70, 30, paint);
        g.drawString("Credit : " + constan.credit, 180, 30, paint);
        g.drawImage(constan.ibg, 0, 0,0,0,48,48);

        if (showset==1) {
            g.drawRectBG(0,0,constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,Color.BLACK,120);
            g.drawImage(constan.ibg, constan.SCREEN_HEIGHT - 60, 5,48,0,48,48);
//            g.drawImage(constan.ibg, 0, 0,0,0,48,48);
            g.drawImage(constan.setbg, constan.SCREEN_HEIGHT - 218, +58);
            g.drawImage(constan.setbg, constan.SCREEN_HEIGHT - 218, +108);
            if (setnum==1){
                g.drawImage(constan.shpayout,0,0);
            }
            else if (setnum==2){

            }
        }
        if (isClick==1)
        swScreen(g,deltaTime);
    }

    private void swScreen(FMXGraphics g,float deltaTime) {
        canT=false;
        alphanox+=deltaTime*0.01*500;
        g.drawRectBG(0,0,constan.SCREEN_HEIGHT,constan.SCREEN_WIDTH,Color.BLACK, (int) alphanox);
        Log.i("ssdfasdf", "swScreen: "+alphanox);
        if (alphanox>=250){
            game.setScreen(new mode1(game));

        }
    }

    private void checkTouch() {
        List<FMXInput.TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            FMXInput.TouchEvent event = touchEvents.get(i);
            if (event.type == FMXInput.TouchEvent.TOUCH_DOWN&&canT==true) {
                //Check Touch by area
                //event  //imagepositionX ///imagepositionY ///imagesizeWidth ///imagesizeHeight
                    //1
                    if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 398, constan.SCREEN_WIDTH / 2 - 173, 272, 385)&&showset==0) {
                        constan.price1 = 1;
                        constan.price2 = 5;
                        constan.price3 = 10;
                        constan.price4 = 25;
                        constan.price5 = 50;
                        constan.selectbetroom = 0;
                        constan.maxroom = 90;
                        isClick=1;
//                        if (mCurrentScreen==1)
//                        game.setScreen(new mode1(game));
                    }
                    //2
                    if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 - 136, constan.SCREEN_WIDTH / 2 - 173, 272, 385)&&showset==0) {
                        constan.price1 = 10;
                        constan.price2 = 25;
                        constan.price3 = 50;
                        constan.price4 = 100;
                        constan.price5 = 500;
                        constan.selectbetroom = 1;
                        constan.maxroom = 900;
                        isClick=1;
//                        if (mCurrentScreen==1)
//                        game.setScreen(new mode1(game));
                    }
                    //3
                    if (dome.inBounds(event, constan.SCREEN_HEIGHT / 2 + 126, constan.SCREEN_WIDTH / 2 - 173, 272, 385)&&showset==0) {
                        constan.price1 = 25;
                        constan.price2 = 50;
                        constan.price3 = 100;
                        constan.price4 = 500;
                        constan.price5 = 1000;
                        constan.selectbetroom = 2;
                        constan.maxroom = 10000;
                        isClick=1;
//                        if (mCurrentScreen==1)
//                        game.setScreen(new mode1(game));
                    }
                    if (dome.inBounds(event,constan.SCREEN_HEIGHT -20, +10, 48,48)&&showset==0){
                        Log.i("inininin", "checkTouch: ");
                        showset=1;
                        setnum=0;
                    }
                    else if (dome.inBounds(event,constan.SCREEN_HEIGHT -20, +10, 48,48)&&showset==1){
                        Log.i("22222", "checkTouch: ");
                        showset=0;
                        setnum=0;
                    }
                    if (dome.inBounds(event,constan.SCREEN_HEIGHT - 218, 58, 218,58)&&showset==1&&setnum==0){
                        setnum=1;
                    }
                    else if (dome.inBounds(event,constan.SCREEN_HEIGHT - 218, 58, 218,58)&&showset==1&&setnum==1){
                        setnum=0;
                    }
//                    if (dome.inBounds(event,constan.SCREEN_HEIGHT - 218, 108, 218,108)&&showset==1&&setnum==0){
//                        setnum=2;
//                    }
//                    else if (dome.inBounds(event,constan.SCREEN_HEIGHT - 218, 108, 218,108)&&showset==2){
//                        setnum=0;
//                    }


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
