package com.epicness.newfrost.game.logic.buildings;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Cookhouse;

public class BuildingBuilder {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;

    public void buildCookhouse() {
        Cookhouse cookhouse = new Cookhouse(assets.getCookhouse());

        DelayedRemovalArray<Building> buildings = stuff.getBuildings();
        buildings.add(cookhouse);
    }

    public void destroyBuilding() {
        DelayedRemovalArray<Building> buildings = stuff.getBuildings();
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