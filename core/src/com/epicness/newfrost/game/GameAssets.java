package com.epicness.newfrost.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
import static com.epicness.newfrost.game.GameConstants.CRAFTING_PATH;
import static com.epicness.newfrost.game.GameConstants.DYING_CITIZEN_0_PATH;
import static com.epicness.newfrost.game.GameConstants.DYING_CITIZEN_1_PATH;
import static com.epicness.newfrost.game.GameConstants.DYING_CITIZEN_2_PATH;
import static com.epicness.newfrost.game.GameConstants.DYING_CITIZEN_3_PATH;
import static com.epicness.newfrost.game.GameConstants.FROST_SONG_PATH;
import static com.epicness.newfrost.game.GameConstants.GLASS_ICON_PATH;
import static com.epicness.newfrost.game.GameConstants.IDLE_CITIZEN_0_PATH;
import static com.epicness.newfrost.game.GameConstants.IDLE_CITIZEN_1_PATH;
import static com.epicness.newfrost.game.GameConstants.IDLE_GOVERNOR_0_PATH;
import static com.epicness.newfrost.game.GameConstants.IDLE_GOVERNOR_1_PATH;
import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_PATH;
import static com.epicness.newfrost.game.GameConstants.MEAT_ICON_PATH;
import static com.epicness.newfrost.game.GameConstants.MEAT_PATH;
import static com.epicness.newfrost.game.GameConstants.PIXEL_FONT_PATH;
import static com.epicness.newfrost.game.GameConstants.TECH_ICON_0_PATH;
import static com.epicness.newfrost.game.GameConstants.TECH_ICON_1_PATH;
import static com.epicness.newfrost.game.GameConstants.TECH_ICON_2_PATH;
import static com.epicness.newfrost.game.GameConstants.TECH_ICON_3_PATH;
import static com.epicness.newfrost.game.GameConstants.TENT_PATH;
import static com.epicness.newfrost.game.GameConstants.TENT_UPGRADE_PATH;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_CITIZEN_0_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_CITIZEN_1_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_CITIZEN_2_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_CITIZEN_3_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_CITIZEN_4_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_CITIZEN_5_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_CITIZEN_6_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_CITIZEN_7_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_0_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_1_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_2_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_3_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_4_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_5_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_6_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_7_PATH;
import static com.epicness.newfrost.game.GameConstants.WALKING_GOVERNOR_8_PATH;
import static com.epicness.newfrost.game.GameConstants.WOOD_FRAME_PATH;

public class GameAssets extends Assets {

    // Audio
    private Music frostSong;
    private Sound crafting;
    // Fonts
    private BitmapFont pixelFont;
    // Sprites
    private Sprite background;
    private Sprite cloud1, cloud2, cloud3;
    private Sprite mainBuilding, cook, tent, tentUpgrade;
    private Sprite meat;
    private Sprite techIcon0, techIcon1, techIcon2, techIcon3;
    private Sprite citizen;
    private Sprite idleCitizen0, idleCitizen1;
    private Sprite walkingCitizen0, walkingCitizen1, walkingCitizen2, walkingCitizen3, walkingCitizen4,
            walkingCitizen5, walkingCitizen6, walkingCitizen7;
    private Sprite dyingCitizen0, dyingCitizen1, dyingCitizen2, dyingCitizen3;
    private Sprite idleGovernor0, idleGovernor1;
    private Sprite walkingGovernor0, walkingGovernor1, walkingGovernor2, walkingGovernor3, walkingGovernor4,
            walkingGovernor5, walkingGovernor6, walkingGovernor7, walkingGovernor8;
    private Sprite actionIcon, tipIcon, woodFrame, meatIcon, glassIcon;

    @Override
    public void queueAssetLoading() {
        // Audio
        assetManager.load(FROST_SONG_PATH, Music.class);
        assetManager.load(CRAFTING_PATH, Sound.class);
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

        assetManager.load(IDLE_CITIZEN_0_PATH, Texture.class);
        assetManager.load(IDLE_CITIZEN_1_PATH, Texture.class);

        assetManager.load(WALKING_CITIZEN_0_PATH, Texture.class);
        assetManager.load(WALKING_CITIZEN_1_PATH, Texture.class);
        assetManager.load(WALKING_CITIZEN_2_PATH, Texture.class);
        assetManager.load(WALKING_CITIZEN_3_PATH, Texture.class);
        assetManager.load(WALKING_CITIZEN_4_PATH, Texture.class);
        assetManager.load(WALKING_CITIZEN_5_PATH, Texture.class);
        assetManager.load(WALKING_CITIZEN_6_PATH, Texture.class);
        assetManager.load(WALKING_CITIZEN_7_PATH, Texture.class);

        assetManager.load(DYING_CITIZEN_0_PATH, Texture.class);
        assetManager.load(DYING_CITIZEN_1_PATH, Texture.class);
        assetManager.load(DYING_CITIZEN_2_PATH, Texture.class);
        assetManager.load(DYING_CITIZEN_3_PATH, Texture.class);

        assetManager.load(IDLE_GOVERNOR_0_PATH, Texture.class);
        assetManager.load(IDLE_GOVERNOR_1_PATH, Texture.class);

        assetManager.load(WALKING_GOVERNOR_0_PATH, Texture.class);
        assetManager.load(WALKING_GOVERNOR_1_PATH, Texture.class);
        assetManager.load(WALKING_GOVERNOR_2_PATH, Texture.class);
        assetManager.load(WALKING_GOVERNOR_3_PATH, Texture.class);
        assetManager.load(WALKING_GOVERNOR_4_PATH, Texture.class);
        assetManager.load(WALKING_GOVERNOR_5_PATH, Texture.class);
        assetManager.load(WALKING_GOVERNOR_6_PATH, Texture.class);
        assetManager.load(WALKING_GOVERNOR_7_PATH, Texture.class);
        assetManager.load(WALKING_GOVERNOR_8_PATH, Texture.class);

        assetManager.load(ACTION_ICON_PATH, Texture.class);
        assetManager.load(TIP_ICON_PATH, Texture.class);
        assetManager.load(WOOD_FRAME_PATH, Texture.class);
        assetManager.load(MEAT_ICON_PATH, Texture.class);
        assetManager.load(GLASS_ICON_PATH, Texture.class);
    }

    @Override
    public void initializeAssets() {
        // Audio
        frostSong = assetManager.get(FROST_SONG_PATH, Music.class);
        crafting = assetManager.get(CRAFTING_PATH, Sound.class);
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

        idleCitizen0 = new Sprite(assetManager.get(IDLE_CITIZEN_0_PATH, Texture.class));
        idleCitizen1 = new Sprite(assetManager.get(IDLE_CITIZEN_1_PATH, Texture.class));

        walkingCitizen0 = new Sprite(assetManager.get(WALKING_CITIZEN_0_PATH, Texture.class));
        walkingCitizen1 = new Sprite(assetManager.get(WALKING_CITIZEN_1_PATH, Texture.class));
        walkingCitizen2 = new Sprite(assetManager.get(WALKING_CITIZEN_2_PATH, Texture.class));
        walkingCitizen3 = new Sprite(assetManager.get(WALKING_CITIZEN_3_PATH, Texture.class));
        walkingCitizen4 = new Sprite(assetManager.get(WALKING_CITIZEN_4_PATH, Texture.class));
        walkingCitizen5 = new Sprite(assetManager.get(WALKING_CITIZEN_5_PATH, Texture.class));
        walkingCitizen6 = new Sprite(assetManager.get(WALKING_CITIZEN_6_PATH, Texture.class));
        walkingCitizen7 = new Sprite(assetManager.get(WALKING_CITIZEN_7_PATH, Texture.class));

        dyingCitizen0 = new Sprite(assetManager.get(DYING_CITIZEN_0_PATH, Texture.class));
        dyingCitizen1 = new Sprite(assetManager.get(DYING_CITIZEN_1_PATH, Texture.class));
        dyingCitizen2 = new Sprite(assetManager.get(DYING_CITIZEN_2_PATH, Texture.class));
        dyingCitizen3 = new Sprite(assetManager.get(DYING_CITIZEN_3_PATH, Texture.class));

        idleGovernor0 = new Sprite(assetManager.get(IDLE_GOVERNOR_0_PATH, Texture.class));
        idleGovernor1 = new Sprite(assetManager.get(IDLE_GOVERNOR_1_PATH, Texture.class));

        walkingGovernor0 = new Sprite(assetManager.get(WALKING_GOVERNOR_0_PATH, Texture.class));
        walkingGovernor1 = new Sprite(assetManager.get(WALKING_GOVERNOR_1_PATH, Texture.class));
        walkingGovernor2 = new Sprite(assetManager.get(WALKING_GOVERNOR_2_PATH, Texture.class));
        walkingGovernor3 = new Sprite(assetManager.get(WALKING_GOVERNOR_3_PATH, Texture.class));
        walkingGovernor4 = new Sprite(assetManager.get(WALKING_GOVERNOR_4_PATH, Texture.class));
        walkingGovernor5 = new Sprite(assetManager.get(WALKING_GOVERNOR_5_PATH, Texture.class));
        walkingGovernor6 = new Sprite(assetManager.get(WALKING_GOVERNOR_6_PATH, Texture.class));
        walkingGovernor7 = new Sprite(assetManager.get(WALKING_GOVERNOR_7_PATH, Texture.class));
        walkingGovernor8 = new Sprite(assetManager.get(WALKING_GOVERNOR_8_PATH, Texture.class));

        actionIcon = new Sprite(assetManager.get(ACTION_ICON_PATH, Texture.class));
        tipIcon = new Sprite(assetManager.get(TIP_ICON_PATH, Texture.class));
        woodFrame = new Sprite(assetManager.get(WOOD_FRAME_PATH, Texture.class));
        meatIcon = new Sprite(assetManager.get(MEAT_ICON_PATH, Texture.class));
        glassIcon = new Sprite(assetManager.get(GLASS_ICON_PATH, Texture.class));
    }

    // Audio
    public Music getFrostSong() {
        return frostSong;
    }

    public Sound getCrafting() {
        return crafting;
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

    public Sprite getIdleCitizen0() {
        return idleCitizen0;
    }

    public Sprite getIdleCitizen1() {
        return idleCitizen1;
    }

    public Sprite getWalkingCitizen0() {
        return walkingCitizen0;
    }

    public Sprite getWalkingCitizen1() {
        return walkingCitizen1;
    }

    public Sprite getWalkingCitizen2() {
        return walkingCitizen2;
    }

    public Sprite getWalkingCitizen3() {
        return walkingCitizen3;
    }

    public Sprite getWalkingCitizen4() {
        return walkingCitizen4;
    }

    public Sprite getWalkingCitizen5() {
        return walkingCitizen5;
    }

    public Sprite getWalkingCitizen6() {
        return walkingCitizen6;
    }

    public Sprite getWalkingCitizen7() {
        return walkingCitizen7;
    }

    public Sprite getDyingCitizen0() {
        return dyingCitizen0;
    }

    public Sprite getDyingCitizen1() {
        return dyingCitizen1;
    }

    public Sprite getDyingCitizen2() {
        return dyingCitizen2;
    }

    public Sprite getDyingCitizen3() {
        return dyingCitizen3;
    }

    public Sprite getIdleGovernor0() {
        return idleGovernor0;
    }

    public Sprite getIdleGovernor1() {
        return idleGovernor1;
    }

    public Sprite getWalkingGovernor0() {
        return walkingGovernor0;
    }

    public Sprite getWalkingGovernor1() {
        return walkingGovernor1;
    }

    public Sprite getWalkingGovernor2() {
        return walkingGovernor2;
    }

    public Sprite getWalkingGovernor3() {
        return walkingGovernor3;
    }

    public Sprite getWalkingGovernor4() {
        return walkingGovernor4;
    }

    public Sprite getWalkingGovernor5() {
        return walkingGovernor5;
    }

    public Sprite getWalkingGovernor6() {
        return walkingGovernor6;
    }

    public Sprite getWalkingGovernor7() {
        return walkingGovernor7;
    }

    public Sprite getWalkingGovernor8() {
        return walkingGovernor8;
    }

    public Sprite getActionIcon() {
        return actionIcon;
    }

    public Sprite getTipIcon() {
        return tipIcon;
    }

    public Sprite getWoodFrame() {
        return woodFrame;
    }

    public Sprite getMeatIcon() {
        return meatIcon;
    }

    public Sprite getGlassIcon() {
        return glassIcon;
    }
}