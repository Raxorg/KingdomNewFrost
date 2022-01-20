package com.epicness.newfrost.game.enums;

public enum Tutorial {

    CONTROLS("Controls"),
    FEEDING("Food"),
    HUNGER("Hunger"),
    COLD_PROTECTION("Cold"),
    GAME_OVER("Game over");

    private final String text;

    Tutorial(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}