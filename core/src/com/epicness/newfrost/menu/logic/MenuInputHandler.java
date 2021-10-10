package com.epicness.newfrost.menu.logic;

import com.epicness.fundamentals.input.InputHandler;
import com.epicness.newfrost.menu.MenuStuff;

public class MenuInputHandler extends InputHandler {

    @Override
    public void touchUp(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        MenuStuff stuff = (MenuStuff) this.stuff;

        if (stuff.getPlayButton().contains(x, y)) {
            logic.getButtonHandler().playButtonPressed();
        }
    }
}