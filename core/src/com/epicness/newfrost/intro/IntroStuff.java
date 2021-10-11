package com.epicness.newfrost.intro;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.newfrost.intro.IntroConstants.SNOWFLAKES;

public class IntroStuff extends Stuff {

    private Sprited[] snow;
    private Text continueText;

    @Override
    public void initializeStuff() {
        IntroAssets assets = (IntroAssets) this.assets;

        snow = new Sprited[SNOWFLAKES];
        for (int i = 0; i < SNOWFLAKES; i++) {
            snow[i] = new Sprited(assets.getSnowflake());
            snow[i].setX(MathUtils.random(0f, CAMERA_WIDTH));
            snow[i].setY(MathUtils.random(0f, CAMERA_HEIGHT));
        }

        continueText = new Text(assets.getPixelFont());
        continueText.setText("SPACE TO CONTINUE");
        continueText.setHorizontalAlignment(Align.center);
        continueText.setTextTargetWidth(CAMERA_WIDTH);
        continueText.setY(100f);
        continueText.setColor(Color.CLEAR);
    }

    public Sprited[] getSnow() {
        return snow;
    }

    public Text getContinueText() {
        return continueText;
    }
}