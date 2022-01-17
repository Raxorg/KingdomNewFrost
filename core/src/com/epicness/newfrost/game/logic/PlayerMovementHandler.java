package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.PLAYER_MAX_X;
import static com.epicness.newfrost.game.GameConstants.PLAYER_MIN_X;
import static com.epicness.newfrost.game.GameConstants.PLAYER_SPEED;

import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Player;

public class PlayerMovementHandler {

    private GameStuff stuff;

    public void update(float delta) {
        Player player = stuff.getPlayer();
        player.translateX(player.getSpeed() * delta);
        checkPlayerLimits(player);
        player.setAnimationTime(player.getAnimationTime() + delta);
    }

    private void checkPlayerLimits(Player player) {
        float difference = player.getX() - PLAYER_MAX_X;
        if (difference > 0f) {
            player.translateX(-difference);
        }
        difference = player.getX() - PLAYER_MIN_X;
        if (difference < 0f) {
            player.translateX(-difference);
        }
    }

    public void aPress() {
        Player player = stuff.getPlayer();
        player.setSpeed(player.getSpeed() - PLAYER_SPEED);
        if (player.getSpeed() < 0f) {
            player.setFacingLeft(true);
        }
    }

    public void dPress() {
        Player player = stuff.getPlayer();
        player.setSpeed(player.getSpeed() + PLAYER_SPEED);
        if (player.getSpeed() > 0f) {
            player.setFacingLeft(false);
        }
    }

    public void aRelease() {
        Player player = stuff.getPlayer();
        player.setSpeed(player.getSpeed() + PLAYER_SPEED);
        if (player.getSpeed() > 0f) {
            player.setFacingLeft(false);
        }
    }

    public void dRelease() {
        Player player = stuff.getPlayer();
        player.setSpeed(player.getSpeed() - PLAYER_SPEED);
        if (player.getSpeed() < 0f) {
            player.setFacingLeft(true);
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}