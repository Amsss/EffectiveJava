package com.enums;

/**
 * @author: zhuzz
 * @description: 描述
 * @date: 2018/10/4 19:57
 */
public class TrafficLight {
    Color color = Color.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Color.GREEN;
                break;
            case YELLOW:
                color = Color.RED;
                break;
            case GREEN:
                color = Color.YELLOW;
                break;
            default:
        }
    }
}
