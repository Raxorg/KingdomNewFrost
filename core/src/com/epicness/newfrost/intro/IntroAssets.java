package com.epicness.newfrost.intro;

import static com.epicness.newfrost.intro.IntroConstants.NARRATION_PATH;
import static com.epicness.newfrost.intro.IntroConstants.PIXEL_FONT_PATH;
import static com.epicness.newfrost.intro.IntroConstants.SNOWFLAKE_PATH;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class IntroAssets extends Assets {

    // Audio
    private Music narration;
    // Fonts
    private BitmapFont pixelFont;
    // Sprites
    private Sprite snowflake;

    @Override
    public void queueAssetLoading() {
        loadMusic(NARRATION_PATH);
        loadFont(PIXEL_FONT_PATH);
        loadTexture(SNOWFLAKE_PATH);
    }

    @Override
    public void initializeAssets() {
        // Audio
        narration = getMusic(NARRATION_PATH);
        // Fonts
        pixelFont = getFont(PIXEL_FONT_PATH);
        pixelFont.getData().setScale(8f);
        // Sprites
        snowflake = new Sprite(getTexture(SNOWFLAKE_PATH));
    }

    // Audio
    public Music getNarration() {
        return narration;
    }

    // Fonts
    public BitmapFont getPixelFont() {
        return pixelFont;
    }

    // Sprites
    public Sprite getSnowflake() {
        return snowflake;
    }
}