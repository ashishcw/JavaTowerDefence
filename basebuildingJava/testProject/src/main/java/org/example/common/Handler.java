package org.example.common;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> allGameObjects = new LinkedList<>();

    public void tick(){
        if(this.allGameObjects.size() > 0){
            for(int i = 0; i < this.allGameObjects.size(); i++){
                if(this.allGameObjects.get(i) != null){
                    this.allGameObjects.get(i).tick();
                }
            }
        }
    }


    public void render(Graphics g){
        if(this.allGameObjects.size() > 0){
            for(int i = 0; i < this.allGameObjects.size(); i++){
                if(this.allGameObjects.get(i) != null){
                    this.allGameObjects.get(i).render(g);
                }
            }
        }
    }

    public void addGameObjectToList(GameObject tempObject){
        if(this.allGameObjects != null){
            if(!this.allGameObjects.contains(tempObject)){
                this.allGameObjects.add(tempObject);
            }
        }
    }

    public void removeGameObjectFromList(GameObject tempObject){
        if(this.allGameObjects != null){
            if(this.allGameObjects.contains(tempObject)){
                this.allGameObjects.remove(tempObject);
            }
        }
    }


}
