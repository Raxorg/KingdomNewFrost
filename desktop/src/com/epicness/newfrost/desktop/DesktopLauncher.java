package com.epicness.newfrost.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.epicness.newfrost.NewFrostGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1400;
		config.height = 700;
		config.forceExit = false;
		new LwjglApplication(new NewFrostGame(), config);
	}
}
