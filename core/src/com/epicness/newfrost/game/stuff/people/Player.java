package com.epicness.newfrost.game.stuff.people;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;

import static com.epicness.newfrost.game.GameConstants.PLAYER_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.PLAYER_STARTING_X;
import static com.epicness.newfrost.game.GameConstants.PLAYER_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.PLAYER_WIDTH;

public class Player {

    private final Sprited sprited;
    private float speed;

    public Player(Sprite sprite) {
        sprited = new Sprited(sprite);
        sprited.setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
        sprited.setPosition(PLAYER_STARTING_X, PLAYER_STARTING_Y);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public float getCenterX() {
        return sprited.getX() + sprited.getWidth() / 2f;
    }

    public void translateX(float amount) {
        sprited.translateX(amount);
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setFacingLeft(boolean facingLeft) {
        sprited.setFlip(facingLeft, false);
    }
}