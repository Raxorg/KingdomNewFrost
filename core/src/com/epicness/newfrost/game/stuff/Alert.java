package com.epicness.newfrost.game.stuff;

import static com.badlogic.gdx.utils.Align.center;
import static com.epicness.newfrost.game.GameConstants.ALERT_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Text;

public class Alert {

    private final Sprited sprited;
    private final Text text;
    private float progress;
    private boolean turningRed;

    public Alert(Sprite alertSprite, BitmapFont font) {
        sprited = new Sprited(alertSprite);
        sprited.setSize(ALERT_SIZE);
        text = new Text(font);
        text.setTextTargetWidth(sprited.getWidth());
        text.setHorizontalAlignment(center);
        setX(-ALERT_SIZE);
    }

    public void draw(SpriteBatch spriteBatch) {
        sprited.draw(spriteBatch);
        text.draw(spriteBatch);
    }

    public void setColor(Color color) {
        sprited.setColor(color);
        text.setColor(color);
    }

    public float getX() {
        return sprited.getX();
    }

    public void setX(float x) {
        sprited.setX(x);
        text.setX(x);
    }

    public void setY(float y) {
        sprited.setY(y);
        text.setY(y);
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public boolean isTurningRed() {
        return turningRed;
    }

    public void setTurningRed(boolean turningRed) {
        this.turningRed = turningRed;
    }
}