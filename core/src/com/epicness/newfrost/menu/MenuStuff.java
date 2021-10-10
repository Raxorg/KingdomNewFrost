package com.epicness.newfrost.menu;

import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class MenuStuff extends Stuff {

    private Sprited playButton;

    @Override
    public void initializeStuff() {
        MenuAssets assets = (MenuAssets) this.assets;

        playButton = new Sprited(assets.getPlayButton());
        playButton.setPosition(
                CAMERA_WIDTH / 2f - playButton.getWidth() / 2f,
                CAMERA_HEIGHT / 2f - playButton.getHeight() / 2f);
    }

    public Sprited getPlayButton() {
        return playButton;
    }
}