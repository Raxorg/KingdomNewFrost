package com.epicness.newfrost.game.logic;

import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Player;

import static com.epicness.newfrost.game.GameConstants.PLAYER_SPEED;

public class PlayerMovementHandler {

    private GameStuff stuff;

    public void update(float delta) {
        Player player = stuff.getPlayer();
        player.translateX(player.getSpeed() * delta);
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