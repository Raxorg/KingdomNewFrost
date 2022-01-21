package com.epicness.newfrost.game.logic.weather;

import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.stuff.GameStuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class RainHandler {

    private GameStuff stuff;

    public void update(float delta) {
        Sprited[] drops = stuff.getRain().getDrops();
        for (int i = 0; i < drops.length; i++) {
            Sprited drop = drops[i];
            drop.translateX(-100f * delta);
            drop.translateY(-1000f * delta);
            if (drop.getX() <= 0f) {
                drop.setX(CAMERA_WIDTH + drop.getX());
            }
            if (drop.getY() <= 0f) {
                drop.setY(CAMERA_HEIGHT + drop.getY());
            }
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}