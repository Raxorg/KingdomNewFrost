package com.epicness.newfrost.intro;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.epicness.newfrost.intro.IntroConstants.NARRATION_PATH;
import static com.epicness.newfrost.intro.IntroConstants.PIXEL_FONT_PATH;
import static com.epicness.newfrost.intro.IntroConstants.SNOWFLAKE_PATH;

public class IntroAssets extends Assets {

    // Audio
    private Music narration;
    // Fonts
    private BitmapFont pixelFont;
    // Sprites
    private Sprite snowflake;

    @Override
    public void queueAssetLoading() {
        assetManager.load(NARRATION_PATH, Music.class);
        assetManager.load(PIXEL_FONT_PATH, BitmapFont.class);
        assetManager.load(SNOWFLAKE_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        // Audio
        narration = assetManager.get(NARRATION_PATH, Music.class);
        // Fonts
        pixelFont = assetManager.get(PIXEL_FONT_PATH, BitmapFont.class);
        pixelFont.getData().setScale(8f);
        // Sprites
        snowflake = new Sprite(assetManager.get(SNOWFLAKE_PATH, Texture.class));
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