package com.epicness.fundamentals.logic;

import com.epicness.fundamentals.SharedResources;
import com.epicness.fundamentals.logic.behaviors.Fader;

public class SharedLogic {

    private final AssetLoader assetLoader;
    private final BackgroundHandler backgroundHandler;
    private final PauseHandler pauseHandler;
    private final PreferencesHandler preferencesHandler;
    private final TransitionHandler transitionHandler;
    private final Fader fader;

    public SharedLogic() {
        assetLoader = new AssetLoader();
        backgroundHandler = new BackgroundHandler();
        pauseHandler = new PauseHandler();
        preferencesHandler = new PreferencesHandler();
        transitionHandler = new TransitionHandler();
        fader = new Fader();

        transitionHandler.setLogic(this);
    }

    public void setSharedResources(SharedResources sharedResources) {
        backgroundHandler.setStuff(sharedResources.getStuff());
        transitionHandler.setSharedResources(sharedResources);
    }

    // Helpers
    public AssetLoader getAssetLoader() {
        return assetLoader;
    }

    public BackgroundHandler getBackgroundHandler() {
        return backgroundHandler;
    }

    public PauseHandler getPauseHandler() {
        return pauseHandler;
    }

    public PreferencesHandler getPreferencesHandler() {
        return preferencesHandler;
    }

    public TransitionHandler getTransitionHandler() {
        return transitionHandler;
    }

    public Fader getFader() {
        return fader;
    }
}