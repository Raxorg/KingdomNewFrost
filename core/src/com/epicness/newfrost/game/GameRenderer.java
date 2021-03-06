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

        useStaticCamera();
        stuff.getBackground().draw(spriteBatch);
        useDynamicCamera();
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
        stuff.getPlayer().draw(spriteBatch);
        stuff.getVanishingLog().draw(spriteBatch);
        stuff.getMainBuildingMenu().draw(spriteBatch);
        stuff.getDialogue().draw(spriteBatch);
        useStaticCamera();
        stuff.getTutorialWidget().draw(spriteBatch);
        stuff.getTip().draw(spriteBatch);
        stuff.getExpeditionInfo().draw(spriteBatch);
        stuff.getHungerAlert().draw(spriteBatch);
        stuff.getDay().draw(spriteBatch);
        stuff.getDayTimer().draw(spriteBatch);
        stuff.getEventView().draw(spriteBatch);
        stuff.getMessage().draw(spriteBatch);
        stuff.getRain().draw(spriteBatch);
        useDynamicCamera();
        for (int i = 0; i < stuff.getClouds().size; i++) {
            stuff.getClouds().get(i).draw(spriteBatch);
        }
        useStaticCamera();
        stuff.getGameOverMessage().draw(spriteBatch);
        stuff.getHanged().draw(spriteBatch);
        stuff.getHangedText().draw(spriteBatch);
        sharedStuff.getFader().draw(spriteBatch);

        spriteBatch.end();
        //drawDebug();
    }

    private void drawDebug() {
        GameStuff stuff = (GameStuff) this.stuff;

        shapeRenderer.begin();
        shapeRenderer.setColor(Color.GREEN);
        useDynamicCamera();
        for (int i = 0; i < stuff.getCitizens().size; i++) {
            stuff.getCitizens().get(i).drawDebug(shapeRenderer);
        }
        stuff.getPlayer().drawDebug(shapeRenderer);
        shapeRenderer.end();
    }
}