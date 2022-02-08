package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.PLAYER_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.PLAYER_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.VANISHING_LOG_FINAL_Y;
import static com.epicness.newfrost.game.GameConstants.VANISHING_LOG_STARTING_Y;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.stuff.GameStuff;

public class SpendingHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    private boolean fading;
    private float time;

    public void vanishLog() {
        fading = true;
        time = 0f;
        float x = stuff.getPlayer().getCenterX() - stuff.getVanishingLog().getWidth() / 2f;
        stuff.getVanishingLog().setX(x);
        stuff.getVanishingLog().setY(PLAYER_STARTING_Y + PLAYER_HEIGHT);
    }

    public void update(float delta) {
        if (!fading) {
            return;
        }
        time += delta;
        Sprited log = stuff.getVanishingLog();
        time = Math.min(time, 1f);
        log.setY(MathUtils.lerp(VANISHING_LOG_STARTING_Y, VANISHING_LOG_FINAL_Y, time));
        if (time == 1f) {
            fading = false;
            stuff.getVanishingLog().setPosition(HIDDEN_X, HIDDEN_Y);
        }
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}