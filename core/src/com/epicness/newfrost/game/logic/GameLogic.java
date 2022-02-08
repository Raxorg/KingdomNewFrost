package com.epicness.newfrost.game.logic;

import static com.badlogic.gdx.Input.Keys.I;
import static com.badlogic.gdx.Input.Keys.O;
import static com.badlogic.gdx.Input.Keys.U;
import static com.badlogic.gdx.Input.Keys.Y;

import com.badlogic.gdx.Gdx;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.logic.behaviors.ParallaxBehavior;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.logic.buildings.BuildingInteractionHandler;
import com.epicness.newfrost.game.logic.buildings.CookhouseHandler;
import com.epicness.newfrost.game.logic.buildings.ExplorariumHandler;
import com.epicness.newfrost.game.logic.buildings.WarehouseHandler;
import com.epicness.newfrost.game.logic.buildings.main.ActionTabHandler;
import com.epicness.newfrost.game.logic.buildings.main.LawTreeTabHandler;
import com.epicness.newfrost.game.logic.buildings.main.MainBuildingMenuHandler;
import com.epicness.newfrost.game.logic.buildings.main.TechTreeTabHandler;
import com.epicness.newfrost.game.logic.people.CitizenActivityHandler;
import com.epicness.newfrost.game.logic.people.CitizenHandler;
import com.epicness.newfrost.game.logic.people.CitizenHighlightHandler;
import com.epicness.newfrost.game.logic.people.CitizenHungerHandler;
import com.epicness.newfrost.game.logic.people.DialogueHandler;
import com.epicness.newfrost.game.logic.people.PlayerMovementHandler;
import com.epicness.newfrost.game.logic.weather.CloudHandler;
import com.epicness.newfrost.game.logic.weather.DayNightCycler;
import com.epicness.newfrost.game.logic.weather.RainHandler;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameLogic extends Logic {

    // todo silencio seplucral cuando un ciudadano muere

    // Buildings
    private final ActionTabHandler actionTabHandler;
    private final LawTreeTabHandler lawTreeTabHandler;
    private final MainBuildingMenuHandler mainBuildingMenuHandler;
    private final TechTreeTabHandler techTreeTabHandler;
    private final CookhouseHandler cookhouseHandler;
    private final ExplorariumHandler explorariumHandler;
    private final WarehouseHandler warehouseHandler;
    // People
    private final CitizenActivityHandler citizenActivityHandler;
    private final CitizenHandler citizenHandler;
    private final CitizenHighlightHandler citizenHighlightHandler;
    private final CitizenHungerHandler citizenHungerHandler;
    private final DialogueHandler dialogueHandler;
    private final PlayerMovementHandler playerMovementHandler;
    // Weather
    private final CloudHandler cloudHandler;
    private final DayNightCycler dayNightCycler;
    private final RainHandler rainHandler;
    // Uncategorized
    private final BuildingInteractionHandler buildingInteractionHandler;
    private final CameraHandler cameraHandler;
    private final DayTimerHandler dayTimerHandler;
    private final EventHandler eventHandler;
    private final ExpeditionHandler expeditionHandler;
    private final GameInputHandler gameInputHandler;
    private final GameOverHandler gameOverHandler;
    private final IntroHandler introHandler;
    private final SpendingHandler spendingHandler;
    private final TutorialHandler tutorialHandler;

    private final ParallaxBehavior parallaxBehavior;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
        // Buildings
        actionTabHandler = new ActionTabHandler();
        lawTreeTabHandler = new LawTreeTabHandler();
        mainBuildingMenuHandler = new MainBuildingMenuHandler();
        techTreeTabHandler = new TechTreeTabHandler();
        buildingInteractionHandler = new BuildingInteractionHandler();
        cookhouseHandler = new CookhouseHandler();
        explorariumHandler = new ExplorariumHandler();
        warehouseHandler = new WarehouseHandler();
        // People
        citizenActivityHandler = new CitizenActivityHandler();
        citizenHandler = new CitizenHandler();
        citizenHighlightHandler = new CitizenHighlightHandler();
        citizenHungerHandler = new CitizenHungerHandler();
        dialogueHandler = new DialogueHandler();
        playerMovementHandler = new PlayerMovementHandler();
        // Weather
        cloudHandler = new CloudHandler();
        dayNightCycler = new DayNightCycler();
        rainHandler = new RainHandler();
        // Uncategorized
        cameraHandler = new CameraHandler();
        dayTimerHandler = new DayTimerHandler();
        eventHandler = new EventHandler();
        expeditionHandler = new ExpeditionHandler();
        gameInputHandler = new GameInputHandler();
        gameOverHandler = new GameOverHandler();
        introHandler = new IntroHandler();
        spendingHandler = new SpendingHandler();
        tutorialHandler = new TutorialHandler();
        // Behaviors
        parallaxBehavior = new ParallaxBehavior();
        // Buildings
        actionTabHandler.setLogic(this);
        mainBuildingMenuHandler.setSharedLogic(sharedLogic);
        mainBuildingMenuHandler.setLogic(this);
        techTreeTabHandler.setLogic(this);
        buildingInteractionHandler.setLogic(this);
        // People
        citizenActivityHandler.setLogic(this);
        citizenHandler.setLogic(this);
        citizenHungerHandler.setLogic(this);
        dialogueHandler.setLogic(this);
        // Uncategorized
        cameraHandler.setLogic(this);
        dayTimerHandler.setSharedLogic(sharedLogic);
        dayTimerHandler.setLogic(this);
        expeditionHandler.setLogic(this);
        gameInputHandler.setLogic(this);
        gameOverHandler.setSharedLogic(sharedLogic);
        gameOverHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        // Buildings
        mainBuildingMenuHandler.init();
        buildingInteractionHandler.hideActionIcon();
        cookhouseHandler.init();
        // People
        citizenHandler.spawnCitizens();
        dialogueHandler.hideDialogue();
        // Weather
        dayNightCycler.initialize();
        rainHandler.init();
        // Uncategorized
        cameraHandler.configureParallax();
        dayTimerHandler.init();
        eventHandler.hideEventView();
        expeditionHandler.init();
        gameInputHandler.setupInput();
        gameOverHandler.init();
        introHandler.startMusic();
        tutorialHandler.init();

        sharedLogic.getFader().setup(1f);
        sharedLogic.getFader().fadeOut();
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Y)) {
            warehouseHandler.addLogs(1);
        }
        if (Gdx.input.isKeyJustPressed(U)) {
            explorariumHandler.addBackpacks(1);
        }
        if (Gdx.input.isKeyJustPressed(I)) {
            cookhouseHandler.addMeats(1);
        }
        if (Gdx.input.isKeyJustPressed(O)) {
            dayTimerHandler.passDay();
        }
        // Buildings
        mainBuildingMenuHandler.update();
        // Weather
        cloudHandler.update(delta);
        dayNightCycler.applyColors();
        rainHandler.update(delta);
        // People
        citizenHighlightHandler.update();
        dialogueHandler.update();
        playerMovementHandler.update(delta);
        // Uncategorized
        buildingInteractionHandler.update();
        cameraHandler.update();
        citizenActivityHandler.update(delta);
        dayTimerHandler.update(delta);
        expeditionHandler.update(delta);
        spendingHandler.update(delta);
        tutorialHandler.update(delta);

        sharedLogic.getFader().update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
        // Buildings
        cookhouseHandler.setAssets(gameAssets);
        explorariumHandler.setAssets(gameAssets);
        warehouseHandler.setAssets(gameAssets);
        // People
        citizenHandler.setAssets(gameAssets);
        // Weather
        cloudHandler.setAssets(gameAssets);
        // Uncategorized
        introHandler.setAssets(gameAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setScreen(SharedScreen screen) {
        cameraHandler.setScreen(screen);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        // Buildings
        actionTabHandler.setStuff(gameStuff);
        lawTreeTabHandler.setStuff(gameStuff);
        mainBuildingMenuHandler.setStuff(gameStuff);
        techTreeTabHandler.setStuff(gameStuff);
        cookhouseHandler.setStuff(gameStuff);
        explorariumHandler.setStuff(gameStuff);
        warehouseHandler.setStuff(gameStuff);
        // People
        citizenActivityHandler.setStuff(gameStuff);
        citizenHandler.setStuff(gameStuff);
        citizenHighlightHandler.setStuff(gameStuff);
        citizenHungerHandler.setStuff(gameStuff);
        dialogueHandler.setStuff(gameStuff);
        playerMovementHandler.setStuff(gameStuff);
        // Weather
        cloudHandler.setStuff(gameStuff);
        dayNightCycler.setStuff(gameStuff);
        rainHandler.setStuff(gameStuff);
        // Uncategorized
        buildingInteractionHandler.setStuff(gameStuff);
        cameraHandler.setStuff(gameStuff);
        dayTimerHandler.setStuff(gameStuff);
        eventHandler.setStuff(gameStuff);
        expeditionHandler.setStuff(gameStuff);
        gameInputHandler.setStuff(stuff);
        gameOverHandler.setStuff(gameStuff);
        spendingHandler.setStuff(gameStuff);
        tutorialHandler.setStuff(gameStuff);
    }

    // Buildings
    public ActionTabHandler getActionTabHandler() {
        return actionTabHandler;
    }

    public LawTreeTabHandler getLawTreeTabHandler() {
        return lawTreeTabHandler;
    }

    public MainBuildingMenuHandler getMainBuildingMenuHandler() {
        return mainBuildingMenuHandler;
    }

    public TechTreeTabHandler getTechTreeTabHandler() {
        return techTreeTabHandler;
    }

    public CookhouseHandler getCookhouseHandler() {
        return cookhouseHandler;
    }

    public ExplorariumHandler getExplorariumHandler() {
        return explorariumHandler;
    }

    public WarehouseHandler getWarehouseHandler() {
        return warehouseHandler;
    }

    // People
    public CitizenHandler getCitizenHandler() {
        return citizenHandler;
    }

    public CitizenHighlightHandler getCitizenHighlightHandler() {
        return citizenHighlightHandler;
    }

    public CitizenHungerHandler getCitizenHungerHandler() {
        return citizenHungerHandler;
    }

    public DialogueHandler getDialogueHandler() {
        return dialogueHandler;
    }

    public PlayerMovementHandler getPlayerMovementHandler() {
        return playerMovementHandler;
    }

    // Weather
    public DayNightCycler getDayNightCycler() {
        return dayNightCycler;
    }

    // Uncategorized
    public BuildingInteractionHandler getActionHandler() {
        return buildingInteractionHandler;
    }

    public DayTimerHandler getDayHandler() {
        return dayTimerHandler;
    }

    public ExpeditionHandler getExpeditionHandler() {
        return expeditionHandler;
    }

    public GameOverHandler getGameOverHandler() {
        return gameOverHandler;
    }

    public SpendingHandler getSpendingHandler() {
        return spendingHandler;
    }

    public TutorialHandler getTutorialHandler() {
        return tutorialHandler;
    }

    public ParallaxBehavior getParallaxBehavior() {
        return parallaxBehavior;
    }
}