package com.epicness.newfrost.game.logic;

import com.epicness.fundamentals.stuff.Text;
import com.epicness.newfrost.game.stuff.GameStuff;

import static com.epicness.newfrost.game.GameConstants.DAY_DURATION;

public class DayHandler {

    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float time;
    private boolean paused;

    public void init() {
        time = 0f;
        paused = false;
        stuff.getDay().setText("DAY 1");
        stuff.getDayTimer().setText(DAY_DURATION + "");
    }

    public void update(float delta) {
        if (paused) {
            return;
        }
        time += delta;
        if (time >= 1f) {
            int timer = Integer.parseInt(stuff.getDayTimer().getText());
            stuff.getDayTimer().setText(timer - 1 + "");
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

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}