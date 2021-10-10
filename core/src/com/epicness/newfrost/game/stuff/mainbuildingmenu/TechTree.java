package com.epicness.newfrost.game.stuff.mainbuildingmenu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.newfrost.game.GameAssets;

import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES_X;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES_Y;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_SIZE;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_SPACING;

public class TechTree {

    private final DelayedRemovalArray<Sprited> technologies;

    public TechTree(GameAssets assets) {
        technologies = new DelayedRemovalArray<>();
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
            Sprited technology = new Sprited(technologySprite);
            technology.setSize(TECHNOLOGY_SIZE);
            if (i <= 3) {
                technology.setColor(Color.DARK_GRAY);
            }
            technologies.add(technology);
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < technologies.size; i++) {
            technologies.get(i).draw(spriteBatch);
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
            technologies.get(i).setPosition(x + technologyX, y + technologyY);
        }
    }
}