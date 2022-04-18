package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_WIDTH;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_X;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_Y;
import static com.epicness.newfrost.game.enums.BuildingType.EXPLORARIUM;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;

public class Explorarium extends Building {

    private final DelayedRemovalArray<Sprited> backpacks;

    public Explorarium(Sprite sprite) {
        super(sprite, EXPLORARIUM);
        sprited.setPosition(EXPLORARIUM_X, EXPLORARIUM_Y);
        sprited.setSize(EXPLORARIUM_WIDTH, EXPLORARIUM_HEIGHT);

        backpacks = new DelayedRemovalArray<>();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        for (int i = 0; i < backpacks.size; i++) {
            backpacks.get(i).draw(spriteBatch);
        }
    }

    public void setBackpackColor(Color color) {
        for (int i = 0; i < backpacks.size; i++) {
            backpacks.get(i).setColor(color);
        }
    }

    public int getBackpacks() {
        return backpacks.size;
    }

    public void addBackpack(Sprited backpack) {
        backpacks.add(backpack);
    }

    public void sortBackpacks() {
        backpacks.sort((sprited1, sprited2) -> sprited1.getX() > sprited2.getX() ? -1 : 0);
    }

    public void removeBackpacks(int quantity) {
        backpacks.removeRange(backpacks.size - 1 - quantity, backpacks.size - 1);
    }

    public float getStartingBackpackX() {
        return getX() + getWidth() * 0.4f;
    }

    public float getBackpackY() {
        return getY() + getHeight() * 0.08f;
    }
}