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

        spriteBatch.setProjectionMatrix(screen.getStaticCamera().combined);

        stuff.getBackground().draw(spriteBatch);

        spriteBatch.setProjectionMatrix(screen.getDynamicCamera().combined);

        for (int i = 0; i < stuff.getBGLayers().length; i++) {
            stuff.getBGLayers()[i].draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getBuildings().size; i++) {
            stuff.getBuildings().get(i).draw(spriteBatch);
        }
        for (int i = 0; i < stuff.getCitizens().size; i++) {
            stuff.getCitizens().get(i).draw(spriteBatch);
        }
        stuff.getActionIcon().draw(spriteBatch);
        useStaticCamera();
        stuff.getWoodInfo().draw(spriteBatch);
        useDynamicCamera();
        stuff.getFoodInfo().draw(spriteBatch);
        stuff.getPlayer().draw(spriteBatch);
        useStaticCamera();
        stuff.getTipIcon().draw(spriteBatch);
        useDynamicCamera();
        stuff.getMainBuildingMenu().draw(spriteBatch);
        useStaticCamera();
        stuff.getTutorialNotification().draw(spriteBatch);
        stuff.getTip().draw(spriteBatch);
        stuff.getExpeditionInfo().draw(spriteBatch);
        stuff.getDay().draw(spriteBatch);
        stuff.getDayTimer().draw(spriteBatch);
        stuff.getEventView().draw(spriteBatch);
        stuff.getRain().draw(spriteBatch);
        useDynamicCamera();
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