package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_WIDTH;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_X;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_Y;
import static com.epicness.newfrost.game.enums.BuildingType.EXPLORARIUM;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;

public class Explorarium extends Building {

    private final DelayedRemovalArray<Sprited> explorariumBackpacks;

    public Explorarium(Sprite sprite) {
        super(sprite, EXPLORARIUM);
        sprited.setPosition(EXPLORARIUM_X, EXPLORARIUM_Y);
        sprited.setSize(EXPLORARIUM_WIDTH, EXPLORARIUM_HEIGHT);

        explorariumBackpacks = new DelayedRemovalArray<>();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        for (int i = 0; i < explorariumBackpacks.size; i++) {
            explorariumBackpacks.get(i).draw(spriteBatch);
        }
    }

    public DelayedRemovalArray<Sprited> getExplorariumBackpacks() {
        return explorariumBackpacks;
    }
}