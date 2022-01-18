package com.epicness.newfrost.game.stuff.buildings;

import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_WIDTH;
import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_X;
import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_Y;
import static com.epicness.newfrost.game.enums.BuildingType.MAIN_BUILDING;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.Sprited;

public class MainBuilding extends Building {

    public MainBuilding(Sprite mainBuildingSprite) {
        super(mainBuildingSprite, MAIN_BUILDING);
        sprited.setPosition(MAIN_BUILDING_X, MAIN_BUILDING_Y);
        sprited.setSize(MAIN_BUILDING_WIDTH, MAIN_BUILDING_HEIGHT);
    }
}