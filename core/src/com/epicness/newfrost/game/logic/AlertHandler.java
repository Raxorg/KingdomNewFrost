package com.epicness.newfrost.game.logic;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.ALERT_SIZE;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.newfrost.game.stuff.Alert;
import com.epicness.newfrost.game.stuff.GameStuff;
import com.epicness.newfrost.game.stuff.people.Citizen;

public class AlertHandler {

    // Structure
    private GameStuff stuff;
    // Logic
    private boolean showingHungerAlert;

    public void init() {
        stuff.getHungerAlert().setY(CAMERA_HEIGHT / 2f);
        showingHungerAlert = false;
    }

    public void update(float delta) {
        DelayedRemovalArray<Citizen> citizens = stuff.getCitizens();
        calculateHunger(citizens);
        Alert hungerAlert = stuff.getHungerAlert();
        if (showingHungerAlert) {
            updateAlertColor(hungerAlert, delta);
            hungerAlert.setX(Math.min(hungerAlert.getX() + 300f * delta, 0f));
        } else {
            hungerAlert.setColor(Color.WHITE);
            hungerAlert.setX(Math.max(hungerAlert.getX() - 300f * delta, -ALERT_SIZE));
        }
    }

    private void updateAlertColor(Alert alert, float delta) {
        Color color = Color.WHITE.cpy().lerp(Color.RED, alert.getProgress());
        alert.setColor(color);
        if (alert.isTurningRed()) {
            float progress = Math.min(alert.getProgress() + delta, 1f);
            alert.setProgress(progress);
            if (progress == 1f) {
                alert.setTurningRed(false);
            }
        } else {
            float progress = Math.max(alert.getProgress() - delta, 0f);
            alert.setProgress(alert.getProgress() - delta);
            if (progress == 0f) {
                alert.setTurningRed(true);
            }
        }
    }

    private void calculateHunger(DelayedRemovalArray<Citizen> citizens) {
        int hungryCitizens = 0;
        for (int i = 0; i < citizens.size; i++) {
            Citizen citizen = citizens.get(i);
            if (citizen.getHunger() == 2) {
                hungryCitizens++;
            }
        }
        showingHungerAlert = hungryCitizens > 0;
        stuff.getHungerAlert().setText(hungryCitizens + "");
    }

    // Structure
    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}