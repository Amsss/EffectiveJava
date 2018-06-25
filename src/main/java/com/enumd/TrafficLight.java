package com.enumd;

/**
 * @Author: Zezhao.Zhu
 * @Description:
 * @Create: 2018/5/14 17:36
 * @Modified By：
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
        }
    }
}
