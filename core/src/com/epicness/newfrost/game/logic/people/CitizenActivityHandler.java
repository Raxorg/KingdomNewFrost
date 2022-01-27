package com.epicness.newfrost.game.logic.people;

import static com.epicness.newfrost.game.GameConstants.CITIZEN_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_MAX_X;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_MIN_X;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_SPEED;
import static com.epicness.newfrost.game.GameConstants.DINING_X;
import static com.epicness.newfrost.game.GameConstants.GOING_TO_EXPEDITION_TIME;
import static com.epicness.newfrost.game.GameConstants.RETURNING_FROM_EXPEDITION_TIME;
import static com.epicness.newfrost.game.enums.CitizenActivity.EATING;
import static com.epicness.newfrost.game.enums.CitizenActivity.IDLE;
import static com.epicness.newfrost.game.enums.CitizenActivity.MOVING_RANDOMLY;
import static com.epicness.newfrost.game.enums.CitizenActivity.ON_EXPEDITION;
import static com.epicness.newfrost.game.enums.CitizenActivity.RETURNING_FROM_EATING;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

public class CitizenActivityHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        for (int i = 0; i < citizens.size; i++) {
            Citizen citizen = citizens.get(i);
            citizen.setAnimationTime(citizen.getAnimationTime() + delta);
            switch (citizen.getActivity()) {
                case IDLE:
                    handleIdleActivity(citizen, delta);
                    break;
                case MOVING_RANDOMLY:
                    handleMovingRandomlyActivity(citizen, delta);
                    break;
                case GOING_TO_EAT:
                    handleGoingToEatActivity(citizen, delta);
                    break;
                case EATING:
                    handleEatingActivity(citizen, delta);
                    break;
                case RETURNING_FROM_EATING:
                    handleReturningFromEating(citizen, delta);
                    break;
                case GOING_TO_EXPEDITION:
                    handleGoingToExpeditionActivity(citizen, delta);
                    break;
                case ON_EXPEDITION:
                    break;
                case RETURNING_FROM_EXPEDITION:
                    handleReturningFromExpeditionActivity(citizen, delta);
                    break;
            }
        }
    }

    private void handleIdleActivity(Citizen citizen, float delta) {
        float activityTime = citizen.getActivityTime() - delta;
        citizen.setActivityTime(activityTime);
        if (activityTime <= 0f) {
            citizen.setAnimationTime(0f);
            citizen.setFacingLeft(MathUtils.randomBoolean());
            citizen.setActivity(MOVING_RANDOMLY);
            citizen.setActivityTime(MathUtils.random(2f));
        }
    }

    private void handleMovingRandomlyActivity(Citizen citizen, float delta) {
        float activityTime = citizen.getActivityTime() - delta;
        citizen.setActivityTime(activityTime);
        if (activityTime <= 0f) {
            citizen.setAnimationTime(0f);
            citizen.setActivity(IDLE);
            citizen.setActivityTime(MathUtils.random(0.5f, 7f));
            return;
        }
        float translation = citizen.isFacingLeft() ? -CITIZEN_SPEED : CITIZEN_SPEED;
        citizen.translateX(translation * delta);
        if (citizen.getX() >= CITIZEN_MAX_X) {
            citizen.setX(CITIZEN_MAX_X);
            citizen.setFacingLeft(!citizen.isFacingLeft());
        }
        if (citizen.getX() <= CITIZEN_MIN_X) {
            citizen.setX(CITIZEN_MIN_X);
            citizen.setFacingLeft(!citizen.isFacingLeft());
        }
    }

    private void handleGoingToEatActivity(Citizen citizen, float delta) {
        float citizenCenter = citizen.getX() + CITIZEN_HEIGHT / 2f;
        float distance = citizenCenter - DINING_X;
        if ((citizen.isFacingLeft() && distance <= 0f) ||
                (!citizen.isFacingLeft() && distance >= 0f)) {
            int food = logic.getCookhouseHandler().getMeats();
            if (food > 0) {
                logic.getCookhouseHandler().removeMeats(1);
                citizen.setHunger(0);
                citizen.setActivity(EATING);
                citizen.setActivityTime(MathUtils.random(1f, 3f));
            } else {
                citizen.setActivity(RETURNING_FROM_EATING);
            }
            citizen.setAnimationTime(0f);
            return;
        }
        float translation = citizen.isFacingLeft() ? -CITIZEN_SPEED : CITIZEN_SPEED;
        citizen.translateX(translation * delta);
    }

    private void handleEatingActivity(Citizen citizen, float delta) {
        float activityTime = citizen.getActivityTime() - delta;
        citizen.setActivityTime(activityTime);
        if (activityTime <= 0f) {
            citizen.setAnimationTime(0f);
            citizen.setActivity(RETURNING_FROM_EATING);
            citizen.setFacingLeft((citizen.getXBeforeActivity() < citizen.getCenterX()));
        }
    }

    private void handleReturningFromEating(Citizen citizen, float delta) {
        float citizenCenter = citizen.getX() + CITIZEN_HEIGHT / 2f;
        float distance = citizenCenter - citizen.getXBeforeActivity();
        if ((citizen.isFacingLeft() && distance <= 0f) ||
                (!citizen.isFacingLeft() && distance >= 0f)) {
            citizen.setAnimationTime(0f);
            citizen.setActivity(IDLE);
            citizen.setActivityTime(MathUtils.random(0.5f, 7f));
            return;
        }
        float translation = citizen.isFacingLeft() ? -CITIZEN_SPEED : CITIZEN_SPEED;
        citizen.translateX(translation * delta);
    }

    private void handleGoingToExpeditionActivity(Citizen citizen, float delta) {
        float activityTime = citizen.getActivityTime() - delta;
        citizen.setActivityTime(activityTime);
        float progress = MathUtils.map(GOING_TO_EXPEDITION_TIME, 0f, 0f, 1f, activityTime);
        float lerpValue = Interpolation.pow5In.apply(progress);
        citizen.setColor(Color.SKY.cpy().lerp(Color.CLEAR, lerpValue));
        citizen.translateX(CITIZEN_SPEED * delta);
        if (activityTime <= 0f) {
            citizen.setXBeforeActivity(citizen.getX());
            citizen.setAnimationTime(0f);
            citizen.setActivity(ON_EXPEDITION);
        }
    }

    private void handleReturningFromExpeditionActivity(Citizen citizen, float delta) {
        float activityTime = citizen.getActivityTime() - delta;
        citizen.setActivityTime(activityTime);
        float progress = MathUtils.map(RETURNING_FROM_EXPEDITION_TIME, 0f, 0f, 1f, activityTime);
        float lerpValue = Interpolation.pow5Out.apply(progress);
        citizen.setColor(Color.CLEAR.cpy().lerp(Color.WHITE, lerpValue));
        citizen.translateX(-CITIZEN_SPEED * delta);
        if (activityTime <= 0f) {
            citizen.setAnimationTime(0f);
            citizen.setActivity(IDLE);
            citizen.setActivityTime(MathUtils.random(0.5f, 7f));
        }
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}