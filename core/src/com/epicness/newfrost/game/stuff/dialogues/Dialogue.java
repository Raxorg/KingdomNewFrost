package com.epicness.newfrost.game.stuff.dialogues;

import com.badlogic.gdx.math.MathUtils;

public class Dialogue {

    private final String[] phrases;
    private final boolean[] usage;

    public Dialogue(String... phrases) {
        this.phrases = phrases;
        usage = new boolean[phrases.length];
    }

    public String getRandomPhrase() {
        int tries = 0;
        boolean used;
        int random;
        do {
            random = MathUtils.random(phrases.length - 1);
            used = usage[random];
            tries++;
        } while (tries <= 10 && used);
        usage[random] = true;
        return phrases[random];
    }
}