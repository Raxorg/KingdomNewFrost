package com.epicness.newfrost.game.logic;

import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_25;
import static com.epicness.newfrost.game.GameConstants.STARTING_CITIZENS;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameOverHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private boolean showingGameOverMessage, victory;

    public void init() {
        stuff.getGameOverMessage().setColor(Color.CLEAR);
        stuff.getGameOverMessage().setTextColor(Color.CLEAR);
        stuff.getHanged().setColor(Color.CLEAR);
        stuff.getHangedText().setColor(Color.CLEAR);
        showingGameOverMessage = false;
        victory = false;
    }

    public void lessThan6Citizens() {
        stuff.getGameOverMessage().setText("WE DID AS YOU ORDERED\nALMOST EVERYONE IS DEAD...\nWE HAD ENOUGH OF YOU");
        victory = false;
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
        stuff.getGameOverMessage().setText(gameOverText);
        victory = true;
        showGameOver();
    }

    private void showGameOver() {
        stuff.getGameOverMessage().setText(stuff.getGameOverMessage().getText());
        stuff.getGameOverMessage().setColor(BLACK_CLEAR_25);
        stuff.getGameOverMessage().setTextColor(Color.WHITE);
        showingGameOverMessage = true;
    }

    public void touchUp() {
        if (!showingGameOverMessage) {
            return;
        }
        sharedLogic.getFader().fadeIn(this::showFinalScreen);
    }

    private void showFinalScreen() {
        if (victory) {
            // TODO: 3/2/2022 proper victory screen
            // stuff.getHanged().setColor(Color.WHITE);
        } else {
            stuff.getHanged().setColor(Color.WHITE);
            stuff.getHangedText().setColor(Color.WHITE);
            sharedLogic.getFader().fadeOut();
        }
        showingGameOverMessage = false;
    }

    public void restart() {
        logic.initialLogic();
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}