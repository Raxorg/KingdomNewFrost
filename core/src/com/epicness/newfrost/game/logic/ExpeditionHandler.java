package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

import java.util.ArrayList;

import static com.epicness.newfrost.game.enums.CitizenActivity.GOING_TO_EXPEDITION;

public class ExpeditionHandler {

    private GameStuff stuff;

    public void sendExpedition() {
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        ArrayList<Citizen> designedCitizens = new ArrayList<>();
        for (int i = 0, designed = 0; i < citizens.size && designed < 5; i++) {
            Citizen citizen = citizens.get(i);
            switch (citizen.getActivity()) {
                case IDLE:
                case MOVING_RANDOMLY:
                case RETURNING_FROM_EATING:
                    designedCitizens.add(citizen);
                    designed++;
                    break;
                case GOING_TO_EAT:
                case EATING:
                case GOING_TO_EXPEDITION:
                case ON_EXPEDITION:
                case DYING:
                    break;
            }
        }
        for (int i = 0; i < designedCitizens.size(); i++) {
            Citizen citizen = designedCitizens.get(i);
            citizen.setActivity(GOING_TO_EXPEDITION);
            citizen.setColor(Color.GREEN);
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}