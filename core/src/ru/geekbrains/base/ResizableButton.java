package ru.geekbrains.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class ResizableButton extends Sprite {

    private int pointer;
    private boolean isTouch;
    private float scaled;
    ActionListener actionListener;

    public ResizableButton(TextureRegion region,ActionListener actionListener, float scaled) {
        super(region);
        this.scaled = scaled;
        this.isTouch = false;
        this.actionListener = actionListener;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if(isTouch || !isMe(touch)){
            return false;
        }
        this.pointer = pointer;
        scale = scaled;
        this.isTouch = true;
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if(this.pointer != pointer || !isTouch){
            return false;
        }
        if(isMe(touch)){
            actionListener.actionPerformed(this);
            return false;
        }
        this.isTouch = false;
        this.scale = 1f;
        return false;
    }
}
