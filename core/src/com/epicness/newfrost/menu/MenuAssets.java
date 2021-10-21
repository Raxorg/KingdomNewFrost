package com.epicness.newfrost.menu;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.epicness.newfrost.menu.MenuConstants.MENU_BACKGROUND_PATH;
import static com.epicness.newfrost.menu.MenuConstants.START_BUTTON_PATH;

public class MenuAssets extends Assets {

    private Sprite background;
    private Sprite playButton;

    @Override
    public void queueAssetLoading() {
        assetManager.load(MENU_BACKGROUND_PATH, Texture.class);
        assetManager.load(START_BUTTON_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        background = new Sprite(assetManager.get(MENU_BACKGROUND_PATH, Texture.class));
        playButton = new Sprite(assetManager.get(START_BUTTON_PATH, Texture.class));
    }

    public Sprite getBackground() {
        return background;
    }

    public Sprite getPlayButton() {
        return playButton;
    }
}