package com.pattern.design.behavioralDesignPatterns.visitor.shapes;

import com.pattern.design.behavioralDesignPatterns.visitor.visitor.Visitor;

/**
 * ConcreteElement
 * - 구상 요소는 반드시 accept 메서드를 구현
 * - 이 메서드의 목적은 호출을 현재 요소 클래스에 해당하는 적절한 비지터 메서드로 리다이렉트
 * - 기초 클래스가 accept 메서드를 구현하더라도 모든 자식 클래스는 이 메서드를 오버라이드해야 하며 비지터 객체에 적절한 메서드를 호출해야 함
 */
public class Dot implements Shape {
    private int id;
    private int x;
    private int y;

    public Dot() {
    }

    public Dot(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        // move shape
    }

    @Override
    public void draw() {
        // draw shape
    }

    @Override
    public String accept(Visitor visitor) {
        // 전달받은 Visitor에 Element(자신)을 전달
        return visitor.visit(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }
}
