package com.epicness.newfrost.game.logic.buildings.main;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_X;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_Y;

import com.badlogic.gdx.graphics.Color;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.ActionPanel;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;

public class ActionTabHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void show() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setActionPanelPosition(MAIN_MENU_X, MAIN_MENU_Y);
        menu.setActionsTabColor(Color.GREEN.cpy().lerp(Color.BLACK, 0.3f));
    }

    public void hide() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setActionPanelPosition(HIDDEN_X, HIDDEN_Y);
        menu.setActionsTabColor(Color.GREEN.cpy().lerp(Color.BLACK, 0.8f));
    }

    public void update(float lastX, float lastY) {
        ActionPanel actionPanel = stuff.getMainBuildingMenu().getActionPanel();
        if (actionPanel.getFoodExpeditionButton().contains(lastX, lastY)) {
            actionPanel.getFoodExpeditionButton().setColor(new Color(0.5f, 0.2f, 0.2f, 1f));
        } else {
            actionPanel.getFoodExpeditionButton().setColor(Color.WHITE);
        }
        if (actionPanel.getWoodExpeditionButton().contains(lastX, lastY)) {
            actionPanel.getWoodExpeditionButton().setColor(new Color(0.5f, 0.3f, 0.2f, 1f));
        } else {
            actionPanel.getWoodExpeditionButton().setColor(Color.WHITE);
        }
    }

    public void touchUp(float x, float y) {
        ActionPanel actionPanel = stuff.getMainBuildingMenu().getActionPanel();
        if (actionPanel.getFoodExpeditionButton().contains(x, y)) {
            logic.getExpeditionHandler().sendExpedition(true);
        } else if (actionPanel.getWoodExpeditionButton().contains(x, y)) {
            logic.getExpeditionHandler().sendExpedition(false);
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