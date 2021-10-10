package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.newfrost.game.stuff.GameStuff;

public class EventHandler {

    private GameStuff stuff;

    public void hideEventView() {
        stuff.getEventView().setColor(Color.CLEAR);
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}