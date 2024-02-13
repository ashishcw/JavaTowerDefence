package org.example.gameobjects.resources;

import org.example.common.GameObject;
import org.example.common.ObjectDefinition;

import java.awt.*;

public class WoodResource extends GameObject {
    public WoodResource(float xPos, float yPos) {
        super(xPos, yPos);

        //setting up the size and color
        this.setSizeWidth(64);
        this.setSizeHeight(64);
        this.setColor(new Color(154,89,56));//woody color

        //setting up the behavior and id types
        this.objectDefinition.objectType = ObjectDefinition.ObjectType.ResourceBlock;
        this.objectDefinition.resourceType = ObjectDefinition.ResourceType.WoodResource;

        //setting up the hitbox
        this.setHitBox(new Rectangle((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth(), this.getSizeHeight()));

    }

    @Override
    protected void tick() {

    }

    @Override
    protected void render(Graphics g) {
        g.setColor(this.getColor());
        g.fillRect((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth(), this.getSizeHeight());
    }
}
