package com.epicness.newfrost.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Sprited;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;

public class Rain {

    private final Sprited[] drops;

    public Rain(Sprite rainDrop) {
        drops = new Sprited[250];
        for (int i = 0; i < drops.length; i++) {
            drops[i] = new Sprited(rainDrop);
            Sprited drop = drops[i];
            drop.setSize(4f);
            drop.translateX(MathUtils.random(CAMERA_WIDTH));
            drop.translateY(MathUtils.random(CAMERA_HEIGHT));
            drop.setColor(TRANSPARENT.cpy().lerp(Color.BLUE,0.5f));
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