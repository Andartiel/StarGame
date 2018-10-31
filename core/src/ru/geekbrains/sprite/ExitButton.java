package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;


import ru.geekbrains.base.ActionListener;
import ru.geekbrains.base.ResizableButton;
import ru.geekbrains.math.Rect;

public class ExitButton extends ResizableButton {


    public ExitButton(TextureAtlas atlas, ActionListener actionListener, float scaled) {
        super(atlas.findRegion("btExit"),actionListener,scaled);
    }

    @Override
    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setRight(worldBounds.getRight());
    }
}
