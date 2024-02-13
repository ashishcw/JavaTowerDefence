package org.example.gameobjects.homebase;

import org.example.common.GameObject;
import org.example.common.ObjectDefinition;

import java.awt.*;

public class HomeBase extends GameObject {
    public HomeBase(float xPos, float yPos) {
        super(xPos, yPos);

        //setting up the size and color
        this.setSizeWidth(64);
        this.setSizeHeight(124);
        this.setColor(Color.CYAN);

        //setting up the behavior and id types
        this.objectDefinition.objectType = ObjectDefinition.ObjectType.NonWalkableBlock;
        this.objectDefinition.resourceType = ObjectDefinition.ResourceType.None;

        //setting up the hitbox
        this.setHitBox(new Rectangle((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth(), this.getSizeHeight()));

        //setting visibility
        this.setActiveInScene(true);
        this.setVisible(true);

    }

    @Override
    protected void tick() {

    }

    @Override
    protected void render(Graphics g) {
        if(this.isActiveInScene()){
            if(this.isVisible()){
                g.setColor(this.getColor());
                g.fillRect((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth(), this.getSizeHeight());
            }
        }
    }
}
