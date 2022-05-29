package com.epicness.newfrost.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.epicness.newfrost.NewFrostGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(1200, 700);
        config.setTitle("Frozen Lands");
        new Lwjgl3Application(new NewFrostGame(), config);
    }
}