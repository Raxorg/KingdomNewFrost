package com.epicness.newfrost.game.stuff;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Text;

import static com.epicness.newfrost.game.GameConstants.EXPEDITION_ICON_SIZE;

public class ExpeditionInfo {

    private final Sprited sprited;
    private final Text timer;
    private float time;

    public ExpeditionInfo(Sprite expeditionIcon, BitmapFont font) {
        sprited = new Sprited(expeditionIcon);
        sprited.setSize(EXPEDITION_ICON_SIZE);
        timer = new Text(font);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
        timer.draw(spriteBatch);
    }

    public void setPosition() {

    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
        timer.setText((int) time + "");
    }
}