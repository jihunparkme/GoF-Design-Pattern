package com.pattern.design.structuralDesignPatterns.composite.shapes;

import java.awt.*;

/**
 * Leaf
 * - 트리의 기본 요소이며 하위요소가 없음
 * - 일반적으로 Leaf 컴포넌트들은 작업을 위임할 하위요소가 없어서 대부분의 실제 작업들을 수행
 */
public class Dot extends BaseShape {
    private final int DOT_SIZE = 3;

    public Dot(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public int getWidth() {
        return DOT_SIZE;
    }

    @Override
    public int getHeight() {
        return DOT_SIZE;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillRect(x - 1, y - 1, getWidth(), getHeight());
    }
}