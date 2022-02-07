package com.epicness.newfrost.game.logic.weather;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.stuff.GameStuff;

public class RainHandler {

    private GameStuff stuff;

    public void update(float delta) {
        Sprited[] drops = stuff.getRain().getDrops();
        for (int i = 0; i < drops.length; i++) {
            Sprited drop = drops[i];
            drop.translateX(-100f * delta);
            drop.translateY(-1000f * delta);
            if (drop.getX() <= 0f) {
                drop.setX(CAMERA_WIDTH);
            }
            if (drop.getY() + drop.getHeight() <= 0f) {
                drop.setY(CAMERA_HEIGHT + MathUtils.random(50f));
            }
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}