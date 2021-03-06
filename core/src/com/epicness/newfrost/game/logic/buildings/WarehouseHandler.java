package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_COLOR;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEAD_SIZE;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_PILE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_WIDTH;

import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.buildings.Warehouse;

public class WarehouseHandler {

    // Structure
    private GameAssets assets;

    public void addLogs(Warehouse warehouse, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Sprited log = new Sprited(assets.getWarehouseLog());
            log.setSize(WAREHOUSE_LOG_WIDTH, WAREHOUSE_LOG_HEIGHT);
            float logX = warehouse.getX(), logY = warehouse.getY();
            switch (warehouse.getLogs() % 10) {
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
            logX += warehouse.getLogPiles() * WAREHOUSE_LOG_PILE_WIDTH;
            log.setPosition(logX, logY);
            log.setColor(WAREHOUSE_LOG_COLOR);
            warehouse.addLog(log);
        }
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}