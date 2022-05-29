package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;

import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.newfrost.game.stuff.GameStuff;

public class MessageHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    private boolean showingMessage;
    private float progress;

    public void init() {
        showingMessage = false;
        stuff.getMessage().setY(HIDDEN_Y);
    }

    public void update(float delta) {
        if (!showingMessage) {
            return;
        }
        SpritedText message = stuff.getMessage();
        message.translateY(100f * delta);
        progress += delta;
        if (progress >= 1f) {
            message.setY(HIDDEN_Y);
            showingMessage = false;
        }
    }

    public void showMessage(float x, float y, String text) {
        showingMessage = true;
        SpritedText message = stuff.getMessage();
        message.setPosition(x, y);
        message.setText(text);
        progress = 0f;
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}