package com.epicness.newfrost.game.stuff.mainbuildingmenu.tech;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Buttonable;
import com.epicness.fundamentals.stuff.Sprited;

import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_SIZE;

public class Technology implements Buttonable {

    private final Sprited sprited;
    private final String description;
    private final int cost;

    public Technology(Sprite technologySprite, String description, int cost) {
        sprited = new Sprited(technologySprite);
        sprited.setSize(TECHNOLOGY_SIZE);
        this.description = description;
        this.cost = cost;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return sprited.contains(x, y);
    }

    public float getX() {
        return sprited.getX();
    }

    public float getY() {
        return sprited.getY();
    }

    public void setPosition(float x, float y) {
        sprited.setPosition(x, y);
    }

    public Color getColor() {
        return sprited.getColor();
    }

    public void setColor(Color color) {
        sprited.setColor(color);
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }
}