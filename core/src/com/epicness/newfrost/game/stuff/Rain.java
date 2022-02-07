package com.epicness.newfrost.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;

public class Rain {

    private final Sprited[] drops;

    public Rain(Sprite rainDrop) {
        drops = new Sprited[250];
        for (int i = 0; i < drops.length; i++) {
            drops[i] = new Sprited(rainDrop);
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