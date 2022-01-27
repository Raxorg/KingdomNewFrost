package com.epicness.newfrost.game.logic;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.M;
import static com.badlogic.gdx.Input.Keys.R;
import static com.badlogic.gdx.Input.Keys.S;

import com.epicness.fundamentals.input.InputHandler;

public class GameInputHandler extends InputHandler {

    @Override
    public void mouseMovedDynamic(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;

        logic.getHighlightHandler().mouseMoved(x, y);
        logic.getMainBuildingMenuHandler().mouseMoved(x, y);
    }

    @Override
    public void touchUp(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;

        logic.getTipHandler().touchUp(x, y);
    }

    @Override
    public void touchUpDynamic(float x, float y) {
        GameLogic logic = (GameLogic) this.logic;

        logic.getMainBuildingMenuHandler().touchUp(x, y);
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