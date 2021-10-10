package com.epicness.newfrost.game.stuff.mainbuildingmenu;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.SpritedText;

import static com.epicness.newfrost.game.GameConstants.ACTION_BUTTON_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.ACTION_BUTTON_WIDTH;
import static com.epicness.newfrost.game.GameConstants.EXPEDITION_BUTTON_X;
import static com.epicness.newfrost.game.GameConstants.EXPEDITION_BUTTON_Y;

public class ActionPanel {

    private final SpritedText expeditionButton;

    public ActionPanel(Sprite buttonFrame, BitmapFont font) {
        expeditionButton = new SpritedText(buttonFrame, font);
        expeditionButton.setSize(ACTION_BUTTON_WIDTH, ACTION_BUTTON_HEIGHT);
        expeditionButton.setText("EXPEDITION");
    }

    public void draw(SpriteBatch spriteBatch) {
        expeditionButton.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        expeditionButton.setPosition(x + EXPEDITION_BUTTON_X, y + EXPEDITION_BUTTON_Y);
    }

    public SpritedText getExpeditionButton() {
        return expeditionButton;
    }
}