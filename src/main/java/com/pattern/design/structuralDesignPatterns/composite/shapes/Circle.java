package com.pattern.design.structuralDesignPatterns.composite.shapes;

import java.awt.*;

/**
 * Leaf
 * - 트리의 기본 요소이며 하위요소가 없음
 * - 일반적으로 Leaf 컴포넌트들은 작업을 위임할 하위요소가 없어서 대부분의 실제 작업들을 수행
 */
public class Circle extends BaseShape {
    public int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawOval(x, y, getWidth() - 1, getHeight() - 1);
    }
}