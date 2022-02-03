package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.EXPEDITION_DURATION;
import static com.epicness.newfrost.game.GameConstants.EXPEDITION_INFO_X;
import static com.epicness.newfrost.game.GameConstants.EXPEDITION_INFO_Y;
import static com.epicness.newfrost.game.GameConstants.GOING_TO_EXPEDITION_TIME;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.RETURNING_FROM_EXPEDITION_TIME;
import static com.epicness.newfrost.game.enums.CitizenActivity.GOING_TO_EXPEDITION;
import static com.epicness.newfrost.game.enums.CitizenActivity.RETURNING_FROM_EXPEDITION;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;
import com.epicness.newfrost.game.stuff.resourceinfos.ExpeditionInfo;

import java.util.ArrayList;

public class ExpeditionHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float goingToExpeditionTime;
    private boolean ongoingExpedition, goingToExpedition;
    private ArrayList<Citizen> designatedCitizens;
    private boolean food;

    public void sendExpedition(boolean food) {
        if (ongoingExpedition) {
            return;
        }
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        designatedCitizens = new ArrayList<>();
        for (int i = 0, designed = 0; i < citizens.size && designed < 5; i++) {
            Citizen citizen = citizens.get(i);
            switch (citizen.getActivity()) {
                case IDLE:
                case MOVING_RANDOMLY:
                case RETURNING_FROM_EATING:
                    designatedCitizens.add(citizen);
                    designed++;
                    break;
                case RETURNING_FROM_EXPEDITION:
                case GOING_TO_EAT:
                case EATING:
                case GOING_TO_EXPEDITION:
                case ON_EXPEDITION:
                case DYING:
                    break;
            }
        }
        for (int i = 0; i < designatedCitizens.size(); i++) {
            Citizen citizen = designatedCitizens.get(i);
            citizen.setActivity(GOING_TO_EXPEDITION);
            citizen.setFacingLeft(false);
            citizen.setActivityTime(GOING_TO_EXPEDITION_TIME);
        }
        logic.getMainBuildingMenuHandler().hideMenu();

        stuff.getExpeditionInfo().setTime(EXPEDITION_DURATION);
        ongoingExpedition = true;
        goingToExpedition = true;
        showExpeditionInfo();
        this.food = food;
    }

    public void update(float delta) {
        if (!ongoingExpedition) {
            return;
        }
        if (goingToExpedition) {
            goingToExpeditionTime += delta;
            if (goingToExpeditionTime >= GOING_TO_EXPEDITION_TIME) {
                goingToExpedition = false;
            }
        }
        advanceExpedition(delta);
    }

    private void advanceExpedition(float delta) {
        ExpeditionInfo expeditionInfo = stuff.getExpeditionInfo();
        expeditionInfo.setTime(expeditionInfo.getTime() - delta);
        if (expeditionInfo.getTime() <= 0f) {
            expeditionInfo.setTime(0f);
            hideExpeditionInfo();
            ongoingExpedition = false;
            if (food) {
                logic.getCookhouseHandler().addMeats(5);
                logic.getCitizenHungerHandler().checkHunger();
            } else {
                logic.getWarehouseHandler().addLogs(10);
            }
            for (int i = 0; i < designatedCitizens.size(); i++) {
                Citizen citizen = designatedCitizens.get(i);
                citizen.setActivityTime(RETURNING_FROM_EXPEDITION_TIME);
                citizen.setActivity(RETURNING_FROM_EXPEDITION);
                citizen.setFacingLeft(true);
            }
        }
    }

    public void hideExpeditionInfo() {
        stuff.getExpeditionInfo().setPosition(HIDDEN_X, HIDDEN_Y);
    }

    private void showExpeditionInfo() {
        ExpeditionInfo expeditionInfo = stuff.getExpeditionInfo();
        expeditionInfo.setPosition(EXPEDITION_INFO_X, EXPEDITION_INFO_Y);
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}