package com.epicness.newfrost.game.stuff.dialogues;

import com.badlogic.gdx.math.MathUtils;

public class DialogueStorage {

    private final Dialogue[] dialogues;

    public DialogueStorage() {
        dialogues = new Dialogue[3];
        dialogues[0] = new Dialogue(
                "Morning sir",
                "I dont like this weather at all",
                "I dont think we will make it"
        );
        dialogues[1] = new Dialogue(
                "Each day we are fewer",
                "I cant believe this cold",
                "I cant feel my hands"
        );
        dialogues[2] = new Dialogue(
                "I dont want to die",
                "Please feed us",
                "The cold is messing with my mind"
        );
    }

    public Dialogue getRandomDialogue() {
        int random = MathUtils.random(2);
        return dialogues[random];
    }
}