package com.epicness.newfrost.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.newfrost.game.GameAssets;

import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameStuff extends Stuff {

    private Sprited diningTable;
    private DelayedRemovalArray<Citizen> citizens;

    @Override
    public void initializeStuff() {
        GameAssets assets = (GameAssets) this.assets;

        diningTable = new Sprited(sharedAssets.getPixel());
        diningTable.setX(CAMERA_WIDTH / 2f);
        diningTable.setSize(100f);
        diningTable.setColor(Color.BROWN);

        citizens = new DelayedRemovalArray<>();
        for (int i = 0; i < 15; i++) {
            Citizen citizen = new Citizen(assets.getCitizen());
            citizen.setX(CAMERA_WIDTH / 6f);
            citizens.add(citizen);
        }
    }

    public Sprited getDiningTable() {
        return diningTable;
    }

    public DelayedRemovalArray<Citizen> getCitizens() {
        return citizens;
    }
}