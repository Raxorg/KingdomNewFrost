package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.newfrost.game.stuff.GameStuff;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_X;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_Y;
import static com.epicness.newfrost.game.GameConstants.TIP_INTERVAL;
import static com.epicness.newfrost.game.GameConstants.TIP_X;
import static com.epicness.newfrost.game.GameConstants.TIP_Y;

public class TutorialHandler {

    private GameStuff stuff;
    // Logic
    private int tipIndex;
    private float time, alpha;
    private boolean paused, showingTip, showingTipIcon, fadingIn;

    public void hideTip() {
        stuff.getTip().setPosition(HIDDEN_X, HIDDEN_Y);
        showingTip = false;
    }

    public void showTip() {
        stuff.getTip().setPosition(TIP_X, TIP_Y);
        showingTip = true;
        hideTipIcon();
    }

    public void touchUp(float x, float y) {
        if (showingTip) {
            hideTip();
            paused = false;
            return;
        }
        if (stuff.getTipIcon().contains(x, y)) {
            showTip();
        }
    }

    public void showTipIcon() {
        paused = true;
        SpritedText tip = stuff.getTip();
        switch (tipIndex) {
            case 0:
                tip.setText("Press A and D to move S to interact when the interaction icon appears");
                break;
            case 1:
                tip.setText("Feed your people with food from expeditions you can deploy from the base");
                break;
            case 2:
                tip.setText("People feel hungry each 2 days and need 1 food ration to stabilize");
                break;
            case 3:
                tip.setText("Upgrade the dwellings for better protection against cold");
                break;
            case 4:
                tip.setText("When half the population dies the game is over");
                break;
            default:
                break;
        }
        tipIndex++;
        stuff.getTipIcon().setPosition(TIP_ICON_X, TIP_ICON_Y);
        showingTipIcon = true;
    }

    private void hideTipIcon() {
        stuff.getTipIcon().setPosition(HIDDEN_X, HIDDEN_Y);
        showingTipIcon = false;
    }

    public void update(float delta) {
        if (!paused) {
            time += delta;
        }
        if (time >= TIP_INTERVAL) {
            showTipIcon();
            time = 0f;
        }
        if (!showingTipIcon) {
            return;
        }
        Sprited tipIcon = stuff.getTipIcon();
        if (fadingIn) {
            alpha = Math.min(alpha + delta, 1f);
            if (alpha == 1f) {
                fadingIn = false;
            }
        } else {
            alpha = Math.max(alpha - delta, 0f);
            if (alpha == 0f) {
                fadingIn = true;
            }
        }
        tipIcon.setColor(new Color(1f, 1f, 1f, alpha));
    }

    public boolean isShowingTip() {
        return showingTip;
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}