package com.epicness.newfrost.game.stuff.mainbuildingmenu.tech;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.assets.SharedAssets;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Text;
import com.epicness.newfrost.game.GameAssets;

import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES_X;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGIES_Y;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_COSTS;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_DESCRIPTIONS;
import static com.epicness.newfrost.game.GameConstants.TECHNOLOGY_SPACING;
import static com.epicness.newfrost.game.GameConstants.TECH_DESCRIPTION_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.TECH_DESCRIPTION_WIDTH;
import static com.epicness.newfrost.game.GameConstants.TECH_TREE_WOOD_ICON_SIZE;

public class TechTree {

    private final Technology[] technologies;
    private final SpritedText techDescription;
    private final Sprited woodIcon;
    private final Text cost;

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
                    TECHNOLOGY_DESCRIPTIONS[i],
                    TECHNOLOGY_COSTS[i]
            );
            if (i <= 3) {
                technology.setColor(Color.DARK_GRAY);
            }
            technologies[i] = technology;
        }

        techDescription = new SpritedText(sharedAssets.getPixel(), assets.getPixelFont());
        techDescription.setSize(TECH_DESCRIPTION_WIDTH, TECH_DESCRIPTION_HEIGHT);
        techDescription.setColor(Color.BLACK);

        woodIcon = new Sprited(assets.getWoodFrame());
        woodIcon.setSize(TECH_TREE_WOOD_ICON_SIZE);

        cost = new Text(assets.getPixelFont());
        cost.setTextTargetWidth(TECH_TREE_WOOD_ICON_SIZE);
        cost.setCenterVertical(true);
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < technologies.length; i++) {
            technologies[i].draw(spriteBatch);
        }
        woodIcon.draw(spriteBatch);
        cost.draw(spriteBatch);
        techDescription.draw(spriteBatch);
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
        techDescription.setPosition(x, y);
        woodIcon.setPosition(x, y);
    }

    public void setTechnologyCost(int techCost) {
        cost.setText(techCost + "");
    }

    public void setTechCostPosition(float x, float y) {
        woodIcon.setPosition(x, y);
        cost.setPosition(x + TECH_TREE_WOOD_ICON_SIZE, y + TECH_TREE_WOOD_ICON_SIZE / 2f);
    }

    public void setTechDescription(String description) {
        techDescription.setText(description);
    }

    public Technology[] getTechnologies() {
        return technologies;
    }
}