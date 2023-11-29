package com.pattern.design.creationalDesignPatterns.factoryMethod.products;

/**
 * Product
 * - 제품은 인터페이스를 선언
 * - 생성자와 자식 클래스들이 생성할 수 있는 모든 객체에 공통
 */
public interface Transport {
    void deliver();
}
