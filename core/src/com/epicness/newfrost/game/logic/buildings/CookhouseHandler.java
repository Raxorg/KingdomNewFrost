package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_INDEX;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_SPACING;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_STARTING_X;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_WIDTH;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.DualSprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Cookhouse;

public class CookhouseHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private int meats;

    public void addMeats(int quantity) {
        Cookhouse cookhouse = (Cookhouse) stuff.getBuildings().get(COOKHOUSE_INDEX);
        DelayedRemovalArray<DualSprited> cookhouseMeats = cookhouse.getCookhouseMeats();
        for (int i = 0; i < quantity && meats < 10; i++) {
            DualSprited meat = new DualSprited(assets.getCookhouseMeat(), assets.getCookhouseMeatHook());
            meat.setSize(COOKHOUSE_MEAT_WIDTH, COOKHOUSE_MEAT_HEIGHT);
            meat.setPosition(COOKHOUSE_MEAT_STARTING_X, COOKHOUSE_MEAT_STARTING_Y);
            meat.translateX(meats * COOKHOUSE_MEAT_SPACING);
            meat.setBackgroundColor(Color.LIGHT_GRAY.cpy().lerp(Color.RED, 0.15f));
            cookhouseMeats.add(meat);
            meats++;
        }
        cookhouseMeats.sort((sprited1, sprited2) -> sprited1.getX() > sprited2.getX() ? -1 : 0);
    }

    public void removeMeats(int quantity) {

    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}