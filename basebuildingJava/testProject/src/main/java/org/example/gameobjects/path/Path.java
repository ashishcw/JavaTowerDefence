package org.example.gameobjects.path;

import org.example.common.GameObject;
import org.example.common.ObjectDefinition;

import java.awt.*;

public class Path extends GameObject {
    public Path(float xPos, float yPos) {
        super(xPos, yPos);

        //setting up the size and color
        this.setSizeHeight(32);
        this.setSizeWidth(32);
        this.setColor(Color.BLACK);

        //setting up the behavior and id types
        this.objectDefinition.objectType = ObjectDefinition.ObjectType.Path;
        this.objectDefinition.resourceType = ObjectDefinition.ResourceType.None;

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
