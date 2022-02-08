package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.PLAYER_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.PLAYER_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.VANISHING_LOG_FINAL_Y;
import static com.epicness.newfrost.game.GameConstants.VANISHING_LOG_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_COLOR;

import com.badlogic.gdx.graphics.Color;
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
        Sprited log = stuff.getVanishingLog();
        float x = stuff.getPlayer().getCenterX() - log.getWidth() / 2f;
        log.setX(x);
        log.setY(PLAYER_STARTING_Y + PLAYER_HEIGHT);
        log.setColor(WAREHOUSE_LOG_COLOR);
    }

    public void update(float delta) {
        if (!fading) {
            return;
        }
        time += delta;
        Sprited log = stuff.getVanishingLog();
        time = Math.min(time, 1f);
        log.setY(MathUtils.lerp(VANISHING_LOG_STARTING_Y, VANISHING_LOG_FINAL_Y, time));
        log.setColor(WAREHOUSE_LOG_COLOR.cpy().lerp(Color.CLEAR, time));
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