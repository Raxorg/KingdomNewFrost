package com.epicness.newfrost.game.stuff.mainbuildingmenu;

import static com.epicness.newfrost.game.GameConstants.ACTION_BUTTON_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.ACTION_BUTTON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_SIZE;
import static com.epicness.newfrost.game.GameConstants.ACTION_ICON_X;
import static com.epicness.newfrost.game.GameConstants.BACKPACK_ACTION_ICON_2_Y;
import static com.epicness.newfrost.game.GameConstants.BACKPACK_ACTION_ICON_Y;
import static com.epicness.newfrost.game.GameConstants.BACKPACK_ICON_X;
import static com.epicness.newfrost.game.GameConstants.EXPEDITION_BUTTON_X;
import static com.epicness.newfrost.game.GameConstants.FOOD_ACTION_ICON_2_Y;
import static com.epicness.newfrost.game.GameConstants.FOOD_ACTION_ICON_Y;
import static com.epicness.newfrost.game.GameConstants.FOOD_EXPEDITION_BACKPACK_BUTTON_Y;
import static com.epicness.newfrost.game.GameConstants.FOOD_EXPEDITION_BUTTON_Y;
import static com.epicness.newfrost.game.GameConstants.WOOD_ACTION_ICON_2_Y;
import static com.epicness.newfrost.game.GameConstants.WOOD_ACTION_ICON_Y;
import static com.epicness.newfrost.game.GameConstants.WOOD_EXPEDITION_BACKPACK_BUTTON_Y;
import static com.epicness.newfrost.game.GameConstants.WOOD_EXPEDITION_BUTTON_Y;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;

public class ActionPanel {

    private final SpritedText foodExpeditionButton, foodExpeditionBackpackButton, woodExpeditionButton, woodExpeditionBackpackButton;
    private final Sprited foodIcon1, foodIcon2, backpackIcon1, woodIcon1, woodIcon2, backpackIcon2;

    public ActionPanel(Sprite buttonFrame, BitmapFont font, Sprite foodIcon, Sprite woodIcon, Sprite backpackIcon) {
        foodExpeditionButton = new SpritedText(buttonFrame, font);
        foodExpeditionButton.setSize(ACTION_BUTTON_WIDTH, ACTION_BUTTON_HEIGHT);
        foodExpeditionButton.setText("EXPEDITION");

        foodExpeditionBackpackButton = new SpritedText(buttonFrame, font);
        foodExpeditionBackpackButton.setSize(ACTION_BUTTON_WIDTH, ACTION_BUTTON_HEIGHT);
        foodExpeditionBackpackButton.setText("EXPEDITION");

        woodExpeditionButton = new SpritedText(buttonFrame, font);
        woodExpeditionButton.setSize(ACTION_BUTTON_WIDTH, ACTION_BUTTON_HEIGHT);
        woodExpeditionButton.setText("EXPEDITION");

        woodExpeditionBackpackButton = new SpritedText(buttonFrame, font);
        woodExpeditionBackpackButton.setSize(ACTION_BUTTON_WIDTH, ACTION_BUTTON_HEIGHT);
        woodExpeditionBackpackButton.setText("EXPEDITION");

        foodIcon1 = new Sprited(foodIcon);
        foodIcon1.setSize(ACTION_ICON_SIZE);

        foodIcon2 = new Sprited(foodIcon);
        foodIcon2.setSize(ACTION_ICON_SIZE);

        backpackIcon1 = new Sprited(backpackIcon);
        backpackIcon1.setSize(ACTION_ICON_SIZE);

        woodIcon1 = new Sprited(woodIcon);
        woodIcon1.setSize(ACTION_ICON_SIZE);

        woodIcon2 = new Sprited(woodIcon);
        woodIcon2.setSize(ACTION_ICON_SIZE);

        backpackIcon2 = new Sprited(backpackIcon);
        backpackIcon2.setSize(ACTION_ICON_SIZE);
    }

    public void draw(SpriteBatch spriteBatch) {
        foodExpeditionButton.draw(spriteBatch);
        foodExpeditionBackpackButton.draw(spriteBatch);
        woodExpeditionButton.draw(spriteBatch);
        woodExpeditionBackpackButton.draw(spriteBatch);
        foodIcon1.draw(spriteBatch);
        foodIcon2.draw(spriteBatch);
        backpackIcon1.draw(spriteBatch);
        woodIcon1.draw(spriteBatch);
        woodIcon2.draw(spriteBatch);
        backpackIcon2.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        foodExpeditionButton.setPosition(x + EXPEDITION_BUTTON_X, y + FOOD_EXPEDITION_BUTTON_Y);
        foodExpeditionBackpackButton.setPosition(x + EXPEDITION_BUTTON_X, y + FOOD_EXPEDITION_BACKPACK_BUTTON_Y);
        woodExpeditionButton.setPosition(x + EXPEDITION_BUTTON_X, y + WOOD_EXPEDITION_BUTTON_Y);
        woodExpeditionBackpackButton.setPosition(x + EXPEDITION_BUTTON_X, y + WOOD_EXPEDITION_BACKPACK_BUTTON_Y);
        foodIcon1.setPosition(x + ACTION_ICON_X, y + FOOD_ACTION_ICON_Y);
        foodIcon2.setPosition(x + ACTION_ICON_X, y + FOOD_ACTION_ICON_2_Y);
        backpackIcon1.setPosition(x + BACKPACK_ICON_X, y + BACKPACK_ACTION_ICON_Y);
        woodIcon1.setPosition(x + ACTION_ICON_X, y + WOOD_ACTION_ICON_Y);
        woodIcon2.setPosition(x + ACTION_ICON_X, y + WOOD_ACTION_ICON_2_Y);
        backpackIcon2.setPosition(x + BACKPACK_ICON_X, y + BACKPACK_ACTION_ICON_2_Y);
    }

    public SpritedText getFoodExpeditionButton() {
        return foodExpeditionButton;
    }

    public SpritedText getFoodExpeditionBackpackButton() {
        return foodExpeditionBackpackButton;
    }

    public SpritedText getWoodExpeditionButton() {
        return woodExpeditionButton;
    }

    public SpritedText getWoodExpeditionBackpackButton() {
        return woodExpeditionBackpackButton;
    }
}