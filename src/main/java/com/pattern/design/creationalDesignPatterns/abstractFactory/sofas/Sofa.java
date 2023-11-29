package com.pattern.design.creationalDesignPatterns.abstractFactory.sofas;

/**
 * Abstract Product
 * - 추상 제품들은 제품 디자인 세트를 구성하는 개별 연관 제품들의 집합에 대한 인터페이스들을 선언
 */
public interface Sofa {
    void hasLegs();

    void sitOn();
}
