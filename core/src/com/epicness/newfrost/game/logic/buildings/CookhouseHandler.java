package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_COLOR;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_SPACING;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_STARTING_X;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_WIDTH;

import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.buildings.Cookhouse;

public class CookhouseHandler {

    // Structure
    private GameAssets assets;

    public void addMeats(Cookhouse cookhouse, int quantity) {
        int meats = cookhouse.getMeats();
        for (int i = 0; i < quantity && meats < 10; i++) {
            DualSprited meat = new DualSprited(assets.getCookhouseMeat(), assets.getCookhouseMeatHook());
            meat.setSize(COOKHOUSE_MEAT_WIDTH, COOKHOUSE_MEAT_HEIGHT);
            meat.setPosition(COOKHOUSE_MEAT_STARTING_X, COOKHOUSE_MEAT_STARTING_Y);
            meat.translateX(meats * COOKHOUSE_MEAT_SPACING);
            meat.setBackgroundColor(COOKHOUSE_MEAT_COLOR);
            cookhouse.addMeat(meat);
        }
        cookhouse.sortMeats();
    }

    public void removeMeats(Cookhouse cookhouse, int quantity) {
        cookhouse.removeMeats(quantity);
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}