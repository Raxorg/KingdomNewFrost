package com.epicness.newfrost.game.logic.buildings;

import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_COLOR;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_SPACING;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_STARTING_X;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_STARTING_Y;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_BACKPACK_WIDTH;
import static com.epicness.newfrost.game.GameConstants.EXPLORARIUM_INDEX;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.buildings.Explorarium;

public class ExplorariumHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;
    // Logic
    private int backpacks;

    public void init() {
        Explorarium explorarium = (Explorarium) stuff.getBuildings().get(EXPLORARIUM_INDEX);
        DelayedRemovalArray<Sprited> explorariumBackpacks = explorarium.getExplorariumBackpacks();
        explorariumBackpacks.clear();
        backpacks = 0;
    }

    public void addBackpacks(int quantity) {
        Explorarium explorarium = (Explorarium) stuff.getBuildings().get(EXPLORARIUM_INDEX);
        DelayedRemovalArray<Sprited> explorariumBackpacks = explorarium.getExplorariumBackpacks();
        for (int i = 0; i < quantity && backpacks < 5; i++) {
            Sprited backpack = new Sprited(assets.getExplorariumBackpack());
            backpack.setSize(EXPLORARIUM_BACKPACK_WIDTH, EXPLORARIUM_BACKPACK_HEIGHT);
            backpack.setPosition(EXPLORARIUM_BACKPACK_STARTING_X, EXPLORARIUM_BACKPACK_STARTING_Y);
            backpack.translateX(backpacks * EXPLORARIUM_BACKPACK_SPACING);
            backpack.setColor(EXPLORARIUM_BACKPACK_COLOR);
            explorariumBackpacks.add(backpack);
            backpacks++;
        }
        explorariumBackpacks.sort((sprited1, sprited2) -> sprited1.getX() > sprited2.getX() ? -1 : 0);
    }

    public void removeBackpacks(int quantity) {
        Explorarium explorarium = (Explorarium) stuff.getBuildings().get(EXPLORARIUM_INDEX);
        DelayedRemovalArray<Sprited> explorariumBackpacks = explorarium.getExplorariumBackpacks();
        for (int i = 0; i < quantity && backpacks > 0; i++) {
            explorariumBackpacks.removeIndex(explorariumBackpacks.size - 1);
            backpacks--;
        }
    }

    public int getBackpacks() {
        return backpacks;
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}