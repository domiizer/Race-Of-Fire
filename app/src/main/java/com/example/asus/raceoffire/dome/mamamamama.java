package com.example.asus.raceoffire.dome;

import com.example.asus.raceoffire.framework.FMXGraphics;

public class mamamamama {
    private int x,y,srcX,srcY,width,height,num,lege = 18,runframeH;
    private double run;

    public mamamamama(int num){
//this.x=x;
//this.y=y;
//this.srcX=srcX;
//this.srcY=srcY;
//this.width=width;
//this.height=height;
this.num=num;

    }

    public void tick(float deltaTime) {
        run += deltaTime * 0.01 * 10;
        runframeH = (int) (run % 4);// sprite Horse

    }

    public void paint(FMXGraphics g) {
        g.drawImage(constan.test[num], (int) (x - constan.runCamera), constan.SCREEN_WIDTH - 104 - lege * (9-num), 138 * runframeH, 0, 138, 104);

    }

    }
