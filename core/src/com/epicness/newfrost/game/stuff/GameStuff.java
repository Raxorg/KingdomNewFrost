package com.epicness.newfrost.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.newfrost.game.GameAssets;
import com.epicness.newfrost.game.stuff.buildings.Building;
import com.epicness.newfrost.game.stuff.buildings.MainBuilding;
import com.epicness.newfrost.game.stuff.dialogues.DialogueStorage;
import com.epicness.newfrost.game.stuff.events.EventView;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.MainBuildingMenu;
import com.epicness.newfrost.game.stuff.people.Citizen;
import com.epicness.newfrost.game.stuff.people.Player;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.fundamentals.SharedConstants.TRANSPARENT;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.GROUND_Y;
import static com.epicness.newfrost.game.GameConstants.TIP_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_SIZE;
import static com.epicness.newfrost.game.GameConstants.TIP_WIDTH;

public class GameStuff extends Stuff {

    private Sprited background;
    private DelayedRemovalArray<Building> buildings;
    private Sprited diningTable;
    private DelayedRemovalArray<Citizen> citizens;
    private Player player;
    private Sprited actionIcon;
    private MainBuildingMenu mainBuildingMenu;
    private SpritedText tip;
    private Sprited tipIcon;
    private ExpeditionInfo expeditionInfo;
    private SpritedText dialogue;
    private EventView eventView;
    private Rain rain;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        background = new Sprited(assets.getBackground());
        background.setSize(CAMERA_WIDTH * 2f, CAMERA_HEIGHT);
        background.setX(-CAMERA_WIDTH / 2f);

        buildings = new DelayedRemovalArray<>();
        MainBuilding mainBuilding = new MainBuilding(assets.getMainBuilding());
        buildings.add(mainBuilding);

        diningTable = new Sprited(sharedAssets.getPixel());
        diningTable.setPosition(CAMERA_WIDTH / 2f, GROUND_Y);
        diningTable.setSize(100f);
        diningTable.setColor(Color.BROWN);

        DialogueStorage dialogueStorage = new DialogueStorage();

        citizens = new DelayedRemovalArray<>();
        for (int i = 0; i < 15; i++) {
            Citizen citizen = new Citizen(assets.getCitizen(), dialogueStorage.getRandomDialogue());
            citizens.add(citizen);
        }

        player = new Player(assets.getCitizen());

        actionIcon = new Sprited(assets.getActionIcon());
        actionIcon.setSize(ACTION_ICON_WIDTH, ACTION_ICON_HEIGHT);

        mainBuildingMenu = new MainBuildingMenu(assets, sharedAssets);

        tip = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        tip.setSize(TIP_WIDTH, TIP_HEIGHT);

        tipIcon = new Sprited(assets.getTipIcon());
        tipIcon.setSize(TIP_ICON_SIZE);

        dialogue = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        dialogue.setSize(DIALOGUE_WIDTH, DIALOGUE_HEIGHT);
        dialogue.setColor(TRANSPARENT);

        eventView = new EventView(sharedAssets.getPixel(), sharedAssets.getPixel(), assets.getPixelFont());

        rain = new Rain(sharedAssets.getPixel());
    }

    public Sprited getBackground() {
        return background;
    }

    public DelayedRemovalArray<Building> getBuildings() {
        return buildings;
    }

    public Sprited getDiningTable() {
        return diningTable;
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

    public MainBuildingMenu getMainBuildingMenu() {
        return mainBuildingMenu;
    }

    public SpritedText getTip() {
        return tip;
    }

    public Sprited getTipIcon() {
        return tipIcon;
    }

    public EventView getEventView() {
        return eventView;
    }

    public Rain getRain() {
        return rain;
    }
}