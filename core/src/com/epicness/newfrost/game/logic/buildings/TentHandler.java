package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.TENT_UPGRADE_COST;

import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Tent;

public class TentHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void interact(Tent tent) {
        int logs = logic.getLogHandler().getLogs();
        if (logs < TENT_UPGRADE_COST) {
            float x = tent.getCenterX() - stuff.getMessage().getWidth() / 2f;
            logic.getMessageHandler().showMessage(x, tent.getY(), "Not enough logs");
            return;
        }
        tent.upgrade();
        logic.getLogHandler().removeLogs(TENT_UPGRADE_COST);
        logic.getSpendingHandler().vanishLog();
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}