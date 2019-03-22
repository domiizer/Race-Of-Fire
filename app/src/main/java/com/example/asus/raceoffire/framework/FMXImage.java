/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.raceoffire.framework;

import com.example.asus.raceoffire.framework.FMXGraphics.ImageFormat;

public interface FMXImage {
    public int getWidth();
    public int getHeight();
    public ImageFormat getFormat();
    public void dispose();
}