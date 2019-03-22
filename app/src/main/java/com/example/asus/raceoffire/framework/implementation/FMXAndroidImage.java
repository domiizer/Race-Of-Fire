/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.raceoffire.framework.implementation;

import android.graphics.Bitmap;

import com.example.asus.raceoffire.framework.FMXImage;
import com.example.asus.raceoffire.framework.FMXGraphics.ImageFormat;

public class FMXAndroidImage implements FMXImage {
    Bitmap bitmap;
    ImageFormat format;
    
    public FMXAndroidImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }      
}
