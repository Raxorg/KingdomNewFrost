package com.epicness.newfrost.intro;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;

public class IntroRenderer extends Renderer {

    @Override
    public void render() {
        IntroStuff stuff = (IntroStuff) this.stuff;

        ScreenUtils.clear(Color.BLACK);

        spriteBatch.begin();

        for (int i = 0; i < stuff.getSnow().length; i++) {
            stuff.getSnow()[i].draw(spriteBatch);
        }
        stuff.getContinueText().draw(spriteBatch);

        spriteBatch.end();
    }
}