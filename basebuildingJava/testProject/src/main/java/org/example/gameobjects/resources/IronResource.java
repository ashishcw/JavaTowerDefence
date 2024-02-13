package org.example.gameobjects.resources;

import org.example.common.GameObject;
import org.example.common.ObjectDefinition;

import java.awt.*;

public class IronResource extends GameObject {
    public float gatheringRate = 0.05f;
    public IronResource(float xPos, float yPos) {
        super(xPos, yPos);

        //setting up the size and color
        this.setSizeWidth(64);
        this.setSizeHeight(64);
        this.setColor(new Color(105,107,94));

        //setting up the behavior and id types
        this.objectDefinition.objectType = ObjectDefinition.ObjectType.ResourceBlock;
        this.objectDefinition.resourceType = ObjectDefinition.ResourceType.IronResource;

        //setting up the hitbox
        this.setHitBox(new Rectangle((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth(), this.getSizeHeight()));

        //setting visibility
        this.setActiveInScene(true);
        this.setVisible(true);

    }

    @Override
    protected void tick() {
        if(this.isActiveInScene()){

        }
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
