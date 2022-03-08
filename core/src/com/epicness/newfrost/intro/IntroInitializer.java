package com.epicness.newfrost.intro;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.newfrost.intro.logic.IntroLogic;

public class IntroInitializer extends Initializer {

    public IntroInitializer() {
        super(new IntroAssets());
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new IntroLogic(sharedResources.getLogic());
        renderer = new IntroRenderer();
        stuff = new IntroStuff();
        super.initialize(sharedResources);
    }
}