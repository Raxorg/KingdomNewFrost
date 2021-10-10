package com.epicness.newfrost.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.epicness.newfrost.menu.MenuConstants.PLAY_BUTTON_PATH;

public class MenuAssets extends Assets {

    private Sprite playButton;

    @Override
    public void queueAssetLoading() {
        assetManager.load(PLAY_BUTTON_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        playButton = new Sprite(assetManager.get(PLAY_BUTTON_PATH, Texture.class));
    }

    public Sprite getPlayButton() {
        return playButton;
    }
}