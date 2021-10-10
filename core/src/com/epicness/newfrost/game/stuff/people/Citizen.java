package com.epicness.newfrost.game.stuff.people;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.enums.CitizenActivity;
import com.epicness.newfrost.game.stuff.dialogues.Dialogue;

import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_SIZE;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_STARTING_TEMPERATURE;
import static com.epicness.newfrost.game.GameConstants.GROUND_Y;
import static com.epicness.newfrost.game.enums.CitizenActivity.IDLE;

public class Citizen {

    private final Sprited sprited;
    private CitizenActivity activity;
    private int temperature, hunger;
    private float activityTime, xBeforeActivity;
    private final Dialogue dialogue;

    public Citizen(Sprite sprite, Dialogue dialogue) {
        sprited = new Sprited(sprite);
        sprited.setX(MathUtils.random(CAMERA_WIDTH - CITIZEN_SIZE));
        sprited.setY(GROUND_Y - MathUtils.random(50f));
        sprited.setSize(CITIZEN_SIZE);

        activity = IDLE;

        temperature = CITIZEN_STARTING_TEMPERATURE;

        this.dialogue = dialogue;
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(sprited.getX(), sprited.getY(), sprited.getWidth(), sprited.getHeight());
    }

    // Sprited
    public boolean contains(float x, float y) {
        return sprited.contains(x, y);
    }

    public float getX() {
        return sprited.getX();
    }

    public void setX(float x) {
        sprited.setX(x);
    }

    public float getCenterX() {
        return sprited.getX() + sprited.getWidth() / 2f;
    }

    public void translateX(float amount) {
        sprited.translateX(amount);
    }

    public boolean isFacingLeft() {
        return sprited.isFlipX();
    }

    public void setFacingLeft(boolean facingLeft) {
        sprited.setFlip(facingLeft, false);
    }

    public void setColor(Color color) {
        sprited.setColor(color);
    }

    // Citizen
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

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public float getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(float activityTime) {
        this.activityTime = activityTime;
    }

    public float getXBeforeActivity() {
        return xBeforeActivity;
    }

    public void setXBeforeActivity(float xBeforeActivity) {
        this.xBeforeActivity = xBeforeActivity;
    }

    public Dialogue getDialogue() {
        return dialogue;
    }
}