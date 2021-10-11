package com.epicness.newfrost.intro.logic;

import com.badlogic.gdx.Input;
import com.epicness.fundamentals.input.InputHandler;

public class IntroInputHandler extends InputHandler {

    @Override
    public void keyUp(int keycode) {
        IntroLogic logic = (IntroLogic) this.logic;

        if (keycode == Input.Keys.SPACE) {
            logic.getIntroHandler().spacePressed();
        }
    }
}