/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.raceoffire.framework.implementation;

import android.media.SoundPool;

import com.example.asus.raceoffire.framework.FMXSound;

public class FMXAndroidSound implements FMXSound {
    int soundId;
    SoundPool soundPool;

    public FMXAndroidSound(SoundPool soundPool, int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }

}