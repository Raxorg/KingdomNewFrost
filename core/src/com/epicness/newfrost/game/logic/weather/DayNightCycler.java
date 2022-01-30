package com.epicness.newfrost.game.logic.weather;

import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_INDEX;
import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_COLOR;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_COLOR;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_INDEX;
import static com.epicness.newfrost.game.GameConstants.NIGHT_BACKGROUND_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_BACKPACK_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_BUILDING_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_LOG_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_MEAT_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_MEAT_HOOK_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_PEOPLE_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_SKY_COLOR;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_INDEX;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_COLOR;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Cookhouse;
import com.epicness.newfrost.game.stuff.buildings.Explorarium;
import com.epicness.newfrost.game.stuff.buildings.Warehouse;

public class DayNightCycler {

    // Structure
    private GameStuff stuff;
    // Logic
    private Color skyColor, backgroundColor, buildingColor, meatColor, meatHookColor, logColor, backpackColor, peopleColor;

    public void initialize() {
        skyColor = new Color(Color.WHITE);
        backgroundColor = new Color(Color.WHITE);
        buildingColor = new Color(Color.WHITE);
        meatColor = new Color(COOKHOUSE_MEAT_COLOR);
        meatHookColor = new Color(Color.WHITE);
        logColor = new Color(WAREHOUSE_LOG_COLOR);
        backpackColor = new Color(EXPLORARIUM_BACKPACK_COLOR);
        peopleColor = new Color(Color.WHITE);
    }

    public void updateColors(int secondsLeft) {
        float progress;
        if (secondsLeft > 30f) {
            progress = MathUtils.map(60f, 30f, 0f, 1f, secondsLeft);
        } else {
            progress = MathUtils.map(30f, 0f, 1f, 0f, secondsLeft);
        }
        skyColor.set(Color.WHITE.cpy().lerp(NIGHT_SKY_COLOR, progress));
        backgroundColor.set(Color.WHITE.cpy().lerp(NIGHT_BACKGROUND_COLOR, progress));
        buildingColor.set(Color.WHITE.cpy().lerp(NIGHT_BUILDING_COLOR, progress));
        meatColor.set(COOKHOUSE_MEAT_COLOR.cpy().lerp(NIGHT_MEAT_COLOR, progress));
        meatHookColor.set(Color.WHITE.cpy().lerp(NIGHT_MEAT_HOOK_COLOR, progress));
        logColor.set(WAREHOUSE_LOG_COLOR.cpy().lerp(NIGHT_LOG_COLOR, progress));
        backpackColor.set(EXPLORARIUM_BACKPACK_COLOR.cpy().lerp(NIGHT_BACKPACK_COLOR, progress));
        peopleColor.set(Color.WHITE.cpy().lerp(NIGHT_PEOPLE_COLOR, progress));
    }

    public void applyColors() {
        stuff.getBackground().setColor(skyColor);
        for (int i = 0; i < stuff.getBGLayers().length; i++) {
            stuff.getBGLayers()[i].setColor(backgroundColor);
        }
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            stuff.getBuildings().get(i).setColor(buildingColor);
        }
        Cookhouse cookhouse = (Cookhouse) stuff.getBuildings().get(COOKHOUSE_INDEX);
        for (int i = 0; i < cookhouse.getCookhouseMeats().size; i++) {
            cookhouse.getCookhouseMeats().get(i).setBackgroundColor(meatColor);
            cookhouse.getCookhouseMeats().get(i).setForegroundColor(meatHookColor);
        }
        Warehouse warehouse = (Warehouse) stuff.getBuildings().get(WAREHOUSE_INDEX);
        for (int i = 0; i < warehouse.getWarehouseLogs().size; i++) {
            warehouse.getWarehouseLogs().get(i).setColor(logColor);
        }
        Explorarium explorarium = (Explorarium) stuff.getBuildings().get(EXPLORARIUM_INDEX);
        for (int i = 0; i < explorarium.getExplorariumBackpacks().size; i++) {
            explorarium.getExplorariumBackpacks().get(i).setColor(backpackColor);
        }
        for (int i = 0; i < stuff.getCitizens().size; i++) {
            stuff.getCitizens().get(i).setColor(peopleColor);
        }
        stuff.getPlayer().setColor(peopleColor);
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}