package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_X;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_Y;
import static com.epicness.newfrost.game.enums.BuildingType.WAREHOUSE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;

public class Warehouse extends Building {

    protected Sprited foreground;
    private final DelayedRemovalArray<Sprited> logs;
    int logPiles;

    public Warehouse(Sprite backgroundSprite, Sprite foregroundSprite) {
        super(backgroundSprite, WAREHOUSE);
        sprited.setPosition(WAREHOUSE_X, WAREHOUSE_Y);
        sprited.setSize(WAREHOUSE_WIDTH, WAREHOUSE_HEIGHT);

        foreground = new Sprited(foregroundSprite);
        foreground.setPosition(WAREHOUSE_X, WAREHOUSE_Y);
        foreground.setSize(WAREHOUSE_WIDTH, WAREHOUSE_HEIGHT);

        logs = new DelayedRemovalArray<>();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        for (int i = 0; i < logs.size; i++) {
            logs.get(i).draw(spriteBatch);
        }
        foreground.draw(spriteBatch);
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
        foreground.setColor(color);
    }

    public void setLogColor(Color color) {
        for (int i = 0; i < logs.size; i++) {
            logs.get(i).setColor(color);
        }
    }

    public int getLogs() {
        return logs.size;
    }

    public void addLog(Sprited log) {
        logs.add(log);
        logPiles = logs.size / 10;
    }

    public void removeLogs(int quantity) {
        logs.removeRange(logs.size - 1 - quantity, logs.size - 1);
    }

    public int getLogPiles() {
        return logPiles;
    }
}