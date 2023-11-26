package com.pattern.design.creationalDesignPatterns.factoryMethod;

/**
 * ConcreteProduct
 * - 구상 제품들은 제품 인터페이스의 다양한 구현들
 */
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Ship deliver");
    }
}
