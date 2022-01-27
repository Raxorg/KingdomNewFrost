package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_X;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_Y;
import static com.epicness.newfrost.game.GameConstants.TECH_TREE_WOOD_ICON_SIZE;
import static com.epicness.newfrost.game.enums.MainMenuState.HIDDEN;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_ACTIONS_PANEL;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_LAW_TREE;
import static com.epicness.newfrost.game.enums.MainMenuState.SHOWING_TECH_TREE;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.ActionPanel;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.tech.TechTree;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.tech.Technology;

public class MainBuildingMenuHandler {

    // Structure
    private SharedLogic sharedLogic;
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
        sharedLogic.getPauseTracker().set(false);
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
        sharedLogic.getPauseTracker().set(true);
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

    private void updateTechTree() {
        TechTree techTree = stuff.getMainBuildingMenu().getTechTree();
        Technology[] technologies = techTree.getTechnologies();
        for (int i = 0; i < technologies.length; i++) {
            Technology technology = technologies[i];
            if (technology.contains(lastX, lastY)) {
                techTree.setTechDescription(technology.getDescription());
                techTree.setTechnologyCost(technology.getCost());
                float y = technology.getY() - TECH_TREE_WOOD_ICON_SIZE;
                techTree.setTechCostPosition(technology.getX(), y);
                return;
            }
        }
        techTree.setTechDescription("");
        techTree.setTechCostPosition(HIDDEN_X, HIDDEN_Y);
    }

    private void updateLawTree() {

    }

    public void touchUp(float x, float y) {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        if (menu.getState() == HIDDEN) {
            return;
        }
        if (!menu.contains(x, y)) {
            hideMenu();
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
                touchUpTechTree(x, y);
                break;
            case SHOWING_LAW_TREE:
                break;
        }
    }

    private void touchUpActionPanel(float x, float y) {
        ActionPanel actionPanel = stuff.getMainBuildingMenu().getActionPanel();
        if (actionPanel.getFoodExpeditionButton().contains(x, y)) {
            logic.getExpeditionHandler().sendExpedition(true);
        } else if (actionPanel.getWoodExpeditionButton().contains(x, y)) {
            logic.getExpeditionHandler().sendExpedition(false);
        }
    }

    private void touchUpTechTree(float x, float y) {
        Technology[] technologies = stuff.getMainBuildingMenu().getTechTree().getTechnologies();
        for (int i = 0; i < technologies.length; i++) {
            Technology technology = technologies[i];
            if (technology.getColor().equals(Color.WHITE)) {
                continue;
            }
            if (technology.contains(x, y)) {
                if (logic.getWarehouseHandler().getLogs() >= technology.getCost()) {
                    logic.getWarehouseHandler().removeLogs(technology.getCost());
                    technology.setColor(Color.WHITE);
                }
            }
        }
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