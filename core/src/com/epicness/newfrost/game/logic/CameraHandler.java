package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.MAX_CAMERA_X;
import static com.epicness.newfrost.game.GameConstants.MIN_CAMERA_X;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.SharedScreen;
import com.epicness.fundamentals.logic.behaviors.ParallaxBehavior;
import com.epicness.newfrost.game.stuff.GameStuff;

public class CameraHandler {

    // Structure
    private GameLogic logic;
    private SharedScreen screen;
    private GameStuff stuff;
    // Logic
    private float lastCameraX;

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
        float cameraX = camera.position.x;
        logic.getParallaxBehavior().update(cameraX - lastCameraX);
        camera.position.x = MathUtils.clamp(playerX, MIN_CAMERA_X, MAX_CAMERA_X);
        camera.update();
        logic.getHighlightHandler().updateLastCursorPosition(cameraX - lastCameraX);
        lastCameraX = cameraX;
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