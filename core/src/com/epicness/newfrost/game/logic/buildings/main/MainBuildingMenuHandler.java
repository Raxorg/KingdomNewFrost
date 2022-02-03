package com.epicness.newfrost.game.logic.buildings.main;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_X;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_Y;
import static com.epicness.newfrost.game.enums.MainMenuState.HIDDEN;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_ACTIONS_PANEL;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_LAW_TREE;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_TECH_TREE;

import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.newfrost.game.enums.MainMenuState;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;

public class MainBuildingMenuHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private MainMenuState state;
    private float lastX, lastY;

    public void init() {
        state = SHOWING_ACTIONS_PANEL;
        hideMenu();
    }

    public void hideMenu() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setPosition(HIDDEN_X, HIDDEN_Y);
        menu.setActionPanelPosition(HIDDEN_X, HIDDEN_Y);
        menu.setTechTreePosition(HIDDEN_X, HIDDEN_Y);
        menu.setLawTreePosition(HIDDEN_X, HIDDEN_Y);
        sharedLogic.getPauseTracker().set(false);
        logic.getCitizenHighlightHandler().setEnabled(true);
    }

    public void showMenu() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setPosition(MAIN_MENU_X, MAIN_MENU_Y);
        logic.getActionTabHandler().hide();
        logic.getLawTreeTabHandler().hide();
        logic.getTechTreeTabHandler().hide();
        switch (state) {
            case SHOWING_ACTIONS_PANEL:
                logic.getActionTabHandler().show();
                break;
            case SHOWING_TECH_TREE:
                logic.getTechTreeTabHandler().show();
                break;
            case SHOWING_LAW_TREE:
                logic.getLawTreeTabHandler().show();
                break;
        }
        sharedLogic.getPauseTracker().set(true);
    }

    public void mouseMoved(float x, float y) {
        lastX = x;
        lastY = y;
    }

    public void update() {
        switch (state) {
            case SHOWING_ACTIONS_PANEL:
                logic.getActionTabHandler().update(lastX, lastY);
                break;
            case SHOWING_TECH_TREE:
                logic.getTechTreeTabHandler().update(lastX, lastY);
                break;
            case SHOWING_LAW_TREE:
                logic.getLawTreeTabHandler().update(lastX, lastY);
                break;
        }
    }

    public void touchUp(float x, float y) {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        if (state == HIDDEN) {
            return;
        }
        if (!menu.contains(x, y)) {
            hideMenu();
            return;
        }
        if (touchUpOnTab(x, y)) {
            return;
        }
        switch (state) {
            case SHOWING_ACTIONS_PANEL:
                logic.getActionTabHandler().touchUp(x, y);
                break;
            case SHOWING_TECH_TREE:
                logic.getTechTreeTabHandler().touchUp(x, y);
                break;
            case SHOWING_LAW_TREE:
                logic.getLawTreeTabHandler().touchUp(x, y);
                break;
        }
    }

    private boolean touchUpOnTab(float x, float y) {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        if (menu.getActionsTab().contains(x, y)) {
            state = SHOWING_ACTIONS_PANEL;
            showMenu();
            return true;
        }
        if (menu.getTechTab().contains(x, y)) {
            state = SHOWING_TECH_TREE;
            showMenu();
            return true;
        }
        if (menu.getLawTab().contains(x, y)) {
            state = SHOWING_LAW_TREE;
            showMenu();
            return true;
        }
        return false;
    }

    public void updateLastCursorPosition(float cameraOffset) {
        lastX += cameraOffset;
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}