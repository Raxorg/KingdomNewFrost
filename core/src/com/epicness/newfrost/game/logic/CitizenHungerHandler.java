package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.people.Citizen;
import com.epicness.newfrost.game.stuff.GameStuff;

import static com.epicness.newfrost.game.enums.CitizenActivity.GOING_TO_EAT;

public class CitizenHungerHandler {

    private GameStuff stuff;

    public void checkHunger() {
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        for (int i = 0; i < citizens.size; i++) {

        }
    }

    private void goToEat(Citizen citizen) {
        citizen.setXBeforeActivity(citizen.getX());
        citizen.setActivity(GOING_TO_EAT);
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}