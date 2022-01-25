package com.epicness.newfrost.game.stuff.people;

import static com.badlogic.gdx.graphics.g2d.Animation.PlayMode.LOOP;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_STARTING_TEMPERATURE;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_WIDTH;
import static com.epicness.newfrost.game.GameConstants.GROUND_Y;
import static com.epicness.newfrost.game.enums.CitizenActivity.IDLE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.enums.CitizenActivity;
import com.epicness.newfrost.game.stuff.dialogues.Dialogue;

public class Citizen {

    private final Animation<Sprited> idle, walking, dying, walkingExplorer;
    private float animationTime;
    private CitizenActivity activity;
    private int temperature, hunger;
    private float activityTime, xBeforeActivity;
    private final Dialogue dialogue;
    private boolean explorer;

    public Citizen(GameAssets assets, Dialogue dialogue) {
        idle = new Animation<>(
                0.75f,
                new Sprited(assets.getIdleCitizen0()),
                new Sprited(assets.getIdleCitizen1())
        );
        for (int i = 0; i < idle.getKeyFrames().length; i++) {
            idle.getKeyFrames()[i].setSize(CITIZEN_WIDTH, CITIZEN_HEIGHT);
        }
        idle.setPlayMode(LOOP);

        walking = new Animation<>(
                0.1f,
                new Sprited(assets.getWalkingCitizen0()),
                new Sprited(assets.getWalkingCitizen1()),
                new Sprited(assets.getWalkingCitizen2()),
                new Sprited(assets.getWalkingCitizen3()),
                new Sprited(assets.getWalkingCitizen4()),
                new Sprited(assets.getWalkingCitizen5()),
                new Sprited(assets.getWalkingCitizen6()),
                new Sprited(assets.getWalkingCitizen7())
        );
        for (int i = 0; i < walking.getKeyFrames().length; i++) {
            walking.getKeyFrames()[i].setSize(CITIZEN_WIDTH, CITIZEN_HEIGHT);
        }
        walking.setPlayMode(LOOP);

        dying = new Animation<>(
                0.35f,
                new Sprited(assets.getDyingCitizen0()),
                new Sprited(assets.getDyingCitizen1()),
                new Sprited(assets.getDyingCitizen2()),
                new Sprited(assets.getDyingCitizen3())
        );
        for (int i = 0; i < dying.getKeyFrames().length; i++) {
            dying.getKeyFrames()[i].setSize(CITIZEN_HEIGHT, CITIZEN_HEIGHT);
        }

        walkingExplorer = new Animation<>(
                0.1f,
                new Sprited(assets.getWalkingExplorer1()),
                new Sprited(assets.getWalkingExplorer2()),
                new Sprited(assets.getWalkingExplorer3()),
                new Sprited(assets.getWalkingExplorer4()),
                new Sprited(assets.getWalkingExplorer5()),
                new Sprited(assets.getWalkingExplorer6()),
                new Sprited(assets.getWalkingExplorer7())
        );
        for (int i = 0; i < walkingExplorer.getKeyFrames().length; i++) {
            walkingExplorer.getKeyFrames()[i].setSize(CITIZEN_WIDTH, CITIZEN_HEIGHT);
        }
        walkingExplorer.setPlayMode(LOOP);

        setX(MathUtils.random(CAMERA_WIDTH - CITIZEN_HEIGHT));
        setY(GROUND_Y - MathUtils.random(10f, 50f));

        animationTime = MathUtils.random(1.5f);

        activity = IDLE;

        temperature = CITIZEN_STARTING_TEMPERATURE;

        hunger = MathUtils.random(1);

        activityTime = MathUtils.random(2f, 7f);

        this.dialogue = dialogue;
    }

    public void draw(SpriteBatch spriteBatch) {
        switch (activity) {
            case IDLE:
            case EATING:
                if (explorer) {
                    walkingExplorer.getKeyFrame(0f).draw(spriteBatch);
                } else {
                    idle.getKeyFrame(animationTime).draw(spriteBatch);
                }
                break;
            case MOVING_RANDOMLY:
            case GOING_TO_EAT:
            case RETURNING_FROM_EATING:
            case GOING_TO_EXPEDITION:
            case RETURNING_FROM_EXPEDITION:
                if (explorer) {
                    walkingExplorer.getKeyFrame(animationTime).draw(spriteBatch);
                } else {
                    walking.getKeyFrame(animationTime).draw(spriteBatch);
                }
                break;
            case DYING:
                dying.getKeyFrame(animationTime).draw(spriteBatch);
                break;
        }
    }

    public void drawDebug(ShapeRenderer shapeRenderer) {
        Sprited sprited = idle.getKeyFrame(0f);
        shapeRenderer.rect(sprited.getX(), sprited.getY(), sprited.getWidth(), sprited.getHeight());
    }

    // Sprited
    public boolean contains(float x, float y) {
        Sprited sprited = idle.getKeyFrame(0f);
        return sprited.contains(x, y);
    }

    public float getX() {
        Sprited sprited = idle.getKeyFrame(0f);
        return sprited.getX();
    }

    public void setX(float x) {
        for (int i = 0; i < idle.getKeyFrames().length; i++) {
            idle.getKeyFrames()[i].setX(x);
        }
        for (int i = 0; i < walking.getKeyFrames().length; i++) {
            walking.getKeyFrames()[i].setX(x);
        }
        for (int i = 0; i < dying.getKeyFrames().length; i++) {
            dying.getKeyFrames()[i].setX(x);
        }
        for (int i = 0; i < walkingExplorer.getKeyFrames().length; i++) {
            walkingExplorer.getKeyFrames()[i].setX(x);
        }
    }

    public float getY() {
        Sprited sprited = idle.getKeyFrame(0f);
        return sprited.getY();
    }

    private void setY(float y) {
        for (int i = 0; i < idle.getKeyFrames().length; i++) {
            idle.getKeyFrames()[i].setY(y);
        }
        for (int i = 0; i < walking.getKeyFrames().length; i++) {
            walking.getKeyFrames()[i].setY(y);
        }
        for (int i = 0; i < dying.getKeyFrames().length; i++) {
            dying.getKeyFrames()[i].setY(y);
        }
        for (int i = 0; i < walkingExplorer.getKeyFrames().length; i++) {
            walkingExplorer.getKeyFrames()[i].setY(y);
        }
    }

    public float getCenterX() {
        Sprited sprited = idle.getKeyFrame(0f);
        return sprited.getX() + sprited.getWidth() / 2f;
    }

    public void translateX(float amount) {
        for (int i = 0; i < idle.getKeyFrames().length; i++) {
            idle.getKeyFrames()[i].translateX(amount);
        }
        for (int i = 0; i < walking.getKeyFrames().length; i++) {
            walking.getKeyFrames()[i].translateX(amount);
        }
        for (int i = 0; i < dying.getKeyFrames().length; i++) {
            dying.getKeyFrames()[i].translateX(amount);
        }
        for (int i = 0; i < walkingExplorer.getKeyFrames().length; i++) {
            walkingExplorer.getKeyFrames()[i].translateX(amount);
        }
    }

    public boolean isFacingLeft() {
        Sprited sprited = idle.getKeyFrame(0f);
        return sprited.isFlipX();
    }

    public void setFacingLeft(boolean facingLeft) {
        for (int i = 0; i < idle.getKeyFrames().length; i++) {
            idle.getKeyFrames()[i].setFlip(facingLeft, false);
        }
        for (int i = 0; i < walking.getKeyFrames().length; i++) {
            walking.getKeyFrames()[i].setFlip(facingLeft, false);
        }
        for (int i = 0; i < dying.getKeyFrames().length; i++) {
            dying.getKeyFrames()[i].setFlip(facingLeft, false);
        }
        for (int i = 0; i < walkingExplorer.getKeyFrames().length; i++) {
            walkingExplorer.getKeyFrames()[i].setFlip(facingLeft, false);
        }
    }

    public void setColor(Color color) {
        for (int i = 0; i < idle.getKeyFrames().length; i++) {
            idle.getKeyFrames()[i].setColor(color);
        }
        for (int i = 0; i < walking.getKeyFrames().length; i++) {
            walking.getKeyFrames()[i].setColor(color);
        }
        for (int i = 0; i < dying.getKeyFrames().length; i++) {
            dying.getKeyFrames()[i].setColor(color);
        }
        for (int i = 0; i < walkingExplorer.getKeyFrames().length; i++) {
            walkingExplorer.getKeyFrames()[i].setColor(color);
        }
    }

    // Citizen
    public float getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(float animationTime) {
        this.animationTime = animationTime;
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

    public boolean isExplorer() {
        return explorer;
    }

    public void setExplorer(boolean explorer) {
        this.explorer = explorer;
    }
}