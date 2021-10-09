package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.Citizen;
import com.epicness.newfrost.game.stuff.GameStuff;

import static com.epicness.newfrost.game.CitizenActivity.IDLE;
import static com.epicness.newfrost.game.CitizenActivity.MOVING_RANDOMLY;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_MAX_X;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_MIN_X;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_SPEED;

public class CitizenActivityHandler {

    private GameStuff stuff;

    public void update(float delta) {
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        for (int i = 0; i < citizens.size; i++) {
            Citizen citizen = citizens.get(i);
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
                    break;
                case GOING_TO_EXPEDITION:
                    break;
                case ON_EXPEDITION:
                    break;
                case DYING:
                    break;
            }
        }
    }

    private void handleIdleActivity(Citizen citizen, float delta) {
        float activityTime = citizen.getActivityTime() - delta;
        citizen.setActivityTime(activityTime);
        if (activityTime <= 0f) {
            citizen.setFacingDirection(MathUtils.randomBoolean());
            citizen.setActivity(MOVING_RANDOMLY);
            citizen.setActivityTime(MathUtils.random(2f));
        }
    }

    private void handleMovingRandomlyActivity(Citizen citizen, float delta) {
        float activityTime = citizen.getActivityTime() - delta;
        citizen.setActivityTime(activityTime);
        if (activityTime <= 0f) {
            citizen.setActivity(IDLE);
            citizen.setActivityTime(MathUtils.random(4f));
            return;
        }
        float translation = citizen.isFacingLeft() ? -CITIZEN_SPEED : CITIZEN_SPEED;
        citizen.translateX(translation * delta);
        if (citizen.getX() >= CITIZEN_MAX_X) {
            citizen.setX(CITIZEN_MAX_X);
            citizen.setFacingDirection(!citizen.isFacingLeft());
        }
        if (citizen.getX() <= CITIZEN_MIN_X) {
            citizen.setX(CITIZEN_MIN_X);
            citizen.setFacingDirection(!citizen.isFacingLeft());
        }
    }

    private void handleGoingToEatActivity(Citizen citizen, float delta) {

    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}