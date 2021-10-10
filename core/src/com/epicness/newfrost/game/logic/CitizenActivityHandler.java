package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

import static com.epicness.newfrost.game.GameConstants.CITIZEN_MAX_X;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_MIN_X;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_SIZE;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_SPEED;
import static com.epicness.newfrost.game.enums.CitizenActivity.EATING;
import static com.epicness.newfrost.game.enums.CitizenActivity.IDLE;
import static com.epicness.newfrost.game.enums.CitizenActivity.MOVING_RANDOMLY;
import static com.epicness.newfrost.game.enums.CitizenActivity.ON_EXPEDITION;

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
                    handleEatingActivity(citizen, delta);
                    break;
                case RETURNING_FROM_EATING:
                    break;
                case GOING_TO_EXPEDITION:
                    handleGoingToExpeditionActivity(citizen, delta);
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
            citizen.setFacingLeft(MathUtils.randomBoolean());
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
            citizen.setFacingLeft(!citizen.isFacingLeft());
        }
        if (citizen.getX() <= CITIZEN_MIN_X) {
            citizen.setX(CITIZEN_MIN_X);
            citizen.setFacingLeft(!citizen.isFacingLeft());
        }
    }

    private void handleGoingToEatActivity(Citizen citizen, float delta) {
        float citizenCenter = citizen.getX() + CITIZEN_SIZE / 2f;
        float diningTableCenter = stuff.getDiningTable().getX() + stuff.getDiningTable().getWidth() / 2f;
        float distance = Math.abs(citizenCenter - diningTableCenter);
        if (distance <= CITIZEN_SPEED * delta) {
            citizen.setActivity(EATING);
            citizen.setActivityTime(MathUtils.random(1f, 2f));
            return;
        }
        float translation = citizen.isFacingLeft() ? -CITIZEN_SPEED : CITIZEN_SPEED;
        citizen.translateX(translation * delta);
    }

    private void handleEatingActivity(Citizen citizen, float delta) {

    }

    private void handleGoingToExpeditionActivity(Citizen citizen, float delta) {
        float activityTime = citizen.getActivityTime() - delta;
        float progress = MathUtils.map(2.5f, 0f, 0f, 1f, activityTime);
        float lerpValue = Interpolation.pow5In.apply(progress);
        citizen.setColor(Color.GREEN.cpy().lerp(Color.CLEAR, lerpValue));
        if (activityTime <= 0f) {
            citizen.setActivity(ON_EXPEDITION);
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}