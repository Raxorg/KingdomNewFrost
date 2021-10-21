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
        stuff.getBackground().draw(spriteBatch);
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            stuff.getBuildings().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getCitizens().size; i++) {
            stuff.getCitizens().get(i).draw(spriteBatch);
        }
        stuff.getActionIcon().draw(spriteBatch);
        stuff.getWoodInfo().draw(spriteBatch);
        stuff.getFoodInfo().draw(spriteBatch);
        stuff.getPlayer().draw(spriteBatch);
        stuff.getTipIcon().draw(spriteBatch);
        stuff.getMainBuildingMenu().draw(spriteBatch);
        stuff.getTip().draw(spriteBatch);
        stuff.getExpeditionInfo().draw(spriteBatch);
        stuff.getDay().draw(spriteBatch);
        stuff.getDayTimer().draw(spriteBatch);
        stuff.getEventView().draw(spriteBatch);
        stuff.getRain().draw(spriteBatch);
        stuff.getGameOver().draw(spriteBatch);
        spriteBatch.end();

        //drawDebug();
    }

    private void drawDebug() {
        GameStuff stuff = (GameStuff) this.stuff;

        shapeRenderer.begin();
        for (int i = 0; i < stuff.getCitizens().size; i++) {
            stuff.getCitizens().get(i).drawDebug(shapeRenderer);
        }
        shapeRenderer.end();
    }
}