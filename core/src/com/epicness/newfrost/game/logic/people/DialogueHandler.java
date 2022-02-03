package com.epicness.newfrost.game.logic.people;

import static com.epicness.newfrost.game.GameConstants.CITIZEN_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.DIALOGUE_WIDTH;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_X;
import static com.epicness.newfrost.game.GameConstants.HIDDEN_Y;

import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

public class DialogueHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private Citizen selectedCitizen;

    public void hideDialogue() {
        SpritedText dialogue = stuff.getDialogue();
        dialogue.setPosition(HIDDEN_X, HIDDEN_Y);
    }

    public void touchDown() {
        selectedCitizen = logic.getCitizenHighlightHandler().getHighlightedCitizen();
    }

    public void update() {
        if (selectedCitizen == null) {
            hideDialogue();
            return;
        }
        SpritedText dialogue = stuff.getDialogue();
        float x = selectedCitizen.getCenterX() - DIALOGUE_WIDTH / 2f;
        float y = selectedCitizen.getY() + CITIZEN_HEIGHT;
        dialogue.setPosition(x, y);
        dialogue.setText(selectedCitizen.getDialogue().getHungerPhrase(selectedCitizen.getHunger()));
    }

    // Structure
    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}