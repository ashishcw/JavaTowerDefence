package org.example.utils;

import java.awt.*;

public class MathHelper {
    public static float clamp(float value, float maxValue, float minValue){
        if(value > maxValue){
            value = maxValue;
        }else if(value < minValue){
            value = minValue;
        }
        return value;
    }

    public static boolean interSectCheck(Rectangle source, Rectangle target){
        if(source.intersects(target)){
            return true;
        }
        return false;
    }
}
