package com.epicness.newfrost.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;

public class MenuRenderer extends Renderer {

    @Override
    public void render() {
        MenuStuff stuff = (MenuStuff) this.stuff;

        ScreenUtils.clear(Color.SKY);

        spriteBatch.begin();
        stuff.getBackground().draw(spriteBatch);
        stuff.getPlayButton().draw(spriteBatch);
        spriteBatch.end();
    }
}