package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;


import ru.geekbrains.base.ActionListener;
import ru.geekbrains.base.ResizableButton;

public class ExitButton extends ResizableButton {


    public ExitButton(TextureAtlas atlas, ActionListener actionListener, float scaled) {
        super(atlas.findRegion("btExit"),actionListener,scaled);
    }
}
