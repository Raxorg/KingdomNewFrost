package com.epicness.newfrost.game.logic.weather;

import static com.epicness.newfrost.game.GameConstants.NIGHT_BACKGROUND_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_BUILDING_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_PEOPLE_COLOR;
import static com.epicness.newfrost.game.GameConstants.NIGHT_SKY_COLOR;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.newfrost.game.stuff.GameStuff;

public class DayNightCycler {

    // Structure
    private GameStuff stuff;
    // Logic
    private Color skyColor, backgroundColor, buildingColor, peopleColor;

    public void initialize() {
        skyColor = new Color(Color.WHITE);
        backgroundColor = new Color(Color.WHITE);
        buildingColor = new Color(Color.WHITE);
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