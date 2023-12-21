package com.pattern.design.structuralDesignPatterns.flyweight.trees;

import java.awt.*;

/**
 * 플라이웨이트 클래스
 * - 여러 객체들 간에 공유할 수 있는 객체 상태의 부분이 포함 (같은 플라이웨이트 객체가 다양한 콘텍스트에서 사용될 수 있음)
 * - 플라이웨이트 내부에 저장된 상태는 고유한(intrinsic) 상태
 * - 플라이웨이트의 메서드에 전달된 상태를 공유한(extrinsic) 상태
 */
public class TreeType {
    private String name;
    private Color color;
    private String otherTreeData;

    public TreeType(String name, Color color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }
}