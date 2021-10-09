package com.epicness.newfrost.game.logic;

import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameLogic extends Logic {

    private final CitizenActivityHandler citizenActivityHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        citizenActivityHandler = new CitizenActivityHandler();
    }

    @Override
    public void initialLogic() {

    }

    @Override
    public void update(float delta) {
        citizenActivityHandler.update(delta);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        citizenActivityHandler.setStuff(gameStuff);
    }
}