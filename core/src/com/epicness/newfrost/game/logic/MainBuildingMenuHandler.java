package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.ActionPanel;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_X;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_Y;
import static com.epicness.newfrost.game.enums.MainMenuState.HIDDEN;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_ACTIONS_PANEL;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_LAW_TREE;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_TECH_TREE;

public class MainBuildingMenuHandler {

    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float lastX, lastY;

    public void hideMenu() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setPosition(HIDDEN_X, HIDDEN_Y);
        menu.setActionPanelPosition(HIDDEN_X, HIDDEN_Y);
        menu.setTechTreePosition(HIDDEN_X, HIDDEN_Y);
        menu.setLawTreePosition(HIDDEN_X, HIDDEN_Y);
    }

    public void showMenu() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setPosition(MAIN_MENU_X, MAIN_MENU_Y);
        switch (menu.getState()) {
            case SHOWING_ACTIONS_PANEL:
                menu.setActionPanelPosition(MAIN_MENU_X, MAIN_MENU_Y);
                menu.setTechTreePosition(HIDDEN_X, HIDDEN_Y);
                menu.setLawTreePosition(HIDDEN_X, HIDDEN_Y);
                menu.setActionsTabColor(Color.GREEN.cpy().lerp(Color.BLACK, 0.3f));
                menu.setTechTabColor(Color.BLUE.cpy().lerp(Color.BLACK, 0.8f));
                menu.setLawTabColor(Color.RED.cpy().lerp(Color.BLACK, 0.8f));
                break;
            case SHOWING_TECH_TREE:
                menu.setActionPanelPosition(HIDDEN_X, HIDDEN_Y);
                menu.setTechTreePosition(MAIN_MENU_X, MAIN_MENU_Y);
                menu.setLawTreePosition(HIDDEN_X, HIDDEN_Y);
                menu.setActionsTabColor(Color.GREEN.cpy().lerp(Color.BLACK, 0.8f));
                menu.setTechTabColor(Color.BLUE.cpy().lerp(Color.BLACK, 0.3f));
                menu.setLawTabColor(Color.RED.cpy().lerp(Color.BLACK, 0.8f));
                break;
            case SHOWING_LAW_TREE:
                menu.setActionPanelPosition(HIDDEN_X, HIDDEN_Y);
                menu.setTechTreePosition(HIDDEN_X, HIDDEN_Y);
                menu.setLawTreePosition(MAIN_MENU_X, MAIN_MENU_Y);
                menu.setActionsTabColor(Color.GREEN.cpy().lerp(Color.BLACK, 0.8f));
                menu.setTechTabColor(Color.BLUE.cpy().lerp(Color.BLACK, 0.8f));
                menu.setLawTabColor(Color.RED.cpy().lerp(Color.BLACK, 0.3f));
                break;
        }
    }

    public void mouseMoved(float x, float y) {
        lastX = x;
        lastY = y;
    }

    public void update() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        switch (menu.getState()) {
            case SHOWING_ACTIONS_PANEL:
                updateActionPanel();
                break;
            case SHOWING_TECH_TREE:
                updateTechTree();
                break;
            case SHOWING_LAW_TREE:
                updateLawTree();
                break;
        }
    }

    private void updateActionPanel() {
        ActionPanel actionPanel = stuff.getMainBuildingMenu().getActionPanel();
        if (actionPanel.getExpeditionButton().contains(lastX, lastY)) {
            actionPanel.getExpeditionButton().setColor(Color.GREEN);
        } else {
            actionPanel.getExpeditionButton().setColor(Color.WHITE);
        }
    }

    private void updateTechTree() {

    }

    private void updateLawTree() {

    }

    public void touchUp(float x, float y) {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        if (menu.getState() == HIDDEN) {
            return;
        }
        if (menu.getActionsTab().contains(x, y)) {
            menu.setState(SHOWING_ACTIONS_PANEL);
            showMenu();
        }
        if (menu.getTechTab().contains(x, y)) {
            menu.setState(SHOWING_TECH_TREE);
            showMenu();
        }
        if (menu.getLawTab().contains(x, y)) {
            menu.setState(SHOWING_LAW_TREE);
            showMenu();
        }
        switch (menu.getState()) {
            case SHOWING_ACTIONS_PANEL:
                touchUpActionPanel(x, y);
                break;
            case SHOWING_TECH_TREE:
                break;
            case SHOWING_LAW_TREE:
                break;
        }
    }

    private void touchUpActionPanel(float x, float y) {
        ActionPanel actionPanel = stuff.getMainBuildingMenu().getActionPanel();
        if (actionPanel.getExpeditionButton().contains(x, y)) {
            logic.getExpeditionHandler().sendExpedition();
        }
    }

    public void touchDown(float x, float y) {

    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}