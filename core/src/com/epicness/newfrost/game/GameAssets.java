package com.epicness.newfrost.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_PATH;
import static com.epicness.newfrost.game.GameConstants.BACKGROUND_PATH;
import static com.epicness.newfrost.game.GameConstants.CITIZEN_PATH;
import static com.epicness.newfrost.game.GameConstants.CLOUD_1_PATH;
import static com.epicness.newfrost.game.GameConstants.CLOUD_2_PATH;
import static com.epicness.newfrost.game.GameConstants.CLOUD_3_PATH;
import static com.epicness.newfrost.game.GameConstants.COOK_PATH;
import static com.epicness.newfrost.game.GameConstants.FROST_SONG_PATH;
import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_PATH;
import static com.epicness.newfrost.game.GameConstants.MEAT_PATH;
import static com.epicness.newfrost.game.GameConstants.PIXEL_FONT_PATH;
import static com.epicness.newfrost.game.GameConstants.TECH_ICON_0_PATH;
import static com.epicness.newfrost.game.GameConstants.TECH_ICON_1_PATH;
import static com.epicness.newfrost.game.GameConstants.TECH_ICON_2_PATH;
import static com.epicness.newfrost.game.GameConstants.TECH_ICON_3_PATH;
import static com.epicness.newfrost.game.GameConstants.TENT_PATH;
import static com.epicness.newfrost.game.GameConstants.TENT_UPGRADE_PATH;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_PATH;

public class GameAssets extends Assets {

    // Audio
    private Music frostSong;
    // Fonts
    private BitmapFont pixelFont;
    // Sprites
    private Sprite background;
    private Sprite cloud1, cloud2, cloud3;
    private Sprite mainBuilding, cook, tent, tentUpgrade;
    private Sprite meat;
    private Sprite techIcon0, techIcon1, techIcon2, techIcon3;
    private Sprite citizen;
    private Sprite actionIcon, tipIcon;

    @Override
    public void queueAssetLoading() {
        // Audio
        assetManager.load(FROST_SONG_PATH, Music.class);
        // Fonts
        assetManager.load(PIXEL_FONT_PATH, BitmapFont.class);
        // Sprites
        assetManager.load(BACKGROUND_PATH, Texture.class);
        assetManager.load(CLOUD_1_PATH, Texture.class);
        assetManager.load(CLOUD_2_PATH, Texture.class);
        assetManager.load(CLOUD_3_PATH, Texture.class);
        assetManager.load(MAIN_BUILDING_PATH, Texture.class);
        assetManager.load(COOK_PATH, Texture.class);
        assetManager.load(TENT_PATH, Texture.class);
        assetManager.load(TENT_UPGRADE_PATH, Texture.class);
        assetManager.load(MEAT_PATH, Texture.class);
        assetManager.load(TECH_ICON_0_PATH, Texture.class);
        assetManager.load(TECH_ICON_1_PATH, Texture.class);
        assetManager.load(TECH_ICON_2_PATH, Texture.class);
        assetManager.load(TECH_ICON_3_PATH, Texture.class);
        assetManager.load(CITIZEN_PATH, Texture.class);
        assetManager.load(ACTION_ICON_PATH, Texture.class);
        assetManager.load(TIP_ICON_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        // Audio
        frostSong = assetManager.get(FROST_SONG_PATH, Music.class);
        // Fonts
        pixelFont = assetManager.get(PIXEL_FONT_PATH, BitmapFont.class);
        pixelFont.getData().setScale(4f);
        // Sprites
        background = new Sprite(assetManager.get(BACKGROUND_PATH, Texture.class));
        cloud1 = new Sprite(assetManager.get(CLOUD_1_PATH, Texture.class));
        cloud2 = new Sprite(assetManager.get(CLOUD_2_PATH, Texture.class));
        cloud3 = new Sprite(assetManager.get(CLOUD_3_PATH, Texture.class));
        mainBuilding = new Sprite(assetManager.get(MAIN_BUILDING_PATH, Texture.class));
        cook = new Sprite(assetManager.get(COOK_PATH, Texture.class));
        tent = new Sprite(assetManager.get(TENT_PATH, Texture.class));
        tentUpgrade = new Sprite(assetManager.get(TENT_UPGRADE_PATH, Texture.class));
        meat = new Sprite(assetManager.get(MEAT_PATH, Texture.class));
        techIcon0 = new Sprite(assetManager.get(TECH_ICON_0_PATH, Texture.class));
        techIcon1 = new Sprite(assetManager.get(TECH_ICON_1_PATH, Texture.class));
        techIcon2 = new Sprite(assetManager.get(TECH_ICON_2_PATH, Texture.class));
        techIcon3 = new Sprite(assetManager.get(TECH_ICON_3_PATH, Texture.class));
        citizen = new Sprite(assetManager.get(CITIZEN_PATH, Texture.class));
        actionIcon = new Sprite(assetManager.get(ACTION_ICON_PATH, Texture.class));
        tipIcon = new Sprite(assetManager.get(TIP_ICON_PATH, Texture.class));
    }

    // Audio
    public Music getFrostSong() {
        return frostSong;
    }

    // Fonts
    public BitmapFont getPixelFont() {
        return pixelFont;
    }

    // Sprites
    public Sprite getBackground() {
        return background;
    }

    public Sprite getCloud1() {
        return cloud1;
    }

    public Sprite getCloud2() {
        return cloud2;
    }

    public Sprite getCloud3() {
        return cloud3;
    }

    public Sprite getMainBuilding() {
        return mainBuilding;
    }

    public Sprite getCook() {
        return cook;
    }

    public Sprite getTent() {
        return tent;
    }

    public Sprite getTentUpgrade() {
        return tentUpgrade;
    }

    public Sprite getMeat() {
        return meat;
    }

    public Sprite getTechIcon0() {
        return techIcon0;
    }

    public Sprite getTechIcon1() {
        return techIcon1;
    }

    public Sprite getTechIcon2() {
        return techIcon2;
    }

    public Sprite getTechIcon3() {
        return techIcon3;
    }

    public Sprite getCitizen() {
        return citizen;
    }

    public Sprite getActionIcon() {
        return actionIcon;
    }

    public Sprite getTipIcon() {
        return tipIcon;
    }
}