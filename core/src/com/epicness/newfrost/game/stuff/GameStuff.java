package com.epicness.newfrost.game.stuff;

import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.newfrost.game.GameAssets;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.MainBuilding;
import com.epicness.newfrost.game.stuff.buildings.Tent;
import com.epicness.newfrost.game.stuff.dialogues.DialogueStorage;
import com.epicness.newfrost.game.stuff.events.EventView;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;
import com.epicness.newfrost.game.stuff.people.Citizen;
import com.epicness.newfrost.game.stuff.people.Player;
import com.epicness.newfrost.game.stuff.resourceinfos.ExpeditionInfo;
import com.epicness.newfrost.game.stuff.resourceinfos.FoodInfo;
import com.epicness.newfrost.game.stuff.resourceinfos.WoodInfo;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.SharedConstants.OPAQUE_TRANSPARENT;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.DAY_DURATION;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.GROUND_Y;
import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_WIDTH;
import static com.epicness.newfrost.game.GameConstants.MAIN_BUILDING_X;
import static com.epicness.newfrost.game.GameConstants.STARTING_CITIZENS;
import static com.epicness.newfrost.game.GameConstants.TENT_SIZE;
import static com.epicness.newfrost.game.GameConstants.TIP_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_SIZE;
import static com.epicness.newfrost.game.GameConstants.TIP_WIDTH;

public class GameStuff extends Stuff {

    private Sprited background;
    private DelayedRemovalArray<Building> buildings;
    private DialogueStorage dialogueStorage;
    private DelayedRemovalArray<Citizen> citizens;
    private Player player;
    private Sprited actionIcon;
    private WoodInfo woodInfo;
    private FoodInfo foodInfo;
    private MainBuildingMenu mainBuildingMenu;
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

        background = new Sprited(assets.getBackground());
        background.setSize(CAMERA_WIDTH * 2f, CAMERA_HEIGHT);
        background.setX(-CAMERA_WIDTH / 2f);

        initializeBuildings(assets);

        dialogueStorage = new DialogueStorage();

        citizens = new DelayedRemovalArray<>();

        player = new Player(assets);

        actionIcon = new Sprited(assets.getActionIcon());
        actionIcon.setSize(ACTION_ICON_WIDTH, ACTION_ICON_HEIGHT);

        woodInfo = new WoodInfo(assets.getWoodFrame(), assets.getPixelFont());

        foodInfo = new FoodInfo(assets.getMeatIcon(), assets.getPixelFont());

        mainBuildingMenu = new MainBuildingMenu(assets, sharedAssets);

        tip = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        tip.setSize(TIP_WIDTH, TIP_HEIGHT);
        tip.setColor(OPAQUE_TRANSPARENT);

        tipIcon = new Sprited(assets.getTipIcon());
        tipIcon.setSize(TIP_ICON_SIZE);

        expeditionInfo = new ExpeditionInfo(assets.getGlassIcon(), assets.getPixelFont());

        day = new Text(assets.getPixelFont());
        day.setTextTargetWidth(CAMERA_WIDTH);
        day.setHorizontalAlignment(Align.center);
        day.setY(CAMERA_HEIGHT - 25f);

        dayTimer = new Text(assets.getPixelFont());
        dayTimer.setTextTargetWidth(CAMERA_WIDTH);
        dayTimer.setHorizontalAlignment(Align.center);
        dayTimer.setY(CAMERA_HEIGHT - 75f);

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
        tent.setPosition(MAIN_BUILDING_X + MAIN_BUILDING_WIDTH + 25f, GROUND_Y);
        buildings.add(tent);

        Tent tent2 = new Tent(assets.getTent(), assets.getTentUpgrade());
        tent2.setPosition(MAIN_BUILDING_X - TENT_SIZE - 25f, GROUND_Y);
        tent2.flipX();
        buildings.add(tent2);
    }

    public Sprited getBackground() {
        return background;
    }

    public DelayedRemovalArray<Building> getBuildings() {
        return buildings;
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