package com.epicness.newfrost.game.stuff.mainbuildingmenu.tech;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.newfrost.game.GameAssets;

import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES_X;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES_Y;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_DESCRIPTIONS;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_SPACING;

public class TechTree {

    private final Technology[] technologies;

    public TechTree(GameAssets assets, SharedAssets sharedAssets) {
        technologies = new Technology[TECHNOLOGIES];
        for (int i = 0; i < TECHNOLOGIES; i++) {
            Sprite technologySprite;
            switch (MathUtils.random(3)) {
                case 0:
                    technologySprite = assets.getTechIcon0();
                    break;
                case 1:
                    technologySprite = assets.getTechIcon1();
                    break;
                case 2:
                    technologySprite = assets.getTechIcon2();
                    break;
                default:
                    technologySprite = assets.getTechIcon3();
                    break;
            }
            Technology technology = new Technology(
                    technologySprite,
                    sharedAssets.getPixel(),
                    assets.getPixelFont(),
                    TECHNOLOGY_DESCRIPTIONS[i]
            );
            if (i <= 3) {
                technology.setColor(Color.DARK_GRAY);
            }
            technologies[i] = technology;
        }
    }

    // Enable expeditions "already searched"
    // More expedition speed
    // More expedition wood
    // More food per expedition
    // Less wood per repair

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < technologies.length; i++) {
            technologies[i].draw(spriteBatch);
        }
    }

    public void setPosition(float x, float y) {
        for (int i = 0; i < TECHNOLOGIES; i++) {
            float technologyX = (i % 4) * TECHNOLOGY_SPACING + TECHNOLOGIES_X;
            if (i >= 8) {
                technologyX += TECHNOLOGY_SPACING;
            }
            int row = i / 4;
            float technologyY = row * TECHNOLOGY_SPACING + TECHNOLOGIES_Y;
            technologies[i].setPosition(x + technologyX, y + technologyY);
        }
    }
}