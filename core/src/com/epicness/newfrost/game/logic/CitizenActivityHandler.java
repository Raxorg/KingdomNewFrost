package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.Citizen;
import com.epicness.newfrost.game.stuff.GameStuff;

import static com.epicness.newfrost.game.CitizenActivity.MOVING_RANDOMLY;

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
            citizen.setActivity(MOVING_RANDOMLY);
            citizen.setActivityTime(MathUtils.random(2f));
        }
    }

    private void handleMovingRandomlyActivity(Citizen citizen, float delta) {

    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}