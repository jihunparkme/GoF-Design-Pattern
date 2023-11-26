package com.pattern.design.creationalDesignPatterns.abstractFactory;

/**
 * AbstractFactory
 * - 추상 팩토리 인터페이스는 각각의 추상 제품들을 생성하기 위한 여러 메서드들의 집합을 선언
 */
public interface FurnitureFactory {
    Chair createChair();

    Table createTable();

    Sofa createSofa();
}
