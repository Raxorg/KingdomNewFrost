package com.epicness.newfrost.menu.logic;

import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;

public class MenuLogic extends Logic {

    private final ButtonHandler buttonHandler;
    private final MenuInputHandler menuInputHandler;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        buttonHandler = new ButtonHandler();
        menuInputHandler = new MenuInputHandler();

        buttonHandler.setSharedLogic(sharedLogic);

        menuInputHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        menuInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {
        sharedLogic.getAssetLoader().update();
        sharedLogic.getTransitionHandler().update();
    }

    @Override
    public void setInput(SharedInput input) {
        menuInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        menuInputHandler.setStuff(stuff);
    }

    public ButtonHandler getButtonHandler() {
        return buttonHandler;
    }
}