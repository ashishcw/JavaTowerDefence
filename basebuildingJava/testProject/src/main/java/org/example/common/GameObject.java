package org.example.common;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.UUID;

public abstract class GameObject {

    protected UUID id;
    protected float xPos, yPos;
    protected float velX, velY;
    protected int sizeWidth, sizeHeight;
    protected int row, col;
    protected String name;
    protected Color color;
    protected boolean visible;

    protected boolean isActiveInScene;

    protected ObjectDefinition objectDefinition;

    protected Rectangle hitBox;

    public GameObject(float xPos, float yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.id = UUID.randomUUID();
        this.objectDefinition = new ObjectDefinition();
    }

    protected abstract void tick();
    protected abstract void render(Graphics g);

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public int getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(int sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public int getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(int sizeHeight) {
        this.sizeHeight = sizeHeight;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public UUID getId() {
        return id;
    }

    public boolean isActiveInScene() {
        return isActiveInScene;
    }

    public void setActiveInScene(boolean activeInScene) {
        isActiveInScene = activeInScene;
    }

    public ObjectDefinition getObjectDefinition() {
        return objectDefinition;
    }

    public void setObjectDefinition(ObjectDefinition objectDefinition) {
        this.objectDefinition = objectDefinition;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void setHitBox(Rectangle rectangle) {
        this.hitBox = rectangle;
    }
}
