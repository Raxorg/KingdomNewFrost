package com.epicness.newfrost.game.logic;

import com.epicness.newfrost.game.assets.GameAssets;

public class IntroHandler {

    private GameAssets assets;

    public void startMusic() {
        assets.getFrostSong().setLooping(true);
        assets.getFrostSong().setVolume(0.25f);
        assets.getFrostSong().play();
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }
}