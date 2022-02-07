package com.epicness.newfrost.intro.logic;

import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.input.SharedInput;
import com.epicness.fundamentals.logic.Logic;
import com.epicness.fundamentals.logic.SharedLogic;
import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.newfrost.intro.IntroAssets;
import com.epicness.newfrost.intro.IntroStuff;

public class IntroLogic extends Logic {

    private final IntroHandler introHandler;
    private final IntroInputHandler introInputHandler;
    private final SubtitleHandler subtitleHandler;

    public IntroLogic(SharedLogic sharedLogic) {
        super(sharedLogic);

        introHandler = new IntroHandler();
        introInputHandler = new IntroInputHandler();
        subtitleHandler = new SubtitleHandler();

        introHandler.setSharedLogic(sharedLogic);

        introInputHandler.setLogic(this);
    }

    @Override
    public void initialLogic() {
        introHandler.playNarration();
        introInputHandler.setupInput();
    }

    @Override
    public void update(float delta) {
        sharedLogic.getAssetLoader().update();
        sharedLogic.getTransitionHandler().update();

        introHandler.update(delta);
        subtitleHandler.update(delta);
    }

    @Override
    public void setAssets(Assets assets) {
        IntroAssets introAssets = (IntroAssets) assets;

        introHandler.setAssets(introAssets);
    }

    @Override
    public void setInput(SharedInput input) {
        introInputHandler.setInput(input);
    }

    @Override
    public void setStuff(Stuff stuff) {
        IntroStuff introStuff = (IntroStuff) stuff;

        introHandler.setStuff(introStuff);
        introInputHandler.setStuff(introStuff);
        subtitleHandler.setStuff(introStuff);
    }

    public IntroHandler getIntroHandler() {
        return introHandler;
    }
}