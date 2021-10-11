package com.epicness.newfrost.game.logic;

import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.resourceinfos.WoodInfo;

public class WoodHandler {

    private GameStuff stuff;

    public void addWood(int amount) {
        stuff.getWoodInfo().setWood(getWood() + amount);
    }

    public void spendWood(int amount) {
        WoodInfo woodInfo = stuff.getWoodInfo();
        woodInfo.setWood(getWood() - amount);
    }

    public int getWood() {
        WoodInfo woodInfo = stuff.getWoodInfo();
        return woodInfo.getWood();
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}