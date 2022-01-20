package com.epicness.newfrost.menu.logic;

import com.epicness.fundamentals.input.InputHandler;
import com.epicness.newfrost.menu.MenuStuff;

public class MenuInputHandler extends InputHandler {

    @Override
    public void touchDown(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        MenuStuff stuff = (MenuStuff) this.stuff;

        if (stuff.getPlayButton().contains(x, y)) {
            logic.getButtonHandler().playButtonTouchDown();
        }
    }

    @Override
    public void touchDragged(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        MenuStuff stuff = (MenuStuff) this.stuff;

        logic.getButtonHandler().touchDragged();
        if (stuff.getPlayButton().contains(x, y)) {
            logic.getButtonHandler().playButtonTouchDragged();
        }
    }

    @Override
    public void touchUp(float x, float y) {
        MenuLogic logic = (MenuLogic) this.logic;
        MenuStuff stuff = (MenuStuff) this.stuff;

        logic.getButtonHandler().touchUp();
        if (stuff.getPlayButton().contains(x, y)) {
            logic.getButtonHandler().playButtonTouchUp();
        }
    }
}