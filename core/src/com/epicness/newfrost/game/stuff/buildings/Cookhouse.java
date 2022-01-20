package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_X;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_Y;
import static com.epicness.newfrost.game.enums.BuildingType.COOKHOUSE;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.DualSprited;

public class Cookhouse extends Building {

    private final DelayedRemovalArray<DualSprited> cookhouseMeats;

    public Cookhouse(Sprite sprite) {
        super(sprite, COOKHOUSE);
        sprited.setPosition(COOKHOUSE_X, COOKHOUSE_Y);
        sprited.setSize(COOKHOUSE_WIDTH, COOKHOUSE_HEIGHT);

        cookhouseMeats = new DelayedRemovalArray<>();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        for (int i = 0; i < cookhouseMeats.size; i++) {
            cookhouseMeats.get(i).draw(spriteBatch);
        }
    }

    public DelayedRemovalArray<DualSprited> getCookhouseMeats() {
        return cookhouseMeats;
    }
}