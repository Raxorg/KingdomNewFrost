package com.epicness.newfrost.game.stuff.resourceinfos;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Text;

import static com.epicness.newfrost.game.GameConstants.WOOD_ICON_SIZE;
import static com.epicness.newfrost.game.GameConstants.WOOD_INFO_TEXT_X;
import static com.epicness.newfrost.game.GameConstants.WOOD_INFO_TEXT_Y;
import static com.epicness.newfrost.game.GameConstants.WOOD_INFO_X;
import static com.epicness.newfrost.game.GameConstants.WOOD_INFO_Y;

public class WoodInfo {

    private final Sprited sprited;
    private final Text quantity;

    public WoodInfo(Sprite woodIcon, BitmapFont font) {
        sprited = new Sprited(woodIcon);
        sprited.setPosition(WOOD_INFO_X, WOOD_INFO_Y);
        sprited.setSize(WOOD_ICON_SIZE);

        quantity = new Text(font);
        quantity.setPosition(WOOD_INFO_TEXT_X, WOOD_INFO_TEXT_Y);
        quantity.setHorizontalAlignment(Align.center);
        quantity.setCenterVertical(true);
        quantity.setTextTargetWidth(WOOD_ICON_SIZE);
        quantity.setText("20");
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
        quantity.draw(spriteBatch);
    }

    public int getWood() {
        return Integer.parseInt(quantity.getText());
    }

    public void setWood(int wood) {
        quantity.setText(wood + "");
    }
}