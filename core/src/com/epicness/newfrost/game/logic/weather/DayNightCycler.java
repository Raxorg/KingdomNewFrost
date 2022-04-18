package com.epicness.newfrost.game.logic.weather;

import static com.epicness.newfrost.game.GameConstants.COOKHOUSE_MEAT_COLOR;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_BACKGROUND_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_BACKPACK_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_BUILDING_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_LOG_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_MEAT_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_MEAT_HOOK_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_PEOPLE_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_SKY_COLOR;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_COLOR;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Cookhouse;
import com.epicness.newfrost.game.stuff.buildings.Explorarium;
import com.epicness.newfrost.game.stuff.buildings.Warehouse;

public class DayNightCycler {

    // Structure
    private GameStuff stuff;
    // Logic
    private float progress;
    private Color skyColor, backgroundColor, buildingColor, meatColor, meatHookColor, logColor, backpackColor, peopleColor;

    public void initialize() {
        progress = 0f;
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
        if (secondsLeft > 32f) {
            progress = MathUtils.map(57f, 33f, 0f, 1f, secondsLeft);
        } else if (secondsLeft < 28f) {
            progress = MathUtils.map(27f, 3f, 1f, 0f, secondsLeft);
        }
        progress = MathUtils.clamp(progress, 0f, 1f);

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
            Building building = stuff.getBuildings().get(i);
            building.setColor(buildingColor);
            switch (building.getType()) {
                case BASE:
                    break;
                case TENT:
                    break;
                case MEDICAL_POST:
                    break;
                case WAREHOUSE:
                    ((Warehouse) building).setLogColor(logColor);
                    break;
                case EXPLORARIUM:
                    ((Explorarium) building).setBackpackColor(backpackColor);
                    break;
                case COOKHOUSE:
                    Cookhouse cookhouse = (Cookhouse) building;
                    cookhouse.setMeatColor(meatColor);
                    cookhouse.setMeatHookColor(meatHookColor);
                    break;
            }
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