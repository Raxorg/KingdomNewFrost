package com.epicness.newfrost.game.stuff.resourceinfos;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Text;

import static com.epicness.newfrost.game.GameConstants.FOOD_ICON_SIZE;
import static com.epicness.newfrost.game.GameConstants.FOOD_INFO_TEXT_X;
import static com.epicness.newfrost.game.GameConstants.FOOD_INFO_TEXT_Y;
import static com.epicness.newfrost.game.GameConstants.FOOD_INFO_X;
import static com.epicness.newfrost.game.GameConstants.FOOD_INFO_Y;

public class FoodInfo {

    private final Sprited sprited;
    private final Text quantity;

    public FoodInfo(Sprite foodIcon, BitmapFont font) {
        sprited = new Sprited(foodIcon);
        sprited.setPosition(FOOD_INFO_X, FOOD_INFO_Y);
        sprited.setSize(FOOD_ICON_SIZE);

        quantity = new Text(font);
        quantity.setPosition(FOOD_INFO_TEXT_X, FOOD_INFO_TEXT_Y);
        quantity.setHorizontalAlignment(Align.center);
        quantity.setCenterVertical(true);
        quantity.setTextTargetWidth(FOOD_ICON_SIZE);
        quantity.setText("0");
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
        quantity.draw(spriteBatch);
    }

    public int getFood() {
        return Integer.parseInt(quantity.getText());
    }

    public void setFood(int food) {
        quantity.setText(food + "");
    }
}