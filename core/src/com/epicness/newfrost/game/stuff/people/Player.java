package com.epicness.newfrost.game.stuff.people;

import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import static com.epicness.newfrost.game.GameConstants.PLAYER_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.PLAYER_STARTING_X;
import static com.epicness.newfrost.game.GameConstants.PLAYER_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.PLAYER_WIDTH;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;

public class Player {

    private final Animation<Sprited> idleAnimation;
    private final Animation<Sprited> walkingAnimation;
    private float animationTime;
    private float speed;

    public Player(GameAssets assets) {
        idleAnimation = new Animation<>(
                0.75f,
                new Sprited(assets.getIdleGovernor0()),
                new Sprited(assets.getIdleGovernor1())
        );
        for (int i = 0; i < idleAnimation.getKeyFrames().length; i++) {
            idleAnimation.getKeyFrames()[i].setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
        }
        idleAnimation.setPlayMode(LOOP);

        walkingAnimation = new Animation<>(
                0.1f,
                new Sprited(assets.getWalkingGovernor0()),
                new Sprited(assets.getWalkingGovernor1()),
                new Sprited(assets.getWalkingGovernor2()),
                new Sprited(assets.getWalkingGovernor3()),
                new Sprited(assets.getWalkingGovernor4()),
                new Sprited(assets.getWalkingGovernor5()),
                new Sprited(assets.getWalkingGovernor6()),
                new Sprited(assets.getWalkingGovernor7()),
                new Sprited(assets.getWalkingGovernor8())
        );
        for (int i = 0; i < walkingAnimation.getKeyFrames().length; i++) {
            walkingAnimation.getKeyFrames()[i].setSize(PLAYER_WIDTH, PLAYER_HEIGHT);
        }
        walkingAnimation.setPlayMode(LOOP);

        setX(PLAYER_STARTING_X);
        setY(PLAYER_STARTING_Y);

        animationTime = MathUtils.random(1.5f);
    }

    public void draw(SpriteBatch spriteBatch) {
        if (speed == 0f) {
            idleAnimation.getKeyFrame(animationTime).draw(spriteBatch);
        } else {
            walkingAnimation.getKeyFrame(animationTime).draw(spriteBatch);
        }
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        if (speed == 0f) {
            idleAnimation.getKeyFrame(animationTime).drawDebug(shapeRenderer);
        } else {
            walkingAnimation.getKeyFrame(animationTime).drawDebug(shapeRenderer);
        }
    }

    public float getX() {
        return idleAnimation.getKeyFrames()[0].getX();
    }

    private void setX(float x) {
        for (int i = 0; i < idleAnimation.getKeyFrames().length; i++) {
            idleAnimation.getKeyFrames()[i].setX(x);
        }
        for (int i = 0; i < walkingAnimation.getKeyFrames().length; i++) {
            walkingAnimation.getKeyFrames()[i].setX(x);
        }
    }

    private void setY(float y) {
        for (int i = 0; i < idleAnimation.getKeyFrames().length; i++) {
            idleAnimation.getKeyFrames()[i].setY(y);
        }
        for (int i = 0; i < walkingAnimation.getKeyFrames().length; i++) {
            walkingAnimation.getKeyFrames()[i].setY(y);
        }
    }

    public float getCenterX() {
        Sprited sprited = idleAnimation.getKeyFrames()[0];
        return sprited.getX() + sprited.getWidth() / 2f;
    }

    public void translateX(float amount) {
        for (int i = 0; i < idleAnimation.getKeyFrames().length; i++) {
            idleAnimation.getKeyFrames()[i].translateX(amount);
        }
        for (int i = 0; i < walkingAnimation.getKeyFrames().length; i++) {
            walkingAnimation.getKeyFrames()[i].translateX(amount);
        }
    }

    public float getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(float animationTime) {
        this.animationTime = animationTime;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setFacingLeft(boolean facingLeft) {
        for (int i = 0; i < idleAnimation.getKeyFrames().length; i++) {
            idleAnimation.getKeyFrames()[i].setFlip(facingLeft, false);
        }
        for (int i = 0; i < walkingAnimation.getKeyFrames().length; i++) {
            walkingAnimation.getKeyFrames()[i].setFlip(facingLeft, false);
        }
    }
}