package com.epicness.newfrost.game.logic.people;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

public class CitizenHighlightHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    float lastX, lastY;
    private boolean enabled = true;
    private Citizen highlightedCitizen;

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
            highlightedCitizen = null;
            return;
        }
        highlightedCitizen = candidates.first();
        float closestDistance = Math.abs(highlightedCitizen.getCenterX() - lastX);
        for (int i = 0; i < candidates.size; i++) {
            Citizen citizen = candidates.get(i);
            if (Math.abs(citizen.getCenterX() - lastX) < closestDistance) {
                highlightedCitizen = citizen;
            }
        }
        highlightedCitizen.setColor(Color.NAVY.cpy().lerp(Color.LIGHT_GRAY, 0.5f));
    }

    public void updateLastCursorPosition(float cameraOffset) {
        lastX += cameraOffset;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Citizen getHighlightedCitizen() {
        return highlightedCitizen;
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}