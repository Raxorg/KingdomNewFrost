package com.epicness.newfrost.menu;

import com.epicness.fundamentals.Initializer;
import com.epicness.fundamentals.SharedResources;
import com.epicness.newfrost.menu.logic.MenuLogic;

public class MenuInitializer extends Initializer {

    public MenuInitializer(MenuAssets assets) {
        super(assets);
    }

    @Override
    public void initialize(SharedResources sharedResources) {
        logic = new MenuLogic(sharedResources.getLogic());
        renderer = new MenuRenderer();
        stuff = new MenuStuff();
        super.initialize(sharedResources);
    }
}