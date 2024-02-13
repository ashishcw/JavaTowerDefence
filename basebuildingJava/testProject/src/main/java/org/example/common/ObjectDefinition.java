package org.example.common;

public class ObjectDefinition {
    public enum ObjectType{
        Player,
        Bullet,
        NonWalkableBlock,
        ResourceBlock,
        Path
    }

    public ObjectType objectType = ObjectType.NonWalkableBlock;

    public enum ResourceType{
        WoodResource,
        WaterResource,
        IronResource,
        None
    }

    public ResourceType resourceType = ResourceType.IronResource;
}
