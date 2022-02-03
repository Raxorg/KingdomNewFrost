package com.epicness.newfrost.intro.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.GameInitializer;
import com.epicness.newfrost.intro.IntroAssets;
import com.epicness.newfrost.intro.IntroStuff;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.newfrost.intro.IntroConstants.SNOWFLAKE_X_SPEED_1;
import static com.epicness.newfrost.intro.IntroConstants.SNOWFLAKE_X_SPEED_2;
import static com.epicness.newfrost.intro.IntroConstants.SNOWFLAKE_Y_SPEED_1;
import static com.epicness.newfrost.intro.IntroConstants.SNOWFLAKE_Y_SPEED_2;

public class IntroHandler {

    // Structure
    private IntroAssets assets;
    private SharedLogic sharedLogic;
    private IntroStuff stuff;
    // Logic
    private float time;

    public void playNarration() {
        assets.getNarration().play();
    }

    public void update(float delta) {
        Sprited[] snow = stuff.getSnow();
        for (int i = 0; i < snow.length; i++) {
            Sprited snowFlake = snow[i];
            float xAmount = i % 2 == 0 ? SNOWFLAKE_X_SPEED_1 : SNOWFLAKE_X_SPEED_2;
            snowFlake.translateX(xAmount * delta);
            float yAmount = i % 2 == 0 ? SNOWFLAKE_Y_SPEED_1 : SNOWFLAKE_Y_SPEED_2;
            snowFlake.translateY(yAmount * delta);
            if (snowFlake.getX() <= 0f) {
                snowFlake.setX(CAMERA_WIDTH + snowFlake.getX());
            }
            if (snowFlake.getY() <= 0f) {
                snowFlake.setY(CAMERA_HEIGHT + snowFlake.getY());
            }
        }
        time += delta;
        if (time >= 51) {
            stuff.getContinueText().setColor(Color.WHITE);
        }
    }

    public void spacePressed() {
        assets.getNarration().dispose();
        sharedLogic.getTransitionHandler().startTransition(new GameInitializer());
        sharedLogic.getTransitionHandler().allowTransition();
    }

    // Structure
    public void setAssets(IntroAssets assets) {
        this.assets = assets;
    }

    public void setSharedLogic(SharedLogic sharedLogic) {
        this.sharedLogic = sharedLogic;
    }

    public void setStuff(IntroStuff stuff) {
        this.stuff = stuff;
    }
}