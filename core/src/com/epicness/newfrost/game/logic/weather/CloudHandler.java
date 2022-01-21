package com.epicness.newfrost.game.logic.weather;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.GameStuff;

public class CloudHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private float time;

    public void update(float delta) {
        time += delta;
        if (time > 10f) {
            spawnCloud();
            time = 0f;
        }
        moveClouds(delta);
    }

    private void spawnCloud() {
        int random = MathUtils.random(2);
        Sprite cloudSprite;
        switch (random) {
            case 0:
                cloudSprite = assets.getCloud1();
                break;
            case 1:
                cloudSprite = assets.getCloud2();
                break;
            default:
                cloudSprite = assets.getCloud3();
                break;
        }
        Sprited cloud = new Sprited(cloudSprite);
        cloud.setSize(cloudSprite.getWidth() * 7f, cloudSprite.getHeight() * 7f);
        cloud.setPosition(-cloud.getWidth(), CAMERA_HEIGHT - cloud.getHeight() * MathUtils.random(1f, 2f));
        cloud.setColor(Color.GRAY);
        stuff.getClouds().add(cloud);
    }

    private void moveClouds(float delta) {
        DelayedRemovalArray<Sprited> clouds = stuff.getClouds();
        for (int i = 0; i < clouds.size; i++) {
            clouds.get(i).translateX(75f * delta);
        }
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}