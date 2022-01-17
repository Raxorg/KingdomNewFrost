package com.epicness.newfrost.game.stuff;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.IconedSpritedText;
import com.epicness.fundamentals.stuff.Sprited;

public class TutorialSection {

    private Sprited background;
    private DelayedRemovalArray<IconedSpritedText> entries;

    public TutorialSection() {
        entries = new DelayedRemovalArray<>();
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        for (int i = 0; i < entries.size; i++) {
            entries.get(i).draw(spriteBatch);
        }
    }

    public void addEntry(IconedSpritedText iconedSpritedText) {
        entries.add(iconedSpritedText);
    }
}