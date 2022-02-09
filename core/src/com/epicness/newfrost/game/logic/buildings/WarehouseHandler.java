package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_INDEX;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_COLOR;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEAD_SIZE;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_PILE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_STARTING_X;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_MAX_LOGS;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Warehouse;

public class WarehouseHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private int logs, logPiles;

    public void init() {
        Warehouse warehouse = (Warehouse) stuff.getBuildings().get(WAREHOUSE_INDEX);
        DelayedRemovalArray<Sprited> warehouseLogs = warehouse.getWarehouseLogs();
        warehouseLogs.clear();
        logs = 0;
        logPiles = 0;
    }

    public void addLogs(int quantity) {
        Warehouse warehouse = (Warehouse) stuff.getBuildings().get(WAREHOUSE_INDEX);
        DelayedRemovalArray<Sprited> warehouseLogs = warehouse.getWarehouseLogs();
        for (int i = 0; i < quantity && logs < WAREHOUSE_MAX_LOGS; i++) {
            Sprited log = new Sprited(assets.getWarehouseLog());
            log.setSize(WAREHOUSE_LOG_WIDTH, WAREHOUSE_LOG_HEIGHT);
            float logX = WAREHOUSE_LOG_STARTING_X, logY = WAREHOUSE_LOG_STARTING_Y;
            switch (logs % 10) {
                case 1:
                    logX += WAREHOUSE_LOG_HEAD_SIZE;
                    break;
                case 2:
                    logX += WAREHOUSE_LOG_HEAD_SIZE * 2f;
                    break;
                case 3:
                    logX += WAREHOUSE_LOG_HEAD_SIZE * 3f;
                    break;
                case 4:
                    logX += WAREHOUSE_LOG_HEAD_SIZE * 0.5f;
                    logY += WAREHOUSE_LOG_HEIGHT;
                    break;
                case 5:
                    logX += WAREHOUSE_LOG_HEAD_SIZE * 1.5f;
                    logY += WAREHOUSE_LOG_HEIGHT;
                    break;
                case 6:
                    logX += WAREHOUSE_LOG_HEAD_SIZE * 2.5f;
                    logY += WAREHOUSE_LOG_HEIGHT;
                    break;
                case 7:
                    logX += WAREHOUSE_LOG_HEAD_SIZE;
                    logY += WAREHOUSE_LOG_HEIGHT * 2f;
                    break;
                case 8:
                    logX += WAREHOUSE_LOG_HEAD_SIZE * 2f;
                    logY += WAREHOUSE_LOG_HEIGHT * 2f;
                    break;
                case 9:
                    logX += WAREHOUSE_LOG_HEAD_SIZE * 1.5f;
                    logY += WAREHOUSE_LOG_HEIGHT * 3f;
                    break;
            }
            logX += logPiles * WAREHOUSE_LOG_PILE_WIDTH;
            log.setPosition(logX, logY);
            log.setColor(WAREHOUSE_LOG_COLOR);
            warehouseLogs.add(log);
            logs++;
            logPiles = logs / 10;
        }
    }

    public void removeLogs(int quantity) {
        Warehouse warehouse = (Warehouse) stuff.getBuildings().get(WAREHOUSE_INDEX);
        DelayedRemovalArray<Sprited> warehouseLogs = warehouse.getWarehouseLogs();
        for (int i = 0; i < quantity && logs > 0; i++) {
            warehouseLogs.removeIndex(warehouseLogs.size - 1);
            logs--;
        }
        logPiles = logs / 10;
    }

    public int getLogs() {
        return logs;
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}