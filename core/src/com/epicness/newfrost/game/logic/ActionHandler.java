package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.enums.BuildingType;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.people.Player;

import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_WIDTH;

public class ActionHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private BuildingType buildingType;

    public void hideActionIcon() {
        stuff.getActionIcon().setPosition(HIDDEN_X, HIDDEN_Y);
    }

    public void update() {
        Player player = stuff.getPlayer();
        DelayedRemovalArray<Building> buildings = stuff.getBuildings();
        for (int i = 0; i < buildings.size; i++) {
            Building building = buildings.get(i);
            float distance = Math.abs(building.getCenterX() - player.getCenterX());
            if (distance <= MAIN_BUILDING_WIDTH / 2f) {
                float x = building.getCenterX() - ACTION_ICON_WIDTH / 2f;
                float y = building.getY() + building.getHeight() * 0.75f;
                stuff.getActionIcon().setPosition(x, y);
                buildingType = building.getType();
                return;
            }
        }
        logic.getActionHandler().hideActionIcon();
        hidePanel();
        buildingType = null;
    }

    private void hidePanel() {
        if (buildingType == null) {
            return;
        }
        switch (buildingType) {
            case MAIN_BUILDING:
                logic.getMainBuildingMenuHandler().hideMenu();
                break;
            case MEDICAL_POST:
                break;
        }
        logic.getHighlightHandler().setEnabled(true);
    }

    public void sPress() {
        if (buildingType == null) {
            return;
        }
        switch (buildingType) {
            case MAIN_BUILDING:
                logic.getMainBuildingMenuHandler().showMenu();
                logic.getHighlightHandler().setEnabled(false);
                break;
            case MEDICAL_POST:
                break;
        }
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}