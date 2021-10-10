package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

public class DayHandler {

    private GameStuff stuff;
    // Logic
    private float time;
    private boolean paused;

    public void update(float delta) {
        if (paused) {
            return;
        }
        time += delta;
        if (time == 60f) {
            passDay();
        }
    }

    public void passDay() {
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        for (int i = 0; i < citizens.size; i++) {
            Citizen citizen = citizens.get(i);
            citizen.setHunger(citizen.getHunger() + 1);
        }
        time = 0f;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}