package com.epicness.newfrost.game.logic;

import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.newfrost.game.GameAssets;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameLogic extends Logic {

    private final ActionHandler actionHandler;
    private final CitizenActivityHandler citizenActivityHandler;
    private final CitizenHungerHandler citizenHungerHandler;
    private final DayHandler dayHandler;
    private final EventHandler eventHandler;
    private final ExpeditionHandler expeditionHandler;
    private final GameInputHandler gameInputHandler;
    private final HighlightHandler highlightHandler;
    private final IntroHandler introHandler;
    private final MainBuildingMenuHandler mainBuildingMenuHandler;
    private final PlayerMovementHandler playerMovementHandler;
    private final RainHandler rainHandler;
    private final TipHandler tipHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        actionHandler = new ActionHandler();
        citizenActivityHandler = new CitizenActivityHandler();
        citizenHungerHandler = new CitizenHungerHandler();
        dayHandler = new DayHandler();
        eventHandler = new EventHandler();
        expeditionHandler = new ExpeditionHandler();
        gameInputHandler = new GameInputHandler();
        highlightHandler = new HighlightHandler();
        introHandler = new IntroHandler();

        mainBuildingMenuHandler = new MainBuildingMenuHandler();
        playerMovementHandler = new PlayerMovementHandler();
        rainHandler = new RainHandler();
        tipHandler = new TipHandler();

        actionHandler.setLogic(this);
        gameInputHandler.setLogic(this);
        mainBuildingMenuHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        actionHandler.hideActionIcon();
        eventHandler.hideEventView();
        introHandler.startMusic();
        mainBuildingMenuHandler.hideMenu();
        gameInputHandler.setupInput();
        tipHandler.hideTip();
        tipHandler.showTipIcon();
    }

    @Override
    public void update(float delta) {
        actionHandler.update();
        citizenActivityHandler.update(delta);
        dayHandler.update(delta);
        highlightHandler.update();
        mainBuildingMenuHandler.update();
        playerMovementHandler.update(delta);
        rainHandler.update(delta);
        tipHandler.update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        GameAssets gameAssets = (GameAssets) assets;
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
        citizenHungerHandler.setStuff(gameStuff);
        dayHandler.setStuff(gameStuff);
        eventHandler.setStuff(gameStuff);
        expeditionHandler.setStuff(gameStuff);
        gameInputHandler.setStuff(stuff);
        highlightHandler.setStuff(gameStuff);
        mainBuildingMenuHandler.setStuff(gameStuff);
        playerMovementHandler.setStuff(gameStuff);
        rainHandler.setStuff(gameStuff);
        tipHandler.setStuff(gameStuff);
    }

    public ActionHandler getActionHandler() {
        return actionHandler;
    }

    public DayHandler getDayHandler() {
        return dayHandler;
    }

    public ExpeditionHandler getExpeditionHandler() {
        return expeditionHandler;
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
}