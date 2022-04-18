package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.BASE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.BASE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.BASE_X;
import static com.epicness.newfrost.game.GameConstants.BASE_Y;
import static com.epicness.newfrost.game.enums.BuildingType.BASE;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.fundamentals.stuff.Sprited;

public class Base extends Building {

    private final DelayedRemovalArray<Sprited> logs;
    private final DelayedRemovalArray<DualSprited> meats;
    public int logPiles;

    public Base(Sprite mainBuildingSprite) {
        super(mainBuildingSprite, BASE);
        sprited.setPosition(BASE_X, BASE_Y);
        sprited.setSize(BASE_WIDTH, BASE_HEIGHT);

        logs = new DelayedRemovalArray<>();
        meats = new DelayedRemovalArray<>();
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
        logPiles = logs.size / 10;
    }

    public int getLogPiles() {
        return logPiles;
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
}