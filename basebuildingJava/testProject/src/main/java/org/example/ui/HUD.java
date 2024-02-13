package org.example.ui;

import org.example.common.GameObject;
import org.example.utils.MathHelper;

import java.awt.*;

public class HUD extends GameObject {
    public static float HEALTH = 100f;
    public HUD(float xPos, float yPos) {
        super(xPos, yPos);
        this.setSizeWidth(200);
        this.setSizeHeight(32);
    }

    @Override
    protected void tick() {
        if(HEALTH <= 0){
            HEALTH = 100f;
        }else {
            HEALTH -= 0.1f;
            HEALTH = MathHelper.clamp(HEALTH, 100f, 0f);
        }

    }

    @Override
    protected void render(Graphics g) {
        g.setColor(Color.gray);
        //g.fillRect(15, 15, 200,32);
        g.fillRect((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth(),this.getSizeHeight());

        //health
        if(HEALTH >= 70){
            g.setColor(Color.green);
        }else if(HEALTH < 70 && HEALTH >= 30){
            g.setColor(Color.orange);
        }else{
            g.setColor(Color.red);
        }

        //g.fillRect(15, 15, HEALTH * 2,32);
        g.fillRect((int)this.getxPos(), (int)this.getyPos(), (int)HEALTH * 2,this.getSizeHeight());

        //outer
        g.setColor(Color.white);
        //g.drawRect(15, 15, 200,32);
        g.drawRect((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth(),this.getSizeHeight());
    }
}
