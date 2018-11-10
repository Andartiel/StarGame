package ru.geekbrains.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Ship;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;


public class Enemy extends Ship {
    private enum MODE {DAWN, SHOOT}

    private MODE MODE;

    private Vector2 v0 = new Vector2();
    private Vector2 dawnV = new Vector2(0, -0.1f);

    public Enemy(BulletPool bulletPool, Rect worldBounds, Sound shootSound) {
        super(shootSound);
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        this.v.set(v0);
        this.MODE = MODE.DAWN;
        this.v.set(dawnV);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
        switch (MODE) {
            case DAWN:
                if (getTop() <= worldBounds.getTop()) {
                    v.set(v0);
                    MODE = MODE.SHOOT;
                }
                break;
            case SHOOT:
                pos.mulAdd(v, delta);
                reloadTimer += delta;
                if (reloadTimer >= reloadInterval) {
                    shoot();
                    reloadTimer = 0f;
                }
                break;
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int bulletDamage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0f, bulletVY);
        this.bulletDamage = bulletDamage;
        this.reloadInterval = reloadInterval;
        this.hp = hp;
        setHeightProportion(height);
        this.v.set(dawnV);
    }
}
