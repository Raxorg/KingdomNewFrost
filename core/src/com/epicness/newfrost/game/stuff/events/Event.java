package com.epicness.newfrost.game.stuff.events;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Event {

    private String description;
    private Sprite image;
    private EventOption[] options;

    public Event(String description, Sprite image, EventOption[] options) {

    }

    public Event(String description, EventOption[] options) {

    }

    public String getDescription() {
        return description;
    }

    public Sprite getImage() {
        return image;
    }

    public EventOption[] getOptions() {
        return options;
    }
}