package com.epicness.newfrost.game.stuff.resources;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
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
        sprited.setScale(0.75f);

        timer = new Text(font);
        timer.setHorizontalAlignment(Align.center);
        timer.setTextTargetWidth(EXPEDITION_ICON_SIZE);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
        timer.draw(spriteBatch);
    }

    public void setPosition(float x, float y) {
        sprited.setPosition(x, y);
        timer.setPosition(x, y);
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
        timer.setText((int) time + "");
    }
}