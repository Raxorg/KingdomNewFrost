package com.epicness.newfrost.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    // Assets
    public static final String FROST_SONG_PATH = "newfrost/audio/frostSong.wav";

    public static final String PIXEL_FONT_PATH = "newfrost/fonts/pixelFont.fnt";

    public static final String BACKGROUND_PATH = "newfrost/images/background.png";
    public static final String CLOUD_1_PATH = "newfrost/images/cloud1.png";
    public static final String CLOUD_2_PATH = "newfrost/images/cloud2.png";
    public static final String CLOUD_3_PATH = "newfrost/images/cloud3.png";
    public static final String MAIN_BUILDING_PATH = "newfrost/images/mainBuilding.png";
    public static final String COOK_PATH = "newfrost/images/cook.png";
    public static final String TENT_PATH = "newfrost/images/tent.png";
    public static final String TENT_UPGRADE_PATH = "newfrost/images/tentUpgrade.png";
    public static final String MEAT_PATH = "newfrost/images/meat.png";
    public static final String TECH_ICON_0_PATH = "newfrost/images/techIcon0.png";
    public static final String TECH_ICON_1_PATH = "newfrost/images/techIcon1.png";
    public static final String TECH_ICON_2_PATH = "newfrost/images/techIcon2.png";
    public static final String TECH_ICON_3_PATH = "newfrost/images/techIcon3.png";
    public static final String CITIZEN_PATH = "newfrost/images/citizen.png";
    public static final String ACTION_ICON_PATH = "newfrost/images/actionIcon.png";
    public static final String TIP_ICON_PATH = "newfrost/images/tipIcon.png";
    // Scene
    public static final float GROUND_Y = CAMERA_HEIGHT / 3f;
    // Player
    public static final float PLAYER_STARTING_X = CAMERA_WIDTH / 2f;
    public static final float PLAYER_STARTING_Y = GROUND_Y - 50f;
    public static final float PLAYER_WIDTH = 150f;
    public static final float PLAYER_HEIGHT = 200f;
    public static final float PLAYER_SPEED = 400f;
    // Citizens
    public static final float CITIZEN_SIZE = 150f;
    public static final float CITIZEN_SPEED = 100f;
    public static final float CITIZEN_MIN_X = 0f;
    public static final float CITIZEN_MAX_X = CAMERA_WIDTH - CITIZEN_SIZE;
    public static final int CITIZEN_STARTING_TEMPERATURE = 5;
    // Events
    public static final float EVENT_BACKGROUND_WIDTH = CAMERA_WIDTH / 2f;
    public static final float EVENT_BACKGROUND_HEIGHT = CAMERA_HEIGHT / 2f;
    public static final float EVENT_BACKGROUND_X = CAMERA_WIDTH / 2f - EVENT_BACKGROUND_WIDTH / 2f;
    public static final float EVENT_BACKGROUND_Y = CAMERA_HEIGHT / 2f - EVENT_BACKGROUND_HEIGHT / 2f;
    private static final float EVENT_BACKGROUND_CENTER_Y = EVENT_BACKGROUND_Y + EVENT_BACKGROUND_HEIGHT / 2f;

    public static final float EVENT_IMAGE_SIZE = EVENT_BACKGROUND_HEIGHT / 3f;
    public static final float EVENT_IMAGE_X = EVENT_BACKGROUND_X + EVENT_BACKGROUND_WIDTH - EVENT_IMAGE_SIZE;
    public static final float EVENT_IMAGE_Y = EVENT_BACKGROUND_CENTER_Y - EVENT_IMAGE_SIZE / 2f;

    public static final float EVENT_TEXT_X = EVENT_BACKGROUND_X;
    public static final float EVENT_TEXT_Y = EVENT_BACKGROUND_CENTER_Y;
    public static final float EVENT_TEXT_WIDTH = EVENT_BACKGROUND_WIDTH - EVENT_IMAGE_SIZE;

    public static final int EVENT_MAX_OPTIONS = 3;
    public static final float EVENT_OPTION_WIDTH = EVENT_BACKGROUND_WIDTH / 4f;
    public static final float EVENT_OPTION_HEIGHT = EVENT_IMAGE_SIZE / 3f;
    public static final float EVENT_OPTION_SPACING = EVENT_OPTION_WIDTH + EVENT_OPTION_WIDTH / 4f;
    public static final float EVENT_OPTION_X = EVENT_BACKGROUND_X + EVENT_OPTION_WIDTH / 4f;
    public static final float EVENT_OPTION_Y = EVENT_BACKGROUND_Y + EVENT_OPTION_HEIGHT / 2f;
    // Dialogues
    public static final float DIALOGUE_WIDTH = CAMERA_WIDTH / 2f;
    public static final float DIALOGUE_HEIGHT = CAMERA_HEIGHT / 2f;
    public static final float DIALOGUE_X = CAMERA_WIDTH / 2f - DIALOGUE_WIDTH / 2f;
    public static final float DIALOGUE_Y = CAMERA_HEIGHT / 2f - DIALOGUE_HEIGHT / 2f;
    // Buildings
    public static final float MAIN_BUILDING_HEIGHT = CAMERA_HEIGHT / 3f;
    public static final float MAIN_BUILDING_WIDTH = MAIN_BUILDING_HEIGHT * 1.5f;
    public static final float MAIN_BUILDING_X = CAMERA_WIDTH / 2f - MAIN_BUILDING_WIDTH / 2f;
    public static final float MAIN_BUILDING_Y = GROUND_Y;
    // Action icon
    public static final float ACTION_ICON_WIDTH = 100f;
    public static final float ACTION_ICON_HEIGHT = 200f;
    // Tips
    public static final float TIP_WIDTH = CAMERA_WIDTH / 2f;
    public static final float TIP_HEIGHT = CAMERA_HEIGHT / 2f;
    public static final float TIP_X = CAMERA_WIDTH / 2f - TIP_WIDTH / 2f;
    public static final float TIP_Y = CAMERA_HEIGHT / 2f - TIP_HEIGHT / 2f;

    public static final float TIP_ICON_SIZE = 100f;
    public static final float TIP_ICON_X = CAMERA_WIDTH - TIP_ICON_SIZE;
    public static final float TIP_ICON_Y = CAMERA_HEIGHT - TIP_ICON_SIZE;
    // Expedition
    public static final float EXPEDITION_ICON_SIZE = 100f;
    // Main building menu
    public static final float MAIN_MENU_X = 100f;
    public static final float MAIN_MENU_Y = 100f;
    public static final float MAIN_MENU_WIDTH = CAMERA_WIDTH - 200f;
    public static final float MAIN_MENU_HEIGHT = CAMERA_HEIGHT - 200f;
    public static final float TAB_WIDTH = 200f;
    public static final float TAB_HEIGHT = TAB_WIDTH / 3f;
    public static final float TECH_TAB_X = TAB_WIDTH;
    public static final float LAW_TAB_X = TECH_TAB_X + TAB_WIDTH;
    public static final float TAB_Y = MAIN_MENU_HEIGHT - TAB_HEIGHT;
    // Action panel
    public static final float ACTION_BUTTON_WIDTH = 400f;
    public static final float ACTION_BUTTON_HEIGHT = ACTION_BUTTON_WIDTH / 4f;

    public static final float EXPEDITION_BUTTON_X = MAIN_MENU_WIDTH / 2f - ACTION_BUTTON_WIDTH / 2f;
    public static final float EXPEDITION_BUTTON_Y = MAIN_MENU_HEIGHT / 2f - ACTION_BUTTON_HEIGHT / 2f;
    // Tech tree
    public static final int TECHNOLOGIES = 10;
    public static final float TECHNOLOGY_SIZE = 100f;
    public static final float TECHNOLOGY_SPACING = 200f;
    public static final float TECHNOLOGIES_WIDTH = 3 * TECHNOLOGY_SPACING + TECHNOLOGY_SIZE;
    public static final float TECHNOLOGIES_HEIGHT = 2 * TECHNOLOGY_SPACING + TECHNOLOGY_SIZE;
    public static final float TECHNOLOGIES_X = MAIN_MENU_WIDTH / 2f - TECHNOLOGIES_WIDTH / 2f;
    public static final float TECHNOLOGIES_Y = MAIN_MENU_HEIGHT / 2f - TECHNOLOGIES_HEIGHT / 2f;
    // Other
    public static final float HIDDEN_X = -10 * CAMERA_WIDTH;
    public static final float HIDDEN_Y = -10 * CAMERA_HEIGHT;
}