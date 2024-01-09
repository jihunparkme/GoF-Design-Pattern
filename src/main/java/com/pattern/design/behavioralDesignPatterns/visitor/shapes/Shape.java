package com.pattern.design.behavioralDesignPatterns.visitor.shapes;

import com.pattern.design.behavioralDesignPatterns.visitor.visitor.Visitor;

/**
 * Element 인터페이스
 * - 비지터를 '수락'하는 메서드 선언
 * - 이 메서드에는 비지터 인터페이스 유형으로 선언된 하나의 매개변수가 포함
 */
public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}