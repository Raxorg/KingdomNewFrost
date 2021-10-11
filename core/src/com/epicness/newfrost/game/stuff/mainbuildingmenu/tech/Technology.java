package com.epicness.newfrost.game.stuff.mainbuildingmenu.tech;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;

import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_SIZE;

public class Technology {

    private Sprited sprited;
    private SpritedText spritedText;

    public Technology(Sprite technologySprite, Sprite backgroundSprite, BitmapFont font, String description) {
        sprited = new Sprited(technologySprite);
        sprited.setSize(TECHNOLOGY_SIZE);

        spritedText = new SpritedText(backgroundSprite, font);
        spritedText.setText(description);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprited.setPosition(x, y);
    }

    public void setColor(Color color) {
        sprited.setColor(color);
    }
}