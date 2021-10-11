package com.epicness.newfrost.game.logic;

import com.epicness.newfrost.game.stuff.resourceinfos.FoodInfo;
import com.epicness.newfrost.game.stuff.GameStuff;

public class FoodHandler {

    private GameStuff stuff;

    public void addFood(int amount) {
        FoodInfo foodInfo = stuff.getFoodInfo();
        foodInfo.setFood(foodInfo.getFood() + amount);
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}