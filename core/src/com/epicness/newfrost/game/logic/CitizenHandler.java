package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.GameAssets;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.dialogues.DialogueStorage;
import com.epicness.newfrost.game.stuff.people.Citizen;

import static com.epicness.newfrost.game.GameConstants.STARTING_CITIZENS;

public class CitizenHandler {

    // Structure
    private GameAssets assets;
    private GameStuff stuff;

    public void spawnCitizens() {
        DialogueStorage dialogueStorage = stuff.getDialogueStorage();
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        citizens.clear();
        for (int i = 0; i < STARTING_CITIZENS; i++) {
            Citizen citizen = new Citizen(assets, dialogueStorage.getRandomDialogue());
            citizens.add(citizen);
        }
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}