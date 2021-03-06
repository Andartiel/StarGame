package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private SpriteBatch batch;
    private Texture img;

    private Vector2 pos;
    private Vector2 v;
    private Vector2 mouseTouch;
    private Vector2 buferVector;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0,0);
        mouseTouch = new Vector2(0f,0f);
        v = new Vector2(0.5f,0.3f);
        buferVector = new Vector2(0f,0f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.128f, 0.53f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buferVector.set(mouseTouch);
        if(buferVector.sub(pos).len() >0.9f){
            pos.add(v);
        } else
            pos.set(mouseTouch);
        batch.begin();
        batch.draw(img, pos.x, pos.y,64,64);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mouseTouch.set(screenX,Gdx.graphics.getHeight()-screenY);//Gdx.graphics.getHeight-screenY
        v.set(mouseTouch.cpy().sub(pos).setLength(0.9f));//;
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
