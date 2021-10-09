package com.epicness.newfrost.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.epicness.newfrost.game.GameConstants.CITIZEN_PATH;

public class GameAssets extends Assets {

    // Sprites
    private Sprite citizen;

    @Override
    public void queueAssetLoading() {
        assetManager.load(CITIZEN_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        citizen = new Sprite(assetManager.get(CITIZEN_PATH, Texture.class));
    }

    public Sprite getCitizen() {
        return citizen;
    }
}