package com.epicness.newfrost.game.logic.buildings.main;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_X;
import static com.epicness.newfrost.game.GameConstants.MAIN_MENU_Y;

import com.badlogic.gdx.graphics.Color;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;

public class LawTreeTabHandler {

    // Structure
    private GameStuff stuff;

    public void show() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setLawTreePosition(MAIN_MENU_X, MAIN_MENU_Y);
        menu.setLawTabColor(Color.RED.cpy().lerp(Color.BLACK, 0.3f));
    }

    public void hide() {
        MainBuildingMenu menu = stuff.getMainBuildingMenu();
        menu.setLawTreePosition(HIDDEN_X, HIDDEN_Y);
        menu.setLawTabColor(Color.RED.cpy().lerp(Color.BLACK, 0.8f));
    }

    public void update(float lastX, float lastY) {

    }

    public void touchUp(float x, float y) {

    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}