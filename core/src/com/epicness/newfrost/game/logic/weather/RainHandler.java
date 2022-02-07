package com.epicness.newfrost.game.logic.weather;

import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_75;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.Rain;

public class RainHandler {

    // Structure
    private GameStuff stuff;

    public void init() {
        Rain rain = stuff.getRain();
        for (int i = 0; i < rain.getDrops().length; i++) {
            Sprited drop = rain.getDrops()[i];
            if (MathUtils.randomBoolean(0.75f)) {
                drop.setSize(3f, 15f);
            } else {
                drop.setSize(2f, 35f);
            }
            drop.translateX(MathUtils.random(CAMERA_WIDTH));
            drop.translateY(MathUtils.random(CAMERA_HEIGHT));
            drop.setColor(BLACK_CLEAR_75.cpy().lerp(Color.ROYAL, 0.4f));
        }
    }

    public void update(float delta) {
        Sprited[] drops = stuff.getRain().getDrops();
        for (int i = 0; i < drops.length; i++) {
            Sprited drop = drops[i];
            drop.translateX(-100f * delta);
            drop.translateY(-1000f * delta);
            if (drop.getX() <= 0f) {
                drop.setX(CAMERA_WIDTH + MathUtils.random(50f));
            }
            if (drop.getY() + drop.getHeight() <= 0f) {
                drop.setY(CAMERA_HEIGHT + MathUtils.random(50f));
            }
        }
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}