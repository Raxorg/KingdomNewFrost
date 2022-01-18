package com.epicness.newfrost.menu;

import static com.epicness.newfrost.menu.MenuConstants.MENU_BACKGROUND_PATH;
import static com.epicness.newfrost.menu.MenuConstants.START_BUTTON_PATH;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class MenuAssets extends Assets {

    private Sprite background;
    private Sprite playButton;

    @Override
    public void queueAssetLoading() {
        loadTexture(MENU_BACKGROUND_PATH);
        loadTexture(START_BUTTON_PATH);
    }

    @Override
    public void initializeAssets() {
        background = new Sprite(getTexture(MENU_BACKGROUND_PATH));
        playButton = new Sprite(getTexture(START_BUTTON_PATH));
    }

    public Sprite getBackground() {
        return background;
    }

    public Sprite getPlayButton() {
        return playButton;
    }
}