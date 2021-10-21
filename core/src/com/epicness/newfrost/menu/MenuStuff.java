package com.epicness.newfrost.menu;

import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.newfrost.menu.MenuConstants.START_BUTTON_WIDTH;
import static com.epicness.newfrost.menu.MenuConstants.START_BUTTON_X;

public class MenuStuff extends Stuff {

    private Sprited background, playButton;

    @Override
    public void initializeStuff() {
        MenuAssets assets = (MenuAssets) this.assets;

        background = new Sprited(assets.getBackground());
        background.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        playButton = new Sprited(assets.getPlayButton());
        playButton.setPosition(START_BUTTON_X, CAMERA_HEIGHT / 3f);
        playButton.setSize(START_BUTTON_WIDTH, 100f);
    }

    public Sprited getBackground() {
        return background;
    }

    public Sprited getPlayButton() {
        return playButton;
    }
}