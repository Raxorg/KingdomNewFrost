package com.epicness.newfrost.game.stuff;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.CitizenActivity;

import static com.epicness.newfrost.game.GameConstants.CITIZEN_SIZE;

public class Citizen {

    private final Sprited sprited;
    private CitizenActivity activity;
    private int temperature;
    private float activityTime;

    public Citizen(Sprite sprite) {
        sprited = new Sprited(sprite);
        sprited.setSize(CITIZEN_SIZE);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public CitizenActivity getActivity() {
        return activity;
    }

    public void setActivity(CitizenActivity activity) {
        this.activity = activity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public float getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(float activityTime) {
        this.activityTime = activityTime;
    }
}