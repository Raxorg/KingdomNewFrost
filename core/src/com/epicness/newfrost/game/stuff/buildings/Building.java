package com.epicness.newfrost.game.stuff.buildings;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.enums.BuildingType;

public class Building {

    protected Sprited sprited;
    private final BuildingType type;

    public Building(Sprite sprite, BuildingType type) {
        sprited = new Sprited(sprite);
        this.type = type;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public float getCenterX() {
        return sprited.getX() + sprited.getWidth() / 2f;
    }

    public float getY() {
        return sprited.getY();
    }

    public float getHeight() {
        return sprited.getHeight();
    }

    public BuildingType getType() {
        return type;
    }
}