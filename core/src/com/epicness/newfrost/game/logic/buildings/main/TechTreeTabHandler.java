package com.epicness.newfrost.game.logic.buildings.main;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_X;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_Y;
import static com.epicness.newfrost.game.GameConstants.TECH_TREE_WOOD_ICON_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.tech.TechTree;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.tech.Technology;

public class TechTreeTabHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void show() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setTechTreePosition(MAIN_MENU_X, MAIN_MENU_Y);
        menu.setTechTabColor(Color.BLUE.cpy().lerp(Color.BLACK, 0.3f));
    }

    public void hide() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setTechTreePosition(HIDDEN_X, HIDDEN_Y);
        menu.setTechTabColor(Color.BLUE.cpy().lerp(Color.BLACK, 0.8f));
    }

    public void update(float lastX, float lastY) {
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

    public void touchUp(float x, float y) {
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
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}