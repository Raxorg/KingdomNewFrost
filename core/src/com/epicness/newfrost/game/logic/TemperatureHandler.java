package com.epicness.newfrost.game.logic;

import com.epicness.newfrost.game.stuff.GameStuff;

public class TemperatureHandler {

    private GameStuff stuff;
    // Logic
    private int temperature;

    public void lowerTemperature() {

        temperature--;
    }

    public void increaseTemperature() {
        temperature++;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}