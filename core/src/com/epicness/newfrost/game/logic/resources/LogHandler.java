package com.epicness.newfrost.game.logic.resources;

import static com.epicness.newfrost.game.GameConstants.BASE_MAX_LOGS;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_COLOR;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEAD_SIZE;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_PILE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_MAX_LOGS;

import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Base;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Warehouse;

public class LogHandler {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public int getLogs() {
        int logs = 0;
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            Building building = stuff.getBuildings().get(i);
            switch (building.getType()) {
                case WAREHOUSE:
                    logs += ((Warehouse) building).getLogs();
                    break;
                case BASE:
                    logs += ((Base) building).getLogs();
            }
        }
        return logs;
    }

    public void addLogs(int quantity) {
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            Building building = stuff.getBuildings().get(i);
            if (building instanceof Warehouse) {
                Warehouse warehouse = (Warehouse) building;
                int maxAddition = WAREHOUSE_MAX_LOGS - warehouse.getLogs();
                int addition = Math.min(maxAddition, quantity);
                logic.getWarehouseHandler().addLogs(warehouse, quantity);
                quantity -= addition;
            } else if (building instanceof Base) {
                Base base = (Base) building;
                int maxAddition = BASE_MAX_LOGS - base.getLogs();
                int addition = Math.min(maxAddition, quantity);
                logic.getBaseResourceHandler().addLogs(quantity);
                quantity -= addition;
            }
        }
    }

    public void removeLogs(int quantity) {
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            Building building = stuff.getBuildings().get(i);
            if (building instanceof Warehouse) {
                Warehouse warehouse = (Warehouse) building;
                int reduction = Math.min(warehouse.getLogs(), quantity);
                warehouse.removeLogs(reduction);
                quantity -= reduction;
            } else if (building instanceof Base) {
                Base base = (Base) building;
                int reduction = Math.min(base.getLogs(), quantity);
                base.removeLogs(reduction);
                quantity -= reduction;
            }
        }
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}