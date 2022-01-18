package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_X;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_Y;
import static com.epicness.newfrost.game.enums.BuildingType.COOKHOUSE;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Cookhouse extends Building {
    public Cookhouse(Sprite sprite) {
        super(sprite, COOKHOUSE);
        sprited.setPosition(COOKHOUSE_X, COOKHOUSE_Y);
        sprited.setSize(COOKHOUSE_WIDTH, COOKHOUSE_HEIGHT);
    }
}