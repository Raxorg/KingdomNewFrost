package com.epicness.newfrost.menu.logic;

import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.newfrost.game.GameAssets;
import com.epicness.newfrost.game.GameInitializer;

public class ButtonHandler {

    private SharedLogic sharedLogic;

    public void playButtonPressed() {
        sharedLogic.getTransitionHandler().startTransition(new GameInitializer(new GameAssets()));
        sharedLogic.getTransitionHandler().allowTransition();
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }
}