package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_X;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_Y;
import static com.epicness.newfrost.game.enums.BuildingType.COOKHOUSE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.DualSprited;

public class Cookhouse extends Building {

    private final DelayedRemovalArray<DualSprited> meats;

    public Cookhouse(Sprite sprite) {
        super(sprite, COOKHOUSE);
        sprited.setPosition(COOKHOUSE_X, COOKHOUSE_Y);
        sprited.setSize(COOKHOUSE_WIDTH, COOKHOUSE_HEIGHT);

        meats = new DelayedRemovalArray<>();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        for (int i = 0; i < meats.size; i++) {
            meats.get(i).draw(spriteBatch);
        }
    }

    public void setMeatColor(Color color) {
        for (int i = 0; i < meats.size; i++) {
            meats.get(i).setBackgroundColor(color);
        }
    }

    public void setMeatHookColor(Color color) {
        for (int i = 0; i < meats.size; i++) {
            meats.get(i).setForegroundColor(color);
        }
    }

    public int getMeats() {
        return meats.size;
    }

    public void addMeat(DualSprited meat) {
        meats.add(meat);
    }

    public void removeMeats(int quantity) {
        meats.removeRange(meats.size - 1 - quantity, meats.size - 1);
    }

    public void sortMeats() {
        meats.sort((sprited1, sprited2) -> sprited1.getX() > sprited2.getX() ? -1 : 0);
    }
}