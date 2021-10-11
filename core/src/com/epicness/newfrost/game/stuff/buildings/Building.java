package com.epicness.newfrost.game.stuff.buildings;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.enums.BuildingType;

public abstract class Building {

    protected Sprited sprited;
    private final BuildingType type;

    public Building(Sprite sprite, BuildingType type) {
        sprited = new Sprited(sprite);
        this.type = type;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprited.setPosition(x, y);
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

    public void flipX() {
        sprited.setFlip(true, false);
    }

    public BuildingType getType() {
        return type;
    }
}