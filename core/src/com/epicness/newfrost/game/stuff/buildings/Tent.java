package com.epicness.newfrost.game.stuff.buildings;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.epicness.fundamentals.stuff.Sprited;

import static com.epicness.newfrost.game.GameConstants.TENT_SIZE;
import static com.epicness.newfrost.game.enums.BuildingType.TENT;

public class Tent extends Building {

    private final Sprited tentUpgrade;
    private boolean upgraded;

    public Tent(Sprite tentSprite, Sprite tentUpgradeSprite) {
        super(tentSprite, TENT);
        sprited.setSize(TENT_SIZE);
        tentUpgrade = new Sprited(tentUpgradeSprite);
        tentUpgrade.setSize(TENT_SIZE);
    }

    public void draw(SpriteBatch spriteBatch) {
        super.draw(spriteBatch);
        if (upgraded) {
            tentUpgrade.draw(spriteBatch);
        }
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        tentUpgrade.setPosition(x, y);
    }

    @Override
    public void flipX() {
        super.flipX();
        tentUpgrade.setFlip(true, false);
    }

    public boolean isUpgraded() {
        return upgraded;
    }

    public void upgrade() {
        upgraded = true;
    }
}