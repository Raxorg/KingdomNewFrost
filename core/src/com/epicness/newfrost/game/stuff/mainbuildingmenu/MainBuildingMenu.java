package com.epicness.newfrost.game.stuff.mainbuildingmenu;

import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_25;
import static com.epicness.newfrost.game.GameConstants.LAW_TAB_X;
import static com.epicness.newfrost.game.GameConstants.BASE_MENU_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.BASE_MENU_WIDTH;
import static com.epicness.newfrost.game.GameConstants.TAB_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.TAB_WIDTH;
import static com.epicness.newfrost.game.GameConstants.TAB_Y;
import static com.epicness.newfrost.game.GameConstants.TECH_TAB_X;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.interfaces.Buttonable;
import com.epicness.newfrost.game.assets.GameAssets;
import com.epicness.newfrost.game.stuff.mainbuildingmenu.tech.TechTree;

public class MainBuildingMenu implements Buttonable {

    private final Sprited background;
    private final SpritedText actionsTab, techTab, lawTab;
    private final ActionPanel actionPanel;
    private final TechTree techTree;
    private final LawTree lawTree;

    public MainBuildingMenu(GameAssets assets, SharedAssets sharedAssets) {
        background = new Sprited(sharedAssets.getPixel());
        background.setSize(BASE_MENU_WIDTH, BASE_MENU_HEIGHT);
        background.setColor(BLACK_CLEAR_25);

        actionsTab = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        actionsTab.setSize(TAB_WIDTH, TAB_HEIGHT);
        actionsTab.setText("ACTIONS");

        techTab = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        techTab.setSize(TAB_WIDTH, TAB_HEIGHT);
        techTab.setText("TECH");

        lawTab = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        lawTab.setSize(TAB_WIDTH, TAB_HEIGHT);
        lawTab.setText("LAWS");

        actionPanel = new ActionPanel(
                sharedAssets.getPixel(),
                assets.getPixelFont(),
                assets.getMeatIcon(),
                assets.getWoodFrame(),
                assets.getBackpackIcon()
        );

        techTree = new TechTree(assets, sharedAssets);

        lawTree = new LawTree();
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        actionsTab.draw(spriteBatch);
        techTab.draw(spriteBatch);
        lawTab.draw(spriteBatch);
        actionPanel.draw(spriteBatch);
        techTree.draw(spriteBatch);
        lawTree.draw(spriteBatch);
    }

    @Override
    public boolean contains(float x, float y) {
        return background.contains(x, y);
    }

    public void setPosition(float x, float y) {
        background.setPosition(x, y);
        actionsTab.setPosition(x, y + TAB_Y);
        techTab.setPosition(x + TECH_TAB_X, y + TAB_Y);
        lawTab.setPosition(x + LAW_TAB_X, y + TAB_Y);
    }

    public void setActionPanelPosition(float x, float y) {
        actionPanel.setPosition(x, y);
    }

    public void setTechTreePosition(float x, float y) {
        techTree.setPosition(x, y);
    }

    public void setLawTreePosition(float x, float y) {
        lawTree.setPosition(x, y);
    }

    public void setActionsTabColor(Color color) {
        actionsTab.setBackgroundColor(color);
    }

    public void setTechTabColor(Color color) {
        techTab.setBackgroundColor(color);
    }

    public void setLawTabColor(Color color) {
        lawTab.setBackgroundColor(color);
    }

    public SpritedText getActionsTab() {
        return actionsTab;
    }

    public SpritedText getTechTab() {
        return techTab;
    }

    public SpritedText getLawTab() {
        return lawTab;
    }

    public ActionPanel getActionPanel() {
        return actionPanel;
    }

    public TechTree getTechTree() {
        return techTree;
    }

    public LawTree getLawTree() {
        return lawTree;
    }
}