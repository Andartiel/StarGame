package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.ActionListener;
import ru.geekbrains.base.ResizableButton;

public class PlayButton extends ResizableButton {


    public PlayButton(TextureAtlas atlas, ActionListener actionListener, float scaled) {
        super(atlas.findRegion("btPlay"),actionListener,scaled);
    }
}
