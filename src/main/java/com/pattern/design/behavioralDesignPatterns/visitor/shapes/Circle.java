package com.pattern.design.behavioralDesignPatterns.visitor.shapes;

import com.pattern.design.behavioralDesignPatterns.visitor.visitor.Visitor;

/**
 * ConcreteElement
 * - 구상 요소는 반드시 accept 메서드를 구현
 * - 이 메서드의 목적은 호출을 현재 요소 클래스에 해당하는 적절한 비지터 메서드로 리다이렉트
 * - 기초 클래스가 accept 메서드를 구현하더라도 모든 자식 클래스는 이 메서드를 오버라이드해야 하며 비지터 객체에 적절한 메서드를 호출해야 함
 */
public class Circle extends Dot {
    private int radius;

    public Circle(int id, int x, int y, int radius) {
        super(id, x, y);
        this.radius = radius;
    }

    @Override
    public String accept(Visitor visitor) {
        // 전달받은 Visitor에 Element(자신)을 전달
        return visitor.visit(this);
    }

    public int getRadius() {
        return radius;
    }
}