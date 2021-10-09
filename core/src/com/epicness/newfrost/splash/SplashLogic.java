package com.epicness.newfrost.splash;

import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.newfrost.game.GameAssets;
import com.epicness.newfrost.game.GameInitializer;

public class SplashLogic extends Logic {

    public SplashLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    @Override
    public void initialLogic() {
        sharedLogic.getTransitionHandler().startTransition(new GameInitializer(new GameAssets()));
        sharedLogic.getTransitionHandler().allowTransition();
    }

    @Override
    public void update(float delta) {
        sharedLogic.getTransitionHandler().update();
        sharedLogic.getAssetLoader().update();
    }
}