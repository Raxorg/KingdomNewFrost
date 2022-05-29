package com.epicness.newfrost.game.stuff;

import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_25;
import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_50;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.BACKGROUND_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.BACKGROUND_WIDTH;
import static com.epicness.newfrost.game.GameConstants.DAY_TIMER_Y;
import static com.epicness.newfrost.game.GameConstants.DAY_Y;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.GROUND_Y;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.TENT1_X;
import static com.epicness.newfrost.game.GameConstants.TENT2_X;
import static com.epicness.newfrost.game.GameConstants.TUTORIAL_DIALOGUE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.TUTORIAL_DIALOGUE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.TUTORIAL_WIDGET_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.TUTORIAL_WIDGET_WIDTH;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.WAREHOUSE_LOG_WIDTH;

import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.IconedSpritedText;
import com.epicness.fundamentals.stuff.MultiSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.buildings.Base;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Explorarium;
import com.epicness.newfrost.game.stuff.buildings.Tent;
import com.epicness.newfrost.game.stuff.buildings.Warehouse;
import com.epicness.newfrost.game.stuff.dialogues.DialogueStorage;
import com.epicness.newfrost.game.stuff.events.EventView;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;
import com.epicness.newfrost.game.stuff.people.Citizen;
import com.epicness.newfrost.game.stuff.people.Player;
import com.epicness.newfrost.game.stuff.resources.ExpeditionInfo;

public class GameStuff extends Stuff {

    private Sprited background;
    private MultiSprited[] bgLayers;
    private DelayedRemovalArray<Building> buildings;
    private DelayedRemovalArray<Sprited> clouds;
    private DialogueStorage dialogueStorage;
    private DelayedRemovalArray<Citizen> citizens;
    private Player player;
    private Sprited vanishingLog, actionIcon;
    private MainBuildingMenu mainBuildingMenu;
    private SpritedText dialogue;
    private IconedSpritedText tutorialWidget;
    private SpritedText tip;
    private ExpeditionInfo expeditionInfo;
    private Alert hungerAlert;
    private Text day, dayTimer;
    private EventView eventView;
    private SpritedText message;
    private Rain rain;
    private SpritedText gameOverMessage;
    private Sprited hanged, hangedText;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        initializeBackground(assets);
        initializeBuildings(assets);

        clouds = new DelayedRemovalArray<>();

        dialogueStorage = new DialogueStorage();

        citizens = new DelayedRemovalArray<>();

        player = new Player(assets);

        vanishingLog = new Sprited(assets.getWarehouseLog());
        vanishingLog.setPosition(HIDDEN_X, HIDDEN_Y);
        vanishingLog.setSize(WAREHOUSE_LOG_WIDTH, WAREHOUSE_LOG_HEIGHT);

        actionIcon = new Sprited(assets.getActionIcon());
        actionIcon.setSize(ACTION_ICON_WIDTH, ACTION_ICON_HEIGHT);

        mainBuildingMenu = new MainBuildingMenu(assets, sharedAssets);

        dialogue = new SpritedText(sharedAssets.getPixel(), assets.getPixelFontMedium());
        dialogue.setSize(DIALOGUE_WIDTH, DIALOGUE_HEIGHT);
        dialogue.setBackgroundColor(BLACK_CLEAR_50);

        tutorialWidget = new IconedSpritedText(sharedAssets.getPixel(), assets.getPixelFont(), assets.getTipIcon());
        tutorialWidget.setSize(TUTORIAL_WIDGET_WIDTH, TUTORIAL_WIDGET_HEIGHT);
        tutorialWidget.setText("MISSING TUTORIAL TEXT");
        tutorialWidget.setBackgroundColor(BLACK_CLEAR_25);

        tip = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        tip.setSize(TUTORIAL_DIALOGUE_WIDTH, TUTORIAL_DIALOGUE_HEIGHT);
        tip.setBackgroundColor(BLACK_CLEAR_25);

        expeditionInfo = new ExpeditionInfo(assets.getGlassIcon(), assets.getPixelFont());

        hungerAlert = new Alert(assets.getMeat(), assets.getPixelFont());

        day = new Text(assets.getPixelFont());
        day.setTextTargetWidth(CAMERA_WIDTH);
        day.setHorizontalAlignment(Align.center);
        day.setY(DAY_Y);

        dayTimer = new Text(assets.getPixelFont());
        dayTimer.setTextTargetWidth(CAMERA_WIDTH);
        dayTimer.setHorizontalAlignment(Align.center);
        dayTimer.setY(DAY_TIMER_Y);

        eventView = new EventView(sharedAssets.getPixel(), sharedAssets.getPixel(), assets.getPixelFont());

        message = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        message.setBackgroundColor(BLACK_CLEAR_50);

        rain = new Rain(sharedAssets.getPixel());

        gameOverMessage = new SpritedText(sharedAssets.getPixel(), sharedAssets.getTimesSquare());
        gameOverMessage.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        hanged = new Sprited(assets.getHanged());
        hanged.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);

        hangedText = new Sprited(assets.getHangedText());
        hangedText.setPosition(CAMERA_WIDTH / 2f - hangedText.getWidth() / 2f, 60f);
        hangedText.setScale(2f);
    }

    private void initializeBackground(GameAssets assets) {
        background = new Sprited(assets.getBackground0());
        background.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);

        bgLayers = new MultiSprited[7];
        bgLayers[0] = new MultiSprited(assets.getBackground1(), 3);
        bgLayers[1] = new MultiSprited(assets.getBackground2(), 3);
        bgLayers[2] = new MultiSprited(assets.getBackground3(), 3);
        bgLayers[3] = new MultiSprited(assets.getBackground4(), 3);
        bgLayers[4] = new MultiSprited(assets.getBackground5(), 3);
        bgLayers[5] = new MultiSprited(assets.getBackground6(), 3);
        bgLayers[6] = new MultiSprited(assets.getBackground7(), 3);
        for (int i = 0; i < bgLayers.length; i++) {
            bgLayers[i].setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
            bgLayers[i].setX(-BACKGROUND_WIDTH, 1);
            bgLayers[i].setX(BACKGROUND_WIDTH, 2);
        }
    }

    private void initializeBuildings(GameAssets assets) {
        buildings = new DelayedRemovalArray<>();

        Base base = new Base(assets.getMainBuilding());
        buildings.add(base);

        Tent tent = new Tent(assets.getTent(), assets.getTentUpgrade());
        tent.setPosition(TENT1_X, GROUND_Y);
        buildings.add(tent);

        Tent tent2 = new Tent(assets.getTent(), assets.getTentUpgrade());
        tent2.setPosition(TENT2_X, GROUND_Y);
        tent2.flipX();
        buildings.add(tent2);

        Warehouse warehouse = new Warehouse(assets.getWarehouseBack(), assets.getWarehouseFront());
        buildings.add(warehouse);

        Explorarium explorarium = new Explorarium(assets.getExplorarium());
        buildings.add(explorarium);
    }

    public Sprited getBackground() {
        return background;
    }

    public MultiSprited[] getBGLayers() {
        return bgLayers;
    }

    public DelayedRemovalArray<Building> getBuildings() {
        return buildings;
    }

    public DelayedRemovalArray<Sprited> getClouds() {
        return clouds;
    }

    public DialogueStorage getDialogueStorage() {
        return dialogueStorage;
    }

    public DelayedRemovalArray<Citizen> getCitizens() {
        return citizens;
    }

    public Player getPlayer() {
        return player;
    }

    public Sprited getVanishingLog() {
        return vanishingLog;
    }

    public Sprited getActionIcon() {
        return actionIcon;
    }

    public MainBuildingMenu getMainBuildingMenu() {
        return mainBuildingMenu;
    }

    public SpritedText getDialogue() {
        return dialogue;
    }

    public IconedSpritedText getTutorialWidget() {
        return tutorialWidget;
    }

    public SpritedText getTip() {
        return tip;
    }

    public ExpeditionInfo getExpeditionInfo() {
        return expeditionInfo;
    }

    public Alert getHungerAlert() {
        return hungerAlert;
    }

    public Text getDay() {
        return day;
    }

    public Text getDayTimer() {
        return dayTimer;
    }

    public EventView getEventView() {
        return eventView;
    }

    public SpritedText getMessage() {
        return message;
    }

    public Rain getRain() {
        return rain;
    }

    public SpritedText getGameOverMessage() {
        return gameOverMessage;
    }

    public Sprited getHanged() {
        return hanged;
    }

    public Sprited getHangedText() {
        return hangedText;
    }
}