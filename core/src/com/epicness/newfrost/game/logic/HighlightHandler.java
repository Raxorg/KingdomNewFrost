package com.epicness.newfrost.game.logic;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

public class HighlightHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    float lastX, lastY;
    private Citizen lastHighlightedCitizen;
    private boolean enabled = true;

    public void mouseMoved(float x, float y) {
        lastX = x;
        lastY = y;
    }

    public void update() {
        if (!enabled) {
            return;
        }
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        DelayedRemovalArray<Citizen> candidates = new DelayedRemovalArray<>();
        for (int i = 0; i < citizens.size; i++) {
            Citizen citizen = citizens.get(i);
            if (citizen.contains(lastX, lastY)) {
                candidates.add(citizen);
            }
        }
        if (candidates.isEmpty()) {
            if (lastHighlightedCitizen != null) {
                lastHighlightedCitizen.setColor(Color.WHITE);
            }
            return;
        }
        Citizen closest = candidates.first();
        float closestDistance = Math.abs(closest.getCenterX() - lastX);
        for (int i = 0; i < candidates.size; i++) {
            Citizen citizen = candidates.get(i);
            if (Math.abs(citizen.getCenterX() - lastX) < closestDistance) {
                closest = citizen;
            }
        }
        if (lastHighlightedCitizen != null) {
            lastHighlightedCitizen.setColor(Color.WHITE);
        }
        closest.setColor(Color.GRAY);
        lastHighlightedCitizen = closest;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (!enabled) {
            if (lastHighlightedCitizen != null) {
                lastHighlightedCitizen.setColor(Color.WHITE);
            }
        }
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}