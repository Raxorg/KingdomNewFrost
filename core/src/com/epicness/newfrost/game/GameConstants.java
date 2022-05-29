package com.epicness.newfrost.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.SharedConstants.NAVY_GRAY_50;

import com.badlogic.gdx.graphics.Color;

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
    public static final float DIALOGUE_WIDTH = CAMERA_WIDTH / 4f;
    public static final float DIALOGUE_HEIGHT = DIALOGUE_WIDTH / 4f;
    // Base
    public static final float BASE_HEIGHT = CAMERA_HEIGHT / 3f;
    public static final float BASE_WIDTH = BASE_HEIGHT * 1.5f;
    public static final float BASE_X = CAMERA_WIDTH / 2f - BASE_WIDTH / 2f;
    public static final float BASE_Y = GROUND_Y;
    public static final int BASE_MAX_LOGS = 20;
    public static final int BASE_MAX_MEATS = 5;
    // Tents
    public static final float TENT_SIZE = CAMERA_HEIGHT / 3f;
    public static final int TENT_UPGRADE_COST = 10;
    public static final float TENT1_X = BASE_X + BASE_WIDTH + 25f;
    public static final float TENT2_X = BASE_X - TENT_SIZE - 25f;
    // Warehouse
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
    public static final Color WAREHOUSE_LOG_COLOR = Color.GRAY.cpy().lerp(Color.BROWN, 0.25f);
    public static final int WAREHOUSE_MAX_LOGS = 50;
    // Explorarium
    public static final float EXPLORARIUM_HEIGHT = CAMERA_HEIGHT * 0.75f;
    public static final float EXPLORARIUM_WIDTH = EXPLORARIUM_HEIGHT * 0.81f;
    public static final float EXPLORARIUM_X = WAREHOUSE_X + WAREHOUSE_WIDTH + 25f;
    public static final float EXPLORARIUM_Y = GROUND_Y;
    // Explorarium backpacks
    public static final float EXPLORARIUM_BACKPACK_HEIGHT = EXPLORARIUM_HEIGHT * 0.11f;
    public static final float EXPLORARIUM_BACKPACK_WIDTH = EXPLORARIUM_WIDTH * 0.11f;
    public static final float EXPLORARIUM_BACKPACK_SPACING = EXPLORARIUM_BACKPACK_WIDTH * 0.5f;
    public static final Color EXPLORARIUM_BACKPACK_COLOR = Color.LIGHT_GRAY.cpy().lerp(Color.FOREST, 0.2f);
    // Cookhouse
    public static final float COOKHOUSE_HEIGHT = CAMERA_HEIGHT / 3f;
    public static final float COOKHOUSE_WIDTH = COOKHOUSE_HEIGHT * (4f / 3f);
    public static final float COOKHOUSE_X = TENT2_X - COOKHOUSE_WIDTH - 25f;
    public static final float COOKHOUSE_Y = GROUND_Y;

    public static final float DINING_X = COOKHOUSE_X + COOKHOUSE_WIDTH * 0.75f;
    // Cookhouse meats
    public static final float COOKHOUSE_MEAT_STARTING_X = COOKHOUSE_X + COOKHOUSE_WIDTH * 0.53f;
    public static final float COOKHOUSE_MEAT_STARTING_Y = COOKHOUSE_Y + COOKHOUSE_HEIGHT * 0.33f;
    public static final float COOKHOUSE_MEAT_HEIGHT = COOKHOUSE_HEIGHT * 0.21f;
    public static final float COOKHOUSE_MEAT_WIDTH = COOKHOUSE_MEAT_HEIGHT * 0.47f;
    public static final float COOKHOUSE_MEAT_SPACING = COOKHOUSE_MEAT_WIDTH * 0.6f;
    public static final Color COOKHOUSE_MEAT_COLOR = Color.LIGHT_GRAY.cpy().lerp(Color.RED, 0.15f);
    public static final int COOKHOUSE_MAX_MEATS = 10;
    // Night
    public static final Color NIGHT_SKY_COLOR = Color.BLACK;
    public static final Color NIGHT_BACKGROUND_COLOR = Color.NAVY.cpy().lerp(Color.DARK_GRAY, 0.5f);
    public static final Color NIGHT_BUILDING_COLOR = NAVY_GRAY_50;
    public static final Color NIGHT_MEAT_COLOR = COOKHOUSE_MEAT_COLOR.cpy().lerp(NAVY_GRAY_50, 0.65f);
    public static final Color NIGHT_MEAT_HOOK_COLOR = NAVY_GRAY_50;
    public static final Color NIGHT_LOG_COLOR = WAREHOUSE_LOG_COLOR.cpy().lerp(NAVY_GRAY_50, 0.65f);
    public static final Color NIGHT_BACKPACK_COLOR = EXPLORARIUM_BACKPACK_COLOR.cpy().lerp(NAVY_GRAY_50, 0.65f);
    public static final Color NIGHT_PEOPLE_COLOR = Color.NAVY.cpy().lerp(Color.GRAY, 0.75f);
    // Action icon
    public static final float ACTION_ICON_WIDTH = 70f;
    public static final float ACTION_ICON_HEIGHT = ACTION_ICON_WIDTH * 2f;
    // Tutorial dialogue
    public static final float TUTORIAL_DIALOGUE_WIDTH = CAMERA_WIDTH / 2f;
    public static final float TUTORIAL_DIALOGUE_HEIGHT = CAMERA_HEIGHT / 2f;
    public static final float TUTORIAL_DIALOGUE_X = CAMERA_WIDTH / 2f - TUTORIAL_DIALOGUE_WIDTH / 2f;
    public static final float TUTORIAL_DIALOGUE_Y = CAMERA_HEIGHT / 2f - TUTORIAL_DIALOGUE_HEIGHT / 2f;
    // Expedition
    public static final float GOING_TO_EXPEDITION_TIME = 2.5f;
    public static final float RETURNING_FROM_EXPEDITION_TIME = 2.5f;
    public static final float EXPEDITION_DURATION = 28f;
    public static final float BACKPACK_EXPEDITION_DURATION = 22f;
    public static final float EXPEDITION_ICON_SIZE = 100f;
    public static final float EXPEDITION_INFO_X = CAMERA_WIDTH - EXPEDITION_ICON_SIZE;
    public static final float EXPEDITION_INFO_Y = CAMERA_HEIGHT - EXPEDITION_ICON_SIZE;
    // Alerts
    public static final float ALERT_SIZE = 100f;
    // Base menu
    public static final float BASE_MENU_X = 100f;
    public static final float BASE_MENU_Y = 100f;
    public static final float BASE_MENU_WIDTH = CAMERA_WIDTH - 200f;
    public static final float BASE_MENU_HEIGHT = CAMERA_HEIGHT - 200f;
    public static final float TAB_WIDTH = 200f;
    public static final float TAB_HEIGHT = TAB_WIDTH / 3f;
    public static final float TECH_TAB_X = TAB_WIDTH;
    public static final float LAW_TAB_X = TECH_TAB_X + TAB_WIDTH;
    public static final float TAB_Y = BASE_MENU_HEIGHT - TAB_HEIGHT;
    // Action panel
    public static final float ACTION_BUTTON_WIDTH = 400f;
    public static final float ACTION_BUTTON_HEIGHT = ACTION_BUTTON_WIDTH / 4f;

    public static final float EXPEDITION_BUTTON_X = BASE_MENU_WIDTH / 2f - ACTION_BUTTON_WIDTH / 2f;
    public static final float FOOD_EXPEDITION_BUTTON_Y = BASE_MENU_HEIGHT * 0.7f;
    public static final float FOOD_EXPEDITION_BACKPACK_BUTTON_Y = BASE_MENU_HEIGHT * 0.5f;
    public static final float WOOD_EXPEDITION_BUTTON_Y = BASE_MENU_HEIGHT * 0.3f;
    public static final float WOOD_EXPEDITION_BACKPACK_BUTTON_Y = BASE_MENU_HEIGHT * 0.1f;

    public static final float ACTION_ICON_SIZE = ACTION_BUTTON_HEIGHT;
    public static final float ACTION_ICON_X = EXPEDITION_BUTTON_X + ACTION_BUTTON_WIDTH + 20f;
    public static final float BACKPACK_ICON_X = ACTION_ICON_X + ACTION_ICON_SIZE + 20f;
    public static final float FOOD_ACTION_ICON_Y = FOOD_EXPEDITION_BUTTON_Y;
    public static final float FOOD_ACTION_ICON_2_Y = FOOD_EXPEDITION_BACKPACK_BUTTON_Y;
    public static final float BACKPACK_ACTION_ICON_Y = FOOD_EXPEDITION_BACKPACK_BUTTON_Y;
    public static final float WOOD_ACTION_ICON_Y = WOOD_EXPEDITION_BUTTON_Y;
    public static final float WOOD_ACTION_ICON_2_Y = WOOD_EXPEDITION_BACKPACK_BUTTON_Y;
    public static final float BACKPACK_ACTION_ICON_2_Y = WOOD_EXPEDITION_BACKPACK_BUTTON_Y;
    // Tech tree
    public static final int TECHNOLOGIES = 10;
    public static final float TECHNOLOGY_SIZE = 100f;
    public static final float TECHNOLOGY_SPACING = 200f;
    public static final float TECHNOLOGIES_WIDTH = 3 * TECHNOLOGY_SPACING + TECHNOLOGY_SIZE;
    public static final float TECHNOLOGIES_HEIGHT = 2 * TECHNOLOGY_SPACING + TECHNOLOGY_SIZE;
    public static final float TECHNOLOGIES_X = BASE_MENU_WIDTH / 2f - TECHNOLOGIES_WIDTH / 2f;
    public static final float TECHNOLOGIES_Y = BASE_MENU_HEIGHT / 2f - TECHNOLOGIES_HEIGHT / 2f;
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
    public static final float TECH_DESCRIPTION_WIDTH = BASE_MENU_WIDTH;
    public static final float TECH_DESCRIPTION_HEIGHT = 100f;

    public static final float TECH_TREE_WOOD_ICON_SIZE = 50f;
    // Day
    public static final int DAY_DURATION = 60;
    public static final float DAY_Y = CAMERA_HEIGHT - 25f;
    // Day timer
    public static final float DAY_TIMER_Y = CAMERA_HEIGHT - 75f;
    // Tutorial texts
    public static final String CONTROLS_TUTORIAL_TEXT = "Press A and D to move S to interact when the interaction icon appears";
    public static final String FEED_TUTORIAL_TEXT = "Feed your people with food from expeditions you can deploy from the base";
    public static final String HUNGER_TUTORIAL_TEXT = "People feel hungry each 2 days and need 1 food ration to stabilize";
    public static final String COLD_PROTECTION_TUTORIAL_TEXT = "Upgrade the dwellings for better protection against cold";
    public static final String GAME_OVER_TUTORIAL_TEXT = "When half the population dies the game is over";
    // Tutorial widget
    public static final float TUTORIAL_WIDGET_WIDTH = 450f;
    public static final float TUTORIAL_WIDGET_HEIGHT = 140f;
    public static final float TUTORIAL_WIDGET_SLIDE_DURATION = 0.7f;
    // Vanishing log
    public static final float VANISHING_LOG_STARTING_Y = PLAYER_STARTING_Y + PLAYER_HEIGHT;
    public static final float VANISHING_LOG_FINAL_Y = VANISHING_LOG_STARTING_Y + 200f;
    // Other
    public static final float HIDDEN_X = -10 * CAMERA_WIDTH;
    public static final float HIDDEN_Y = -10 * CAMERA_HEIGHT;
}