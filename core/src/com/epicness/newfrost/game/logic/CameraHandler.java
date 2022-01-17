package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.logic.behaviors.ParallaxBehavior;
import com.epicness.newfrost.game.stuff.GameStuff;

public class CameraHandler {

    // Structure
    private GameLogic logic;
    private SharedScreen screen;
    private GameStuff stuff;

    public void configureParallax() {
        ParallaxBehavior parallaxBehavior = logic.getParallaxBehavior();
        for (int i = 0; i < stuff.getBGLayers().length; i++) {
            if (i == 3) {
                parallaxBehavior.addParallaxable(stuff.getBGLayers()[i], 0.5f - 0.1f * (i - 2));
                continue;
            }
            parallaxBehavior.addParallaxable(stuff.getBGLayers()[i], 0.5f - 0.1f * i);
        }
    }

    public void update() {
        float playerX = stuff.getPlayer().getCenterX();
        OrthographicCamera camera = screen.getDynamicCamera();
        logic.getParallaxBehavior().update(playerX - camera.position.x);
        camera.position.x = playerX;
        camera.update();
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setScreen(SharedScreen screen) {
        this.screen = screen;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}