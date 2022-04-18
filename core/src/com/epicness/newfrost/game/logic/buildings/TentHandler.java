package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.TENT_UPGRADE_COST;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Tent;
import com.epicness.newfrost.game.stuff.buildings.Warehouse;

public class TentHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void interact(Tent tent) {
        int logs = countLogs();
        if (logs < TENT_UPGRADE_COST) {
            return;
        }
        tent.upgrade();
        logic.getLogHandler().removeLogs(TENT_UPGRADE_COST);
        logic.getSpendingHandler().vanishLog();
    }

    private int countLogs() {
        DelayedRemovalArray<Building> buildings = stuff.getBuildings();
        int logs = 0;
        for (int i = 0; i < buildings.size; i++) {
            Building building = buildings.get(i);
            if (building instanceof Warehouse) {
                logs += ((Warehouse)building).getLogs();
            }
        }
        return logs;
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}