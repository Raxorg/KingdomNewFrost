package com.epicness.newfrost;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.SharedResources;
import com.epicness.newfrost.splash.SplashInitializer;

public class NewFrostGame extends Game {

    @Override
    public void create() {
        new SplashInitializer().initialize(new SharedResources());
    }
}
