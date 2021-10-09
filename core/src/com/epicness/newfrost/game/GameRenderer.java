package com.epicness.newfrost.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.newfrost.game.stuff.GameStuff;

public class GameRenderer extends Renderer {
    @Override
    public void render() {
        GameStuff stuff = (GameStuff) this.stuff;

        ScreenUtils.clear(Color.SKY);

        spriteBatch.begin();
        stuff.getDiningTable().draw(spriteBatch);
        for (int i = 0; i < stuff.getCitizens().size; i++) {
            stuff.getCitizens().get(i).draw(spriteBatch);
        }
        spriteBatch.end();
    }
}