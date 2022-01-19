package com.epicness.newfrost.game.stuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.SharedConstants.OPAQUE_TRANSPARENT;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.BACKGROUND_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.BACKGROUND_WIDTH;
import static com.epicness.newfrost.game.GameConstants.DAY_TIMER_Y;
import static com.epicness.newfrost.game.GameConstants.DAY_Y;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.GROUND_Y;
import static com.epicness.newfrost.game.GameConstants.TENT1_X;
import static com.epicness.newfrost.game.GameConstants.TENT2_X;
import static com.epicness.newfrost.game.GameConstants.TIP_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_SIZE;
import static com.epicness.newfrost.game.GameConstants.TIP_WIDTH;

import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.IconedSpritedText;
import com.epicness.fundamentals.stuff.MultiSprited;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.Cookhouse;
import com.epicness.newfrost.game.stuff.buildings.MainBuilding;
import com.epicness.newfrost.game.stuff.buildings.Tent;
import com.epicness.newfrost.game.stuff.buildings.Warehouse;
import com.epicness.newfrost.game.stuff.dialogues.DialogueStorage;
import com.epicness.newfrost.game.stuff.events.EventView;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;
import com.epicness.newfrost.game.stuff.people.Citizen;
import com.epicness.newfrost.game.stuff.people.Player;
import com.epicness.newfrost.game.stuff.resourceinfos.ExpeditionInfo;
import com.epicness.newfrost.game.stuff.resourceinfos.FoodInfo;
import com.epicness.newfrost.game.stuff.resourceinfos.WoodInfo;

public class GameStuff extends Stuff {

    private Sprited background;
    private MultiSprited[] bgLayers;
    private DelayedRemovalArray<Building> buildings;
    private Warehouse warehouse;
    private DelayedRemovalArray<Sprited> warehouseLogs;
    private DialogueStorage dialogueStorage;
    private DelayedRemovalArray<Citizen> citizens;
    private Player player;
    private Sprited actionIcon;
    private WoodInfo woodInfo;
    private FoodInfo foodInfo;
    private MainBuildingMenu mainBuildingMenu;
    private IconedSpritedText tutorialNotification;
    private SpritedText tip;
    private Sprited tipIcon;
    private ExpeditionInfo expeditionInfo;
    private Text day, dayTimer;
    private SpritedText dialogue;
    private EventView eventView;
    private Rain rain;
    private SpritedText gameOver;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

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

        initializeBuildings(assets);

        warehouseLogs = new DelayedRemovalArray<>();

        dialogueStorage = new DialogueStorage();

        citizens = new DelayedRemovalArray<>();

        player = new Player(assets);

        actionIcon = new Sprited(assets.getActionIcon());
        actionIcon.setSize(ACTION_ICON_WIDTH, ACTION_ICON_HEIGHT);

        woodInfo = new WoodInfo(assets.getWoodFrame(), assets.getPixelFont());

        foodInfo = new FoodInfo(assets.getMeatIcon(), assets.getPixelFont());

        mainBuildingMenu = new MainBuildingMenu(assets, sharedAssets);

        tutorialNotification = new IconedSpritedText(sharedAssets.getPixel(), assets.getPixelFontSmall(), assets.getMeat());
        tutorialNotification.setSize(300f, 100f);
        tutorialNotification.setText("DERPY DERP");
        tutorialNotification.setBackgroundColor(OPAQUE_TRANSPARENT);

        tip = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        tip.setSize(TIP_WIDTH, TIP_HEIGHT);
        tip.setColor(OPAQUE_TRANSPARENT);

        tipIcon = new Sprited(assets.getTipIcon());
        tipIcon.setSize(TIP_ICON_SIZE);

        expeditionInfo = new ExpeditionInfo(assets.getGlassIcon(), assets.getPixelFont());

        day = new Text(assets.getPixelFont());
        day.setTextTargetWidth(CAMERA_WIDTH);
        day.setHorizontalAlignment(Align.center);
        day.setY(DAY_Y);

        dayTimer = new Text(assets.getPixelFont());
        dayTimer.setTextTargetWidth(CAMERA_WIDTH);
        dayTimer.setHorizontalAlignment(Align.center);
        dayTimer.setY(DAY_TIMER_Y);

        dialogue = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        dialogue.setSize(DIALOGUE_WIDTH, DIALOGUE_HEIGHT);
        dialogue.setColor(TRANSPARENT);

        eventView = new EventView(sharedAssets.getPixel(), sharedAssets.getPixel(), assets.getPixelFont());

        rain = new Rain(sharedAssets.getPixel());

        gameOver = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        gameOver.setText("GAME OVER\nR TO RESTART");
        gameOver.setSize(CAMERA_WIDTH, CAMERA_HEIGHT);
    }

    private void initializeBuildings(GameAssets assets) {
        buildings = new DelayedRemovalArray<>();

        MainBuilding mainBuilding = new MainBuilding(assets.getMainBuilding());
        buildings.add(mainBuilding);

        Tent tent = new Tent(assets.getTent(), assets.getTentUpgrade());
        tent.setPosition(TENT1_X, GROUND_Y);
        buildings.add(tent);

        Tent tent2 = new Tent(assets.getTent(), assets.getTentUpgrade());
        tent2.setPosition(TENT2_X, GROUND_Y);
        tent2.flipX();
        buildings.add(tent2);

        warehouse = new Warehouse(assets.getWarehouseBack(), assets.getWarehouseFront());
        buildings.add(warehouse);

        Cookhouse cookhouse = new Cookhouse(assets.getCookhouse());
        buildings.add(cookhouse);
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

    public DelayedRemovalArray<Sprited> getWarehouseLogs() {
        return warehouseLogs;
    }

    public Warehouse getWarehouse() {
        return warehouse;
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

    public Sprited getActionIcon() {
        return actionIcon;
    }

    public WoodInfo getWoodInfo() {
        return woodInfo;
    }

    public FoodInfo getFoodInfo() {
        return foodInfo;
    }

    public MainBuildingMenu getMainBuildingMenu() {
        return mainBuildingMenu;
    }

    public IconedSpritedText getTutorialNotification() {
        return tutorialNotification;
    }

    public SpritedText getTip() {
        return tip;
    }

    public Sprited getTipIcon() {
        return tipIcon;
    }

    public ExpeditionInfo getExpeditionInfo() {
        return expeditionInfo;
    }

    public Text getDay() {
        return day;
    }

    public Text getDayTimer() {
        return dayTimer;
    }

    public SpritedText getDialogue() {
        return dialogue;
    }

    public EventView getEventView() {
        return eventView;
    }

    public Rain getRain() {
        return rain;
    }

    public SpritedText getGameOver() {
        return gameOver;
    }
}