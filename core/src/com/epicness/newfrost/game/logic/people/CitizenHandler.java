package com.epicness.newfrost.game.logic.people;

import static com.epicness.newfrost.game.GameConstants.STARTING_CITIZENS;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.logic.GameLogic;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.dialogues.DialogueStorage;
import com.epicness.newfrost.game.stuff.people.Citizen;

public class CitizenHandler {

    // Structure
    private GameAssets assets;
    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private int aliveCitizens;

    public void spawnCitizens() {
        DialogueStorage dialogueStorage = stuff.getDialogueStorage();
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        citizens.clear();
        for (int i = 0; i < STARTING_CITIZENS; i++) {
            Citizen citizen = new Citizen(assets, dialogueStorage.getFoodDialogue());
            citizens.add(citizen);
        }
        citizens.sort((citizen1, citizen2) -> citizen1.getY() > citizen2.getY() ? -1 : 0);
        aliveCitizens = STARTING_CITIZENS;
    }

    public void citizenDied() {
        aliveCitizens--;
        if (aliveCitizens <= 5) {
            logic.getGameOverHandler().lessThan6Citizens();
        }
    }

    public int getAliveCitizens() {
        return aliveCitizens;
    }

    // Structure
    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}