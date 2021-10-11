package com.epicness.newfrost.menu.logic;

import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.newfrost.intro.IntroAssets;
import com.epicness.newfrost.intro.IntroInitializer;

public class ButtonHandler {

    private SharedLogic sharedLogic;

    public void playButtonPressed() {
        sharedLogic.getTransitionHandler().startTransition(new IntroInitializer(new IntroAssets()));
        sharedLogic.getTransitionHandler().allowTransition();
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }
}