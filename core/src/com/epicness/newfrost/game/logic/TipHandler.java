package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.newfrost.game.stuff.GameStuff;

import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_X;
import static com.epicness.newfrost.game.GameConstants.TIP_ICON_Y;
import static com.epicness.newfrost.game.GameConstants.TIP_X;
import static com.epicness.newfrost.game.GameConstants.TIP_Y;

public class TipHandler {

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

    public boolean touchUp(float x, float y) {
        if (showingTip) {
            hideTip();
            paused = false;
            return true;
        }
        if (stuff.getTipIcon().contains(x, y)) {
            showTip();
            return true;
        }
        return false;
    }

    public void showTipIcon() {
        paused = true;
        SpritedText tip = stuff.getTip();
        switch (tipIndex) {
            case 0:
                tip.setText("Press A and D to move S to interact when the interaction icon appears");
                break;
            case 1:
                tip.setText("Feed your people with expeditions from the main building");
                break;
            case 2:
                tip.setText("Keep your buildings repaired or they will get cold");
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
        if (time >= 30f) {
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

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}