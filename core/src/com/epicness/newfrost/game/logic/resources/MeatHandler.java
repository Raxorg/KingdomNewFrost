package com.epicness.newfrost.game.logic.resources;

import static com.epicness.newfrost.game.GameConstants.BASE_MAX_MEATS;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MAX_MEATS;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_COLOR;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEAD_SIZE;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEIGHT;

import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Base;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Cookhouse;

public class MeatHandler {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public int getMeats() {
        int meats = 0;
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            Building building = stuff.getBuildings().get(i);
            switch (building.getType()) {
                case COOKHOUSE:
                    meats += ((Cookhouse) building).getMeats();
                    break;
                case BASE:
                    meats += ((Base) building).getLogs();
            }
        }
        return meats;
    }

    public void addMeats(int quantity) {
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            Building building = stuff.getBuildings().get(i);
            if (building instanceof Cookhouse) {
                Cookhouse cookhouse = (Cookhouse) building;
                int maxAddition = COOKHOUSE_MAX_MEATS - cookhouse.getMeats();
                int addition = Math.min(maxAddition, quantity);
                logic.getCookhouseHandler().addMeats(cookhouse, quantity);
                quantity -= addition;
            } else if (building instanceof Base) {
                Base base = (Base) building;
                int maxAddition = BASE_MAX_MEATS - base.getMeats();
                int addition = Math.min(maxAddition, quantity);
                logic.getBaseResourceHandler().addMeats(quantity);
                quantity -= addition;
            }
        }
    }

    private void addMeats(Building building, int quantity, int meats) {
        for (int i = 0; i < quantity; i++) {
            DualSprited meat = new DualSprited(assets.getCookhouseMeat(), assets.getCookhouseMeatHook());
            meat.setSize(COOKHOUSE_MEAT_WIDTH, COOKHOUSE_MEAT_HEIGHT);
            float meatX = building.getX(), meatY = building.getY();
            switch (meats % 10) {
                case 1:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE;
                    break;
                case 2:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE * 2f;
                    break;
                case 3:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE * 3f;
                    break;
                case 4:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE * 0.5f;
                    meatY += WAREHOUSE_LOG_HEIGHT;
                    break;
                case 5:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE * 1.5f;
                    meatY += WAREHOUSE_LOG_HEIGHT;
                    break;
                case 6:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE * 2.5f;
                    meatY += WAREHOUSE_LOG_HEIGHT;
                    break;
                case 7:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE;
                    meatY += WAREHOUSE_LOG_HEIGHT * 2f;
                    break;
                case 8:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE * 2f;
                    meatY += WAREHOUSE_LOG_HEIGHT * 2f;
                    break;
                case 9:
                    meatX += WAREHOUSE_LOG_HEAD_SIZE * 1.5f;
                    meatY += WAREHOUSE_LOG_HEIGHT * 3f;
                    break;
            }
            meat.setPosition(meatX, meatY);
            meat.setColor(COOKHOUSE_MEAT_COLOR);
            if (building instanceof Cookhouse) {
                ((Cookhouse) building).addMeat(meat);
            } else if (building instanceof Base) {
                ((Base) building).addMeat(meat);
            }
        }
    }

    public void removeMeats(int quantity) {
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            Building building = stuff.getBuildings().get(i);
            if (building instanceof Cookhouse) {
                Cookhouse cookhouse = (Cookhouse) building;
                int reduction = Math.min(cookhouse.getMeats(), quantity);
                cookhouse.removeMeats(reduction);
                quantity -= reduction;
            } else if (building instanceof Base) {
                Base base = (Base) building;
                int reduction = Math.min(base.getMeats(), quantity);
                base.removeMeats(reduction);
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