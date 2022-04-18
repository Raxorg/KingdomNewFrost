package com.epicness.newfrost.game.stuff.buildings;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.enums.BuildingType;

public abstract class Building {

    private final BuildingType type;
    protected Sprited sprited;

    public Building(Sprite sprite, BuildingType type) {
        this.type = type;
        sprited = new Sprited(sprite);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public float getX() {
        return sprited.getX();
    }

    public float getCenterX() {
        return sprited.getCenterX();
    }

    public float getY() {
        return sprited.getY();
    }

    public void setPosition(float x, float y) {
        sprited.setPosition(x, y);
    }

    public float getWidth() {
        return sprited.getWidth();
    }

    public float getHeight() {
        return sprited.getHeight();
    }

    public void flipX() {
        sprited.setFlip(true, false);
    }

    public void setColor(Color color) {
        sprited.setColor(color);
    }

    public BuildingType getType() {
        return type;
    }
}