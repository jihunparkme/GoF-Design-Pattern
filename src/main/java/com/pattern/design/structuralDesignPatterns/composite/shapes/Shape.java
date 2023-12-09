package com.pattern.design.structuralDesignPatterns.composite.shapes;

import java.awt.*;

/**
 * Component Interface
 * - 트리의 단순 요소들과 복잡한 요소들 모두에 공통적인 작업을 설명
 */
public interface Shape {
    int getX();
    int getY();
    int getWidth();
    int getHeight();
    void move(int x, int y);
    boolean isInsideBounds(int x, int y);
    void select();
    void unSelect();
    boolean isSelected();
    void paint(Graphics graphics);
}
