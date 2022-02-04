package com.epicness.newfrost.game.stuff.events;

import static com.epicness.fundamentals.SharedConstants.BLACK_CLEAR_25;
import static com.epicness.newfrost.game.GameConstants.EVENT_BACKGROUND_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.EVENT_BACKGROUND_WIDTH;
import static com.epicness.newfrost.game.GameConstants.EVENT_BACKGROUND_X;
import static com.epicness.newfrost.game.GameConstants.EVENT_BACKGROUND_Y;
import static com.epicness.newfrost.game.GameConstants.EVENT_IMAGE_SIZE;
import static com.epicness.newfrost.game.GameConstants.EVENT_IMAGE_X;
import static com.epicness.newfrost.game.GameConstants.EVENT_IMAGE_Y;
import static com.epicness.newfrost.game.GameConstants.EVENT_MAX_OPTIONS;
import static com.epicness.newfrost.game.GameConstants.EVENT_OPTION_HEIGHT;
import static com.epicness.newfrost.game.GameConstants.EVENT_OPTION_SPACING;
import static com.epicness.newfrost.game.GameConstants.EVENT_OPTION_WIDTH;
import static com.epicness.newfrost.game.GameConstants.EVENT_OPTION_X;
import static com.epicness.newfrost.game.GameConstants.EVENT_OPTION_Y;
import static com.epicness.newfrost.game.GameConstants.EVENT_TEXT_WIDTH;
import static com.epicness.newfrost.game.GameConstants.EVENT_TEXT_X;
import static com.epicness.newfrost.game.GameConstants.EVENT_TEXT_Y;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.epicness.fundamentals.stuff.Sprited;
import com.epicness.fundamentals.stuff.SpritedText;
import com.epicness.fundamentals.stuff.Text;

public class EventView {

    private final Sprited background, image;
    private final Text text;
    private final DelayedRemovalArray<SpritedText> options;

    public EventView(Sprite backgroundSprite, Sprite pixel, BitmapFont font) {
        background = new Sprited(backgroundSprite);
        background.setPosition(EVENT_BACKGROUND_X, EVENT_BACKGROUND_Y);
        background.setSize(EVENT_BACKGROUND_WIDTH, EVENT_BACKGROUND_HEIGHT);
        background.setColor(BLACK_CLEAR_25);

        image = new Sprited(pixel);
        image.setPosition(EVENT_IMAGE_X, EVENT_IMAGE_Y);
        image.setSize(EVENT_IMAGE_SIZE, EVENT_IMAGE_SIZE);

        text = new Text(font);
        text.setPosition(EVENT_TEXT_X, EVENT_TEXT_Y);
        text.setTextTargetWidth(EVENT_TEXT_WIDTH);
        text.setCenterVertical(true);
        text.setText("TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST");

        options = new DelayedRemovalArray<>();
        for (int i = 0; i < EVENT_MAX_OPTIONS; i++) {
            SpritedText spritedText = new SpritedText(pixel, font);
            spritedText.setPosition(EVENT_OPTION_X + i * EVENT_OPTION_SPACING, EVENT_OPTION_Y);
            spritedText.setSize(EVENT_OPTION_WIDTH, EVENT_OPTION_HEIGHT);
            options.add(spritedText);
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        background.draw(spriteBatch);
        image.draw(spriteBatch);
        text.draw(spriteBatch);
        for (int i = 0; i < options.size; i++) {
            options.get(i).draw(spriteBatch);
        }
    }

    public void setColor(Color color) {
        background.setColor(color);
        image.setColor(color);
        text.setColor(color);
        for (int i = 0; i < options.size; i++) {
            options.get(i).setBackgroundColor(color);
        }
    }

    public void setEvent(Event event) {
        text.setText(event.getDescription());
        image.setSprite(event.getImage());
        for (int i = 0; i < event.getOptions().length; i++) {
            EventOption option = event.getOptions()[i];
            options.get(i).setText(option.getText());
        }
        for (int i = options.size - 1; i >= event.getOptions().length; i--) {
            options.get(i).setBackgroundColor(Color.RED);
        }
    }
}