package com.epicness.newfrost.game.logic;

import com.epicness.fundamentals.input.InputHandler;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.M;
import static com.badlogic.gdx.Input.Keys.R;
import static com.badlogic.gdx.Input.Keys.S;

public class GameInputHandler extends InputHandler {

    @Override
    public void mouseMoved(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;

        logic.getHighlightHandler().mouseMoved(x, y);
        logic.getMainBuildingMenuHandler().mouseMoved(x, y);
    }

    @Override
    public void touchUp(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;

        if (logic.getMainBuildingMenuHandler().touchUp(x, y)) {
            return;
        }
        logic.getTipHandler().touchUp(x, y);
    }

    @Override
    public void keyDown(int keycode) {
        GameLogic logic = (GameLogic) this.logic;

        switch (keycode) {
            case R:
                logic.getGameOverHandler().restart();
                break;
            case M:
                logic.getDayHandler().passDay();
                break;
            case A:
                logic.getPlayerMovementHandler().aPress();
                break;
            case D:
                logic.getPlayerMovementHandler().dPress();
                break;
            case S:
                logic.getActionHandler().sPress();
                break;
        }
    }

    @Override
    public void keyUp(int keycode) {
        GameLogic logic = (GameLogic) this.logic;

        switch (keycode) {
            case A:
                logic.getPlayerMovementHandler().aRelease();
                break;
            case D:
                logic.getPlayerMovementHandler().dRelease();
                break;
        }
    }
}