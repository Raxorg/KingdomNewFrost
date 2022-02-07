package com.epicness.newfrost.intro.logic;

import com.epicness.newfrost.intro.IntroStuff;

import java.util.Map;

public class SubtitleHandler {

    // Structure
    private IntroStuff stuff;
    // Logic
    private float time;

    public void update(float delta) {
        time += delta;
        for (Map.Entry<Float, String> entry : stuff.getSubtitleData().entrySet()) {
            Float subtitleTime = entry.getKey();
            String subtitle = entry.getValue();
            if (time >= subtitleTime) {
                stuff.getText().setText(subtitle);
                stuff.getSubtitleData().remove(subtitleTime);
                break;
            }
        }
    }

    // Structure
    public void setStuff(IntroStuff stuff) {
        this.stuff = stuff;
    }
}