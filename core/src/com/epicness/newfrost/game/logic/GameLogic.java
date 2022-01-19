package com.epicness.newfrost.game.logic;

import static com.badlogic.gdx.Input.Keys.J;

import com.badlogic.gdx.Gdx;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.logic.behaviors.ParallaxBehavior;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.logic.buildings.WarehouseHandler;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameLogic extends Logic {

    // todo silencio seplucral

    // Buildings
    private final WarehouseHandler warehouseHandler;
    // Uncategorized
    private final ActionHandler actionHandler;
    private final CameraHandler cameraHandler;
    private final CitizenActivityHandler citizenActivityHandler;
    private final CitizenHandler citizenHandler;
    private final CitizenHungerHandler citizenHungerHandler;
    private final DayHandler dayHandler;
    private final DialogueHandler dialogueHandler;
    private final EventHandler eventHandler;
    private final ExpeditionHandler expeditionHandler;
    private final FoodHandler foodHandler;
    private final GameInputHandler gameInputHandler;
    private final GameOverHandler gameOverHandler;
    private final HighlightHandler highlightHandler;
    private final IntroHandler introHandler;
    private final MainBuildingMenuHandler mainBuildingMenuHandler;
    private final PlayerMovementHandler playerMovementHandler;
    private final RainHandler rainHandler;
    private final TutorialHandler tutorialHandler;
    private final WoodHandler woodHandler;

    private final ParallaxBehavior parallaxBehavior;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        warehouseHandler = new WarehouseHandler();
        // Uncategorized
        actionHandler = new ActionHandler();
        cameraHandler = new CameraHandler();
        citizenActivityHandler = new CitizenActivityHandler();
        citizenHandler = new CitizenHandler();
        citizenHungerHandler = new CitizenHungerHandler();
        dayHandler = new DayHandler();
        dialogueHandler = new DialogueHandler(); // todo
        eventHandler = new EventHandler();
        expeditionHandler = new ExpeditionHandler();
        foodHandler = new FoodHandler();
        gameInputHandler = new GameInputHandler();
        gameOverHandler = new GameOverHandler();
        highlightHandler = new HighlightHandler();
        introHandler = new IntroHandler();
        mainBuildingMenuHandler = new MainBuildingMenuHandler();
        playerMovementHandler = new PlayerMovementHandler();
        rainHandler = new RainHandler();
        tutorialHandler = new TutorialHandler();
        woodHandler = new WoodHandler();

        parallaxBehavior = new ParallaxBehavior();

        actionHandler.setLogic(this);
        cameraHandler.setLogic(this);
        citizenHungerHandler.setLogic(this);
        dayHandler.setLogic(this);
        expeditionHandler.setLogic(this);
        gameInputHandler.setLogic(this);
        gameOverHandler.setLogic(this);
        mainBuildingMenuHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        actionHandler.hideActionIcon();
        cameraHandler.configureParallax();
        citizenHandler.spawnCitizens();
        dayHandler.init();
        eventHandler.hideEventView();
        expeditionHandler.hideExpeditionInfo();
        introHandler.startMusic();
        mainBuildingMenuHandler.hideMenu();
        gameInputHandler.setupInput();
        gameOverHandler.init();
        tutorialHandler.hideTip();
        tutorialHandler.showTipIcon();
    }

    @Override
    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(J)) {
            warehouseHandler.addLogs(1);
        }
        actionHandler.update();
        cameraHandler.update();
        citizenActivityHandler.update(delta);
        dayHandler.update(delta);
        expeditionHandler.update(delta);
        highlightHandler.update();
        mainBuildingMenuHandler.update();
        playerMovementHandler.update(delta);
        rainHandler.update(delta);
        tutorialHandler.update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
        // Buildings
        warehouseHandler.setAssets(gameAssets);
        // Uncategorized
        citizenHandler.setAssets(gameAssets);
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
        warehouseHandler.setStuff(gameStuff);
        // Uncategorized
        actionHandler.setStuff(gameStuff);
        cameraHandler.setStuff(gameStuff);
        citizenActivityHandler.setStuff(gameStuff);
        citizenHandler.setStuff(gameStuff);
        citizenHungerHandler.setStuff(gameStuff);
        dayHandler.setStuff(gameStuff);
        eventHandler.setStuff(gameStuff);
        expeditionHandler.setStuff(gameStuff);
        foodHandler.setStuff(gameStuff);
        gameInputHandler.setStuff(stuff);
        gameOverHandler.setStuff(gameStuff);
        highlightHandler.setStuff(gameStuff);
        mainBuildingMenuHandler.setStuff(gameStuff);
        playerMovementHandler.setStuff(gameStuff);
        rainHandler.setStuff(gameStuff);
        tutorialHandler.setStuff(gameStuff);
        woodHandler.setStuff(gameStuff);
    }

    public ActionHandler getActionHandler() {
        return actionHandler;
    }

    public CitizenHungerHandler getCitizenHungerHandler() {
        return citizenHungerHandler;
    }

    public DayHandler getDayHandler() {
        return dayHandler;
    }

    public ExpeditionHandler getExpeditionHandler() {
        return expeditionHandler;
    }

    public FoodHandler getFoodHandler() {
        return foodHandler;
    }

    public GameOverHandler getGameOverHandler() {
        return gameOverHandler;
    }

    public HighlightHandler getHighlightHandler() {
        return highlightHandler;
    }

    public MainBuildingMenuHandler getMainBuildingMenuHandler() {
        return mainBuildingMenuHandler;
    }

    public PlayerMovementHandler getPlayerMovementHandler() {
        return playerMovementHandler;
    }

    public TutorialHandler getTipHandler() {
        return tutorialHandler;
    }

    public WoodHandler getWoodHandler() {
        return woodHandler;
    }

    public ParallaxBehavior getParallaxBehavior() {
        return parallaxBehavior;
    }
}