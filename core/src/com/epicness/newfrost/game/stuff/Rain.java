package com.epicness.newfrost.game.stuff;

import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_75;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Sprited;

public class Rain {

    private final Sprited[] drops;

    public Rain(Sprite rainDrop) {
        drops = new Sprited[250];
        for (int i = 0; i < drops.length; i++) {
            drops[i] = new Sprited(rainDrop);
            Sprited drop = drops[i];
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

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < drops.length; i++) {
            drops[i].draw(spriteBatch);
        }
    }

    public Sprited[] getDrops() {
        return drops;
    }
}