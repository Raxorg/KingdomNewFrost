package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.newfrost.game.stuff.GameStuff;

import static com.epicness.fundamentals.SharedConstants.OPAQUE_TRANSPARENT;
import static com.epicness.newfrost.game.GameConstants.STARTING_CITIZENS;

public class GameOverHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private int citizens;

    private void showGameOver() {
        stuff.getGameOver().setColor(OPAQUE_TRANSPARENT);
        stuff.getGameOver().setTextColor(Color.WHITE);
    }

    public void init() {
        stuff.getGameOver().setColor(Color.CLEAR);
        stuff.getGameOver().setTextColor(Color.CLEAR);
        citizens = STARTING_CITIZENS;
    }

    public void citizenDied() {
        citizens--;
        if (citizens <= 5) {
            showGameOver();
        }
    }

    public void restart() {
        logic.initialLogic();
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}