package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_X;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_Y;
import static com.epicness.newfrost.game.enums.BuildingType.WAREHOUSE;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;

public class Warehouse extends Building {

    protected Sprited foreground;
    private final DelayedRemovalArray<Sprited> warehouseLogs;

    public Warehouse(Sprite backgroundSprite, Sprite foregroundSprite) {
        super(backgroundSprite, WAREHOUSE);
        sprited.setPosition(WAREHOUSE_X, WAREHOUSE_Y);
        sprited.setSize(WAREHOUSE_WIDTH, WAREHOUSE_HEIGHT);

        foreground = new Sprited(foregroundSprite);
        foreground.setPosition(WAREHOUSE_X, WAREHOUSE_Y);
        foreground.setSize(WAREHOUSE_WIDTH, WAREHOUSE_HEIGHT);

        warehouseLogs = new DelayedRemovalArray<>();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        for (int i = 0; i < warehouseLogs.size; i++) {
            warehouseLogs.get(i).draw(spriteBatch);
        }
        foreground.draw(spriteBatch);
    }

    public DelayedRemovalArray<Sprited> getWarehouseLogs() {
        return warehouseLogs;
    }
}