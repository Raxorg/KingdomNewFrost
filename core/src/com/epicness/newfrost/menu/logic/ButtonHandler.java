package com.epicness.newfrost.menu.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.newfrost.intro.IntroAssets;
import com.epicness.newfrost.intro.IntroInitializer;
import com.epicness.newfrost.menu.MenuStuff;

public class ButtonHandler {

    // Structure
    private SharedInput input;
    private SharedLogic sharedLogic;
    private MenuStuff stuff;

    public void playButtonTouchDown() {
        stuff.getPlayButton().setColor(Color.GRAY);
    }

    public void touchDragged() {
        stuff.getPlayButton().setColor(Color.WHITE);
    }

    public void playButtonTouchDragged() {
        stuff.getPlayButton().setColor(Color.GRAY);
    }

    public void touchUp() {
        stuff.getPlayButton().setColor(Color.WHITE);
    }

    public void playButtonTouchUp() {
        stuff.getPlayButton().setColor(Color.WHITE);
        sharedLogic.getTransitionHandler().startTransition(new IntroInitializer(new IntroAssets()));
        sharedLogic.getTransitionHandler().allowTransition();
        input.setEnabled(false);
    }

    // Structure
    public void setInput(SharedInput input) {
        this.input = input;
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(MenuStuff stuff) {
        this.stuff = stuff;
    }
}