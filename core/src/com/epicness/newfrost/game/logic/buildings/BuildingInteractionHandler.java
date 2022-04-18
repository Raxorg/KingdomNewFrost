package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Explorarium;
import com.epicness.newfrost.game.stuff.buildings.Tent;
import com.epicness.newfrost.game.stuff.people.Player;

public class BuildingInteractionHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private Building selectedBuilding;

    public void hideActionIcon() {
        stuff.getActionIcon().setPosition(HIDDEN_X, HIDDEN_Y);
    }

    public void update() {
        Player player = stuff.getPlayer();
        DelayedRemovalArray<Building> buildings = stuff.getBuildings();
        for (int i = 0; i < buildings.size; i++) {
            Building building = buildings.get(i);
            if (building instanceof Tent && ((Tent) building).isUpgraded()) {
                continue;
            }
            float distance = Math.abs(building.getCenterX() - player.getCenterX());
            if (distance <= building.getWidth() / 2f) {
                float x = building.getCenterX() - ACTION_ICON_WIDTH / 2f;
                float y = building.getY() + building.getHeight() * 0.85f;
                stuff.getActionIcon().setPosition(x, y);
                selectedBuilding = building;
                return;
            }
        }
        logic.getActionHandler().hideActionIcon();
        hidePanel();
        selectedBuilding = null;
    }

    private void hidePanel() {
        if (selectedBuilding == null) {
            return;
        }
        switch (selectedBuilding.getType()) {
            case BASE:
                logic.getMainBuildingMenuHandler().hideMenu();
                break;
            case MEDICAL_POST:
                break;
        }
        logic.getCitizenHighlightHandler().setEnabled(true);
    }

    public void sPress() {
        if (selectedBuilding == null) {
            return;
        }
        if (logic.getTutorialHandler().isShowingTip()) {
            return;
        }
        switch (selectedBuilding.getType()) {
            case BASE:
                logic.getMainBuildingMenuHandler().showMenu();
                logic.getCitizenHighlightHandler().setEnabled(false);
                break;
            case TENT:
                logic.getTentHandler().interact((Tent) selectedBuilding);
                break;
            case EXPLORARIUM:
                logic.getExplorariumHandler().interact((Explorarium) selectedBuilding);
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