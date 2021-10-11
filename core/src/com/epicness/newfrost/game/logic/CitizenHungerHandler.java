package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

import static com.epicness.newfrost.game.GameConstants.DINING_X;
import static com.epicness.newfrost.game.enums.CitizenActivity.GOING_TO_EAT;

public class CitizenHungerHandler {

    private GameStuff stuff;

    public void addHunger() {
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        for (int i = 0; i < citizens.size; i++) {
            Citizen citizen = citizens.get(i);
            switch (citizen.getActivity()) {
                case EATING:
                case GOING_TO_EXPEDITION:
                case ON_EXPEDITION:
                case RETURNING_FROM_EXPEDITION:
                case DYING:
                    continue;
            }
            int hunger = Math.min(citizen.getHunger() + 1, 2);
            citizen.setHunger(hunger);
            checkHunger(citizen);
        }
    }

    public void checkHunger(Citizen citizen) {
        if (citizen.getHunger() == 2) {
            goToEat(citizen);
        }
    }

    private void goToEat(Citizen citizen) {
        citizen.setXBeforeActivity(citizen.getX());
        citizen.setActivity(GOING_TO_EAT);
        citizen.setFacingLeft(DINING_X < citizen.getCenterX());
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}