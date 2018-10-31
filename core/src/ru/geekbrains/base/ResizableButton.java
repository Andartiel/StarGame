package ru.geekbrains.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class ResizableButton extends Sprite {

    private int pointer;
    private static boolean isTouch;
    private static float scaled;
    static ActionListener actionListener;

    public ResizableButton(TextureRegion region,ActionListener actionListener, float scaled) {
        super(region);
        this.scaled = scaled;
        this.isTouch = false;
        this.actionListener = actionListener;
    }

    @Override
    public static void touchDown(Vector2 touch, int pointer) {
        if(isTouch || !isMe(touch)){
            return;
        }
        this.pointer = pointer;
        this.scale = scaled;
        this.isTouch = true;

    }

    @Override
    public void touchUp(Vector2 touch, int pointer) {
        if(this.pointer != pointer || !isTouch){
            return ;
        }
        if(isMe(touch)){
            actionListener.actionPerformed(this);
            return ;
        }
        this.isTouch = false;
        this.scale = 1f;
        return ;
    }
}
