package org.example.gameobjects;

import org.example.common.GameObject;
import org.example.common.Handler;
import org.example.common.ObjectDefinition;
import org.example.gameobjects.resources.IronResource;
import org.example.input.KeyInputHandler;
import org.example.utils.MathHelper;

import java.awt.*;

public class Player extends GameObject {

    private float acc = 1f;

    private float dcc = 0.5f;

    private KeyInputHandler keyInputHandler;

    private GameObject IronResourceObject, WoodResourceObject, WaterResourceObject;

    private Handler handler;

    public Player(int xPos, int yPos, KeyInputHandler keyInputHandlerParam, Handler handlerParam) {
        super(xPos, yPos);
        this.keyInputHandler = keyInputHandlerParam;
        this.handler = handlerParam;
        this.setSizeWidth(16);
        this.setSizeHeight(16);
        this.setColor(Color.GREEN);
        this.setActiveInScene(true);
        this.setVisible(true);
        this.objectDefinition.objectType = ObjectDefinition.ObjectType.Player;
        this.objectDefinition.resourceType = ObjectDefinition.ResourceType.None;
        this.setHitBox(new Rectangle((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth()*2, this.getSizeHeight()*2));


        //get iron block
        if(this.IronResourceObject == null){
            for(int i = 0; i < this.handler.allGameObjects.size(); i++){
                if(this.handler.allGameObjects.get(i).getObjectDefinition().objectType == ObjectDefinition.ObjectType.ResourceBlock){
                    if(this.handler.allGameObjects.get(i).getObjectDefinition().resourceType == ObjectDefinition.ResourceType.IronResource){
                        this.IronResourceObject = this.handler.allGameObjects.get(i);
                        break;
                    }
                }
            }
        }

        //get Wood block
        if(this.WoodResourceObject == null){
            for(int i = 0; i < this.handler.allGameObjects.size(); i++){
                if(this.handler.allGameObjects.get(i).getObjectDefinition().objectType == ObjectDefinition.ObjectType.ResourceBlock){
                    if(this.handler.allGameObjects.get(i).getObjectDefinition().resourceType == ObjectDefinition.ResourceType.WoodResource){
                        this.WoodResourceObject = this.handler.allGameObjects.get(i);
                        break;
                    }
                }
            }
        }


        //get Water block
        if(this.WaterResourceObject == null){
            for(int i = 0; i < this.handler.allGameObjects.size(); i++){
                if(this.handler.allGameObjects.get(i).getObjectDefinition().objectType == ObjectDefinition.ObjectType.ResourceBlock){
                    if(this.handler.allGameObjects.get(i).getObjectDefinition().resourceType == ObjectDefinition.ResourceType.WaterResource){
                        this.WaterResourceObject = this.handler.allGameObjects.get(i);
                        break;
                    }
                }
            }
        }


    }

    @Override
    protected void tick() {
        if(this.isActiveInScene()){
            //this.setxPos(this.getxPos() + 0.8f);
            this.xPos += this.getVelX();
            this.yPos += this.getVelY();

            //Horizontal movement(A & D Key press)
            if(this.keyInputHandler.keys[0]){
                this.velX += this.acc;
            }
            else if(this.keyInputHandler.keys[1]){
                this.velX -= this.acc;
            }else if(!this.keyInputHandler.keys[1] && !this.keyInputHandler.keys[0]){
                if(this.velX > 0){
                    this.velX -= this.dcc;
                } else if (this.velX < 0) {
                    this.velX += this.dcc;
                }
            }




            //Vertical movement(W & S Key press)
            if(this.keyInputHandler.keys[2]){
                this.velY -= this.acc;
            }
            else if(this.keyInputHandler.keys[3]){
                this.velY += this.acc;
            }else if(!this.keyInputHandler.keys[2] && !this.keyInputHandler.keys[3]){
                if(this.velY > 0){
                    this.velY -= this.dcc;
                } else if (this.velY < 0) {
                    this.velY += this.dcc;
                }
            }

            //setting max and minimum movement speed
            velX = MathHelper.clamp(velX, 5, -5);
            velY = MathHelper.clamp(velY, 5, -5);


            //setting up the hitbox
            this.getHitBox().x = (int)this.getxPos()-(this.sizeWidth/2);
            this.getHitBox().y = (int)this.getyPos()-(this.sizeHeight/2);

        }


        if(this.IronResourceObject != null){
            if(MathHelper.interSectCheck(this.getHitBox(), this.IronResourceObject.getHitBox())){
                System.out.println("Player Intersect detetected : " + this.IronResourceObject.getClass().getSimpleName());
            }
        }

        if(this.WoodResourceObject != null){
            if(MathHelper.interSectCheck(this.getHitBox(), this.WoodResourceObject.getHitBox())){
                System.out.println("Player Intersect detetected : " + this.WoodResourceObject.getClass().getSimpleName());
            }
        }

        if(this.WaterResourceObject != null){
            if(MathHelper.interSectCheck(this.getHitBox(), this.WaterResourceObject.getHitBox())){
                System.out.println("Player Intersect detetected : " + this.WaterResourceObject.getClass().getSimpleName());
            }
        }


    }

    @Override
    protected void render(Graphics g) {

        if(this.isActiveInScene()){
            if(this.isVisible()){
                g.setColor(this.getColor());
                g.fillRect((int)this.getxPos(), (int)this.getyPos(), this.getSizeWidth(), this.getSizeHeight());

                //hitbox
                //g.setColor(Color.RED);
                //g.drawRect(this.hitBox.x, this.hitBox.y, this.hitBox.width, this.hitBox.height);
            }
        }
    }
}
