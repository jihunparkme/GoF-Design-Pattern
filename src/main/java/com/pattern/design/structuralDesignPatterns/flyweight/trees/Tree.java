package com.pattern.design.structuralDesignPatterns.flyweight.trees;

import java.awt.*;

/**
 * 콘텍스트 클래스
 * - 공유한 상태를 포함, 이 상태는 모든 원본 객체들에서 고유
 * - 콘텍스트가 플라이웨이트 객체 중 하나와 쌍을 이루면 원래 객체의 전체 상태를 포현
 */
public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}