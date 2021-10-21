package com.epicness.newfrost.game.logic;

import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.newfrost.game.GameAssets;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameLogic extends Logic {

    // todo silencio seplucral

    private final ActionHandler actionHandler;
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
    private final TipHandler tipHandler;
    private final WoodHandler woodHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        actionHandler = new ActionHandler();
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
        tipHandler = new TipHandler();
        woodHandler = new WoodHandler();

        actionHandler.setLogic(this);
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
        citizenHandler.spawnCitizens();
        dayHandler.init();
        eventHandler.hideEventView();
        expeditionHandler.hideExpeditionInfo();
        introHandler.startMusic();
        mainBuildingMenuHandler.hideMenu();
        gameInputHandler.setupInput();
        gameOverHandler.init();
        tipHandler.hideTip();
        tipHandler.showTipIcon();
    }

    @Override
    public void update(float delta) {
        actionHandler.update();
        citizenActivityHandler.update(delta);
        dayHandler.update(delta);
        expeditionHandler.update(delta);
        highlightHandler.update();
        mainBuildingMenuHandler.update();
        playerMovementHandler.update(delta);
        rainHandler.update(delta);
        tipHandler.update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
        citizenHandler.setAssets(gameAssets);
        introHandler.setAssets(gameAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        gameInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        GameStuff gameStuff = (GameStuff) stuff;
        actionHandler.setStuff(gameStuff);
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
        tipHandler.setStuff(gameStuff);
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

    public TipHandler getTipHandler() {
        return tipHandler;
    }

    public WoodHandler getWoodHandler() {
        return woodHandler;
    }
}