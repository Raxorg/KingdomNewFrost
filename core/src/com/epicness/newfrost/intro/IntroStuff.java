package com.epicness.newfrost.intro;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;
import static com.epicness.newfrost.intro.IntroConstants.SNOWFLAKES;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Align;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.Text;

import java.util.HashMap;

public class IntroStuff extends Stuff {

    private HashMap<Float, String> subtitleData;
    private Text text;
    private Sprited[] snow;

    @Override
    public void initializeStuff() {
        IntroAssets assets = (IntroAssets) this.assets;

        subtitleData = new HashMap<>();
        subtitleData.put(0f, "I am alone in my room, sitting...");
        subtitleData.put(2.95f, "Staring at a fixed spot on the wall");
        subtitleData.put(5.8f, "My first thought goes towards the fight that we all started until we took out the tyrant");
        subtitleData.put(12.2f, "I am the chosen one to lead this community");
        subtitleData.put(15.6f, "Oh God why me?");
        subtitleData.put(19f, "We are plunged into deep darkness and cannot see the sunlight");
        subtitleData.put(24.5f, "The so penetrating cold is a daily torture");
        subtitleData.put(29f, "I must decide over the lives of others");
        subtitleData.put(32.8f, "If necessary I will make sacrifices for the sake of the majority");
        subtitleData.put(37.5f, "The faces of every person that fought and lost haunt me...");
        subtitleData.put(43f, "They judge me.");
        subtitleData.put(45.3f, "My biggest fear is that this fight is only to prolong our suffering.");

        text = new Text(assets.getPixelFont());
        text.setHorizontalAlignment(Align.center);
        text.setCenterVertical(true);
        text.setX((CAMERA_WIDTH * 0.05f) / 2f);
        text.setTextTargetWidth(CAMERA_WIDTH * 0.95f);
        text.setY(CAMERA_HEIGHT / 2f);
        text.setText("I am alone in my room, sitting...");

        snow = new Sprited[SNOWFLAKES];
        for (int i = 0; i < SNOWFLAKES; i++) {
            snow[i] = new Sprited(assets.getSnowflake());
            snow[i].setX(MathUtils.random(0f, CAMERA_WIDTH));
            snow[i].setY(MathUtils.random(0f, CAMERA_HEIGHT));
        }
    }

    public HashMap<Float, String> getSubtitleData() {
        return subtitleData;
    }

    public Text getText() {
        return text;
    }

    public Sprited[] getSnow() {
        return snow;
    }
}