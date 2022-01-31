package com.epicness.newfrost.game.logic;

import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_25;
import static com.epicness.newfrost.game.GameConstants.STARTING_CITIZENS;

import com.badlogic.gdx.graphics.Color;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameOverHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void hideGameOver() {
        stuff.getGameOver().setColor(Color.CLEAR);
        stuff.getGameOver().setTextColor(Color.CLEAR);
    }

    public void lessThan6Citizens() {
        stuff.getGameOver().setText("WE DID AS YOU ORDERED\nALMOST EVERYONE IS DEAD...\nWE HAD ENOUGH OF YOU");
        showGameOver();
    }

    public void day10Ended() {
        int survivors = logic.getCitizenHandler().getAliveCitizens();
        int dead = STARTING_CITIZENS - survivors;
        String gameOverText = "";
        if (dead > 0) {
            gameOverText += survivors + " SURVIVED\n" + dead + " DIED\nWE DID WHAT WE COULD...";
        } else {
            gameOverText += "EVERYONE UNDER YOUR RULE SURVIVED\nBUT WHAT ABOUT THE PEOPLE STILL OUT THERE...";
        }
        stuff.getGameOver().setText(gameOverText);
        showGameOver();
    }

    private void showGameOver() {
        stuff.getGameOver().setText(stuff.getGameOver().getText() + "\nR TO RESTART");
        stuff.getGameOver().setColor(BLACK_CLEAR_25);
        stuff.getGameOver().setTextColor(Color.WHITE);
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