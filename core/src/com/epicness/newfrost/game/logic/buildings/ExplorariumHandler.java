package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_COLOR;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_SPACING;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_WIDTH;

import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Explorarium;

public class ExplorariumHandler {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void interact(Explorarium explorarium) {
        int logs = logic.getLogHandler().getLogs();
        int backpacks = explorarium.getBackpacks();
        if (logs < 1 || backpacks == 5) {
            return;
        }
        logic.getLogHandler().removeLogs(1);
        logic.getExplorariumHandler().addBackpacks(explorarium, 1);
        logic.getSpendingHandler().vanishLog();
    }

    public void addBackpacks(Explorarium explorarium, int quantity) {
        int backpacks = explorarium.getBackpacks();
        for (int i = 0; i < quantity && backpacks < 5; i++) {
            Sprited backpack = new Sprited(assets.getExplorariumBackpack());
            backpack.setSize(EXPLORARIUM_BACKPACK_WIDTH, EXPLORARIUM_BACKPACK_HEIGHT);
            backpack.setPosition(explorarium.getStartingBackpackX(), explorarium.getBackpackY());
            backpack.translateX(backpacks * EXPLORARIUM_BACKPACK_SPACING);
            backpack.setColor(EXPLORARIUM_BACKPACK_COLOR);
            explorarium.addBackpack(backpack);
            backpacks++;
        }
        explorarium.sortBackpacks();
    }

    public void removeBackpacks(int quantity) {
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            Building building = stuff.getBuildings().get(i);
            if (building instanceof Explorarium) {
                Explorarium explorarium = (Explorarium) building;
                int reduction = Math.min(explorarium.getBackpacks(), quantity);
                explorarium.removeBackpacks(reduction);
                quantity -= reduction;
            }
        }
    }

    public int getBackpacks() {
        int backpacks = 0;
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            Building building = stuff.getBuildings().get(i);
            if (building instanceof Explorarium) {
                backpacks += ((Explorarium) building).getBackpacks();
            }
        }
        return backpacks;
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