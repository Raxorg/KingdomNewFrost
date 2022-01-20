package com.epicness.newfrost.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    // Background
    public static final float BACKGROUND_WIDTH = CAMERA_WIDTH;
    public static final float BACKGROUND_HEIGHT = CAMERA_HEIGHT;
    // Scene
    public static final float GROUND_Y = CAMERA_HEIGHT / 5f;
    // Player
    public static final float PLAYER_STARTING_X = CAMERA_WIDTH / 2f;
    public static final float PLAYER_STARTING_Y = GROUND_Y - 50f;
    public static final float PLAYER_WIDTH = 100f;
    public static final float PLAYER_HEIGHT = PLAYER_WIDTH * 2f;
    public static final float PLAYER_SPEED = 400f;
    public static final float PLAYER_MAX_X = BACKGROUND_WIDTH * 2f;
    public static final float PLAYER_MIN_X = -BACKGROUND_WIDTH;
    // Camera
    public static final float MIN_CAMERA_X = -CAMERA_WIDTH * 0.5f;
    public static final float MAX_CAMERA_X = CAMERA_WIDTH * 1.5f + PLAYER_WIDTH;
    // Citizens
    public static final int STARTING_CITIZENS = 15;
    public static final float CITIZEN_WIDTH = 75f;
    public static final float CITIZEN_HEIGHT = CITIZEN_WIDTH * 2f;
    public static final float CITIZEN_SPEED = 100f;
    public static final float CITIZEN_MIN_X = 0f;
    public static final float CITIZEN_MAX_X = CAMERA_WIDTH - CITIZEN_WIDTH;
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
    // Main building
    public static final float MAIN_BUILDING_HEIGHT = CAMERA_HEIGHT / 3f;
    public static final float MAIN_BUILDING_WIDTH = MAIN_BUILDING_HEIGHT * 1.5f;
    public static final float MAIN_BUILDING_X = CAMERA_WIDTH / 2f - MAIN_BUILDING_WIDTH / 2f;
    public static final float MAIN_BUILDING_Y = GROUND_Y;
    // Tents
    public static final float TENT_SIZE = CAMERA_HEIGHT / 3f;
    public static final int TENT_UPGRADE_COST = 10;
    public static final float TENT1_X = MAIN_BUILDING_X + MAIN_BUILDING_WIDTH + 25f;
    public static final float TENT2_X = MAIN_BUILDING_X - TENT_SIZE - 25f;
    // Warehouse
    public static final int WAREHOUSE_INDEX = 3;
    public static final float WAREHOUSE_HEIGHT = CAMERA_HEIGHT / 3f;
    public static final float WAREHOUSE_WIDTH = WAREHOUSE_HEIGHT * 2.64f;
    public static final float WAREHOUSE_X = TENT1_X + TENT_SIZE + 25f;
    public static final float WAREHOUSE_Y = GROUND_Y;
    // Warehouse logs
    public static final float WAREHOUSE_LOG_STARTING_X = WAREHOUSE_X + 50f;
    public static final float WAREHOUSE_LOG_STARTING_Y = WAREHOUSE_Y;
    public static final float WAREHOUSE_LOG_HEIGHT = WAREHOUSE_HEIGHT / 10.66f;
    public static final float WAREHOUSE_LOG_WIDTH = WAREHOUSE_LOG_HEIGHT * 2.16f;
    public static final float WAREHOUSE_LOG_HEAD_SIZE = WAREHOUSE_LOG_WIDTH * 0.46f;
    public static final float WAREHOUSE_LOG_PILE_WIDTH = WAREHOUSE_LOG_HEAD_SIZE * 3 + WAREHOUSE_LOG_WIDTH;
    public static final int WAREHOUSE_MAX_LOGS = 50;
    // Cookhouse
    public static final int COOKHOUSE_INDEX = 4;
    public static final float COOKHOUSE_HEIGHT = CAMERA_HEIGHT / 3f;
    public static final float COOKHOUSE_WIDTH = COOKHOUSE_HEIGHT * (4f / 3f);
    public static final float COOKHOUSE_X = TENT2_X - COOKHOUSE_WIDTH - 25f;
    public static final float COOKHOUSE_Y = GROUND_Y;
    // Cookhouse meats
    public static final float COOKHOUSE_MEAT_STARTING_X = COOKHOUSE_X + COOKHOUSE_WIDTH * 0.53f;
    public static final float COOKHOUSE_MEAT_STARTING_Y = COOKHOUSE_Y + COOKHOUSE_HEIGHT * 0.33f;
    public static final float COOKHOUSE_MEAT_HEIGHT = COOKHOUSE_HEIGHT * 0.21f;
    public static final float COOKHOUSE_MEAT_WIDTH = COOKHOUSE_MEAT_HEIGHT * 0.47f;
    public static final float COOKHOUSE_MEAT_SPACING = COOKHOUSE_MEAT_WIDTH * 0.6f;
    // Food
    public static final float FOOD_ICON_SIZE = 50f;
    public static final float FOOD_INFO_X = MAIN_BUILDING_X + MAIN_BUILDING_WIDTH * 0.75f;
    public static final float FOOD_INFO_Y = MAIN_BUILDING_Y + MAIN_BUILDING_HEIGHT * 0.35f;

    public static final float DINING_X = FOOD_INFO_X + FOOD_ICON_SIZE;

    public static final float FOOD_INFO_TEXT_X = FOOD_INFO_X + FOOD_ICON_SIZE;
    public static final float FOOD_INFO_TEXT_Y = FOOD_INFO_Y + FOOD_ICON_SIZE / 2f;
    // Action icon
    public static final float ACTION_ICON_WIDTH = 70f;
    public static final float ACTION_ICON_HEIGHT = ACTION_ICON_WIDTH * 2f;
    // Wood
    public static final float WOOD_ICON_SIZE = 100f;
    public static final float WOOD_INFO_X = CAMERA_WIDTH - WOOD_ICON_SIZE * 2f;
    public static final float WOOD_INFO_Y = CAMERA_HEIGHT - WOOD_ICON_SIZE;

    public static final float WOOD_INFO_TEXT_X = WOOD_INFO_X + WOOD_ICON_SIZE;
    public static final float WOOD_INFO_TEXT_Y = WOOD_INFO_Y + WOOD_ICON_SIZE / 2f;
    // Tips
    public static final float TIP_WIDTH = CAMERA_WIDTH / 2f;
    public static final float TIP_HEIGHT = CAMERA_HEIGHT / 2f;
    public static final float TIP_X = CAMERA_WIDTH / 2f - TIP_WIDTH / 2f;
    public static final float TIP_Y = CAMERA_HEIGHT / 2f - TIP_HEIGHT / 2f;
    public static final float TIP_INTERVAL = 5f;

    public static final float TIP_ICON_SIZE = 100f;
    public static final float TIP_ICON_X = CAMERA_WIDTH / 2f - TIP_ICON_SIZE / 2f;
    public static final float TIP_ICON_Y = 25f;
    // Expedition
    public static final float GOING_TO_EXPEDITION_TIME = 2.5f;
    public static final float RETURNING_FROM_EXPEDITION_TIME = 2.5f;
    public static final float EXPEDITION_DURATION = 25f;
    public static final float EXPEDITION_ICON_SIZE = 100f;
    public static final float EXPEDITION_INFO_X = CAMERA_WIDTH - EXPEDITION_ICON_SIZE;
    public static final float EXPEDITION_INFO_Y = CAMERA_HEIGHT - WOOD_ICON_SIZE - EXPEDITION_ICON_SIZE;
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
    public static final float FOOD_EXPEDITION_BUTTON_Y = MAIN_MENU_HEIGHT / 2f + ACTION_BUTTON_HEIGHT / 2f;
    public static final float WOOD_EXPEDITION_BUTTON_Y = MAIN_MENU_HEIGHT / 2f - ACTION_BUTTON_HEIGHT * 1.5f;

    public static final float ACTION_ICON_SIZE = ACTION_BUTTON_HEIGHT;
    public static final float ACTION_ICON_X = EXPEDITION_BUTTON_X + ACTION_BUTTON_WIDTH + 20f;
    public static final float FOOD_ACTION_ICON_Y = FOOD_EXPEDITION_BUTTON_Y;
    public static final float WOOD_ACTION_ICON_Y = WOOD_EXPEDITION_BUTTON_Y;
    // Tech tree
    public static final int TECHNOLOGIES = 10;
    public static final float TECHNOLOGY_SIZE = 100f;
    public static final float TECHNOLOGY_SPACING = 200f;
    public static final float TECHNOLOGIES_WIDTH = 3 * TECHNOLOGY_SPACING + TECHNOLOGY_SIZE;
    public static final float TECHNOLOGIES_HEIGHT = 2 * TECHNOLOGY_SPACING + TECHNOLOGY_SIZE;
    public static final float TECHNOLOGIES_X = MAIN_MENU_WIDTH / 2f - TECHNOLOGIES_WIDTH / 2f;
    public static final float TECHNOLOGIES_Y = MAIN_MENU_HEIGHT / 2f - TECHNOLOGIES_HEIGHT / 2f;
    public static final String[] TECHNOLOGY_DESCRIPTIONS = {
            "BETTER CLOTHING",
            "FASTER EXPEDITIONS",
            "MORE FOOD PER EXPEDITION",
            "MORE WOOD PER EXPEDITION",
            "CHIMNEYS",
            "DWELLING REINFORCEMENT",
            "COOKING TECHNIQUES",
            "MORE EXPEDITIONS",
            "MEDICAL POST CAPACITY",
            "EXPEDITIONS"
    };
    public static final int[] TECHNOLOGY_COSTS = {
            50, 10, 20, 30, 25, 50, 30, 100, 40, 10
    };
    public static final float TECH_DESCRIPTION_WIDTH = MAIN_MENU_WIDTH;
    public static final float TECH_DESCRIPTION_HEIGHT = 100f;

    public static final float TECH_TREE_WOOD_ICON_SIZE = 50f;
    // Day
    public static final int DAY_DURATION = 60;
    public static final float DAY_Y = CAMERA_HEIGHT - 25f;
    // Day timer
    public static final float DAY_TIMER_Y = CAMERA_HEIGHT - 75f;
    // Other
    public static final float HIDDEN_X = -10 * CAMERA_WIDTH;
    public static final float HIDDEN_Y = -10 * CAMERA_HEIGHT;
}