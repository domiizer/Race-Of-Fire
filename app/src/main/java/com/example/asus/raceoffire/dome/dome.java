package com.example.asus.raceoffire.dome;

import android.view.MotionEvent;
import android.view.View;

import com.example.asus.raceoffire.framework.FMXInput;
import com.example.asus.raceoffire.framework.FMXScreen;
import com.example.asus.raceoffire.framework.implementation.FMXAndroidGame;

public class dome extends FMXAndroidGame {
    @Override
    public FMXScreen getInitScreen() {
        return new loading(this);
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        return ev.getPointerCount() == 1 && super.dispatchTouchEvent(ev);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }


    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public static boolean inBounds(FMXInput.TouchEvent event, int x, int y, int width,
                                   int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1) {
            return true;
        } else {
            return false;
        }
    }
}
