package com.epicness.newfrost.game;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameInitializer extends Initializer {

    public GameInitializer() {
        super(new GameAssets());
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new GameLogic(sharedResources.getLogic());
        renderer = new GameRenderer();
        stuff = new GameStuff();
        super.initialize(sharedResources);
    }
}