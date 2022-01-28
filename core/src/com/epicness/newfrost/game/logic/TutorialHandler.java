package com.epicness.newfrost.game.logic;

import static com.epicness.newfrost.game.GameConstants.COLD_PROTECTION_TUTORIAL_TEXT;
import static com.epicness.newfrost.game.GameConstants.CONTROLS_TUTORIAL_TEXT;
import static com.epicness.newfrost.game.GameConstants.FEED_TUTORIAL_TEXT;
import static com.epicness.newfrost.game.GameConstants.GAME_OVER_TUTORIAL_TEXT;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;
import static com.epicness.newfrost.game.GameConstants.HUNGER_TUTORIAL_TEXT;
import static com.epicness.newfrost.game.GameConstants.TUTORIAL_DIALOGUE_X;
import static com.epicness.newfrost.game.GameConstants.TUTORIAL_DIALOGUE_Y;
import static com.epicness.newfrost.game.GameConstants.TUTORIAL_WIDGET_SLIDE_DURATION;
import static com.epicness.newfrost.game.GameConstants.TUTORIAL_WIDGET_WIDTH;
import static com.epicness.newfrost.game.enums.Tutorial.CONTROLS;

import com.epicness.fundamentals.stuff.IconedSpritedText;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.newfrost.game.enums.Tutorial;
import com.epicness.newfrost.game.stuff.GameStuff;

public class TutorialHandler {

    private GameStuff stuff;
    // Logic
    private float time;
    private boolean showingTip, showingTipIcon, slidingIn;

    public void init() {
        hideTip();
        showTutorialWidget(CONTROLS);
    }

    private void hideTip() {
        stuff.getTip().setPosition(HIDDEN_X, HIDDEN_Y);
        showingTip = false;
    }

    private void showTip() {
        stuff.getTip().setPosition(TUTORIAL_DIALOGUE_X, TUTORIAL_DIALOGUE_Y);
        showingTip = true;
        hideTutorialWidget();
    }

    public void touchUp(float x, float y) {
        if (showingTip) {
            hideTip();
            return;
        }
        if (stuff.getTutorialWidget().contains(x, y)) {
            showTip();
        }
    }

    public void showTutorialWidget(Tutorial tutorial) {
        slidingIn = true;
        SpritedText tutorialDialogue = stuff.getTip();
        stuff.getTutorialWidget().setText(tutorial.getText());
        switch (tutorial) {
            case CONTROLS:
                tutorialDialogue.setText(CONTROLS_TUTORIAL_TEXT);
                break;
            case FEEDING:
                tutorialDialogue.setText(FEED_TUTORIAL_TEXT);
                break;
            case HUNGER:
                tutorialDialogue.setText(HUNGER_TUTORIAL_TEXT);
                break;
            case COLD_PROTECTION:
                tutorialDialogue.setText(COLD_PROTECTION_TUTORIAL_TEXT);
                break;
            case GAME_OVER:
                tutorialDialogue.setText(GAME_OVER_TUTORIAL_TEXT);
                break;
            default:
                break;
        }
        showingTipIcon = true;
        time = 0f;
    }

    private void hideTutorialWidget() {
        stuff.getTutorialWidget().setX(-TUTORIAL_WIDGET_WIDTH);
    }

    public void update(float delta) {
        if (!showingTipIcon || !slidingIn) {
            return;
        }
        IconedSpritedText tutorialWidget = stuff.getTutorialWidget();
        time += delta;
        float progress = Math.min(time / TUTORIAL_WIDGET_SLIDE_DURATION, 1f);
        if (progress == 1f) {
            slidingIn = false;
        }
        tutorialWidget.setX(-TUTORIAL_WIDGET_WIDTH + TUTORIAL_WIDGET_WIDTH * progress);
    }

    public boolean isShowingTip() {
        return showingTip;
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}