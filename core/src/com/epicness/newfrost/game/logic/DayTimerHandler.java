package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.DAY_DURATION;

import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.newfrost.game.stuff.GameStuff;

public class DayTimerHandler {

    // Structure
    private SharedLogic sharedLogic;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float time;

    public void init() {
        time = 0f;
        stuff.getDay().setText("DAY 1");
        stuff.getDayTimer().setText(DAY_DURATION + "");
    }

    public void update(float delta) {
        if (sharedLogic.getPauseHandler().isPaused()) {
            return;
        }
        time += delta;
        if (time >= 1f) {
            int timer = Integer.parseInt(stuff.getDayTimer().getText()) - 1;
            stuff.getDayTimer().setText(timer + "");
            logic.getDayNightCycler().updateColors(timer);
            time = 0f;
            if (timer == 0) {
                passDay();
            }
        }
    }

    public void passDay() {
        Text dayTimer = stuff.getDayTimer();
        dayTimer.setText(DAY_DURATION + "");
        String[] parts = stuff.getDay().getText().split(" ");
        int day = Integer.parseInt(parts[1]);
        stuff.getDay().setText("DAY " + (day + 1));
        logic.getCitizenHungerHandler().addHunger();
    }

    // Structure
    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}