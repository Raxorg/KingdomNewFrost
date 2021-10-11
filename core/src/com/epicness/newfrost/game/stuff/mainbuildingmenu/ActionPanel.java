package com.epicness.newfrost.game.stuff.mainbuildingmenu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;

import static com.epicness.newfrost.game.GameConstants.ACTION_BUTTON_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.ACTION_BUTTON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_SIZE;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_X;
import static com.epicness.newfrost.game.GameConstants.EXPEDITION_BUTTON_X;
import static com.epicness.newfrost.game.GameConstants.FOOD_ACTION_ICON_Y;
import static com.epicness.newfrost.game.GameConstants.FOOD_EXPEDITION_BUTTON_Y;
import static com.epicness.newfrost.game.GameConstants.WOOD_ACTION_ICON_Y;
import static com.epicness.newfrost.game.GameConstants.WOOD_EXPEDITION_BUTTON_Y;

public class ActionPanel {

    private final SpritedText foodExpeditionButton, woodExpeditionButton;
    private final Sprited food, wood;

    public ActionPanel(Sprite buttonFrame, BitmapFont font, Sprite foodIcon, Sprite woodIcon) {
        foodExpeditionButton = new SpritedText(buttonFrame, font);
        foodExpeditionButton.setSize(ACTION_BUTTON_WIDTH, ACTION_BUTTON_HEIGHT);
        foodExpeditionButton.setText("EXPEDITION");

        woodExpeditionButton = new SpritedText(buttonFrame, font);
        woodExpeditionButton.setSize(ACTION_BUTTON_WIDTH, ACTION_BUTTON_HEIGHT);
        woodExpeditionButton.setText("EXPEDITION");

        food = new Sprited(foodIcon);
        food.setSize(ACTION_ICON_SIZE);

        wood = new Sprited(woodIcon);
        wood.setSize(ACTION_ICON_SIZE);
    }

    public void draw(SpriteBatch spriteBatch) {
        foodExpeditionButton.draw(spriteBatch);
        woodExpeditionButton.draw(spriteBatch);
        food.draw(spriteBatch);
        wood.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        foodExpeditionButton.setPosition(x + EXPEDITION_BUTTON_X, y + FOOD_EXPEDITION_BUTTON_Y);
        woodExpeditionButton.setPosition(x + EXPEDITION_BUTTON_X, y + WOOD_EXPEDITION_BUTTON_Y);
        food.setPosition(x + ACTION_ICON_X, y + FOOD_ACTION_ICON_Y);
        wood.setPosition(x + ACTION_ICON_X, y + WOOD_ACTION_ICON_Y);
    }

    public SpritedText getFoodExpeditionButton() {
        return foodExpeditionButton;
    }

    public SpritedText getWoodExpeditionButton() {
        return woodExpeditionButton;
    }
}