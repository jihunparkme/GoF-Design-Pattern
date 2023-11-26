package com.pattern.design.creationalDesignPatterns.factoryMethod;

/**
 * ConcreteCreator
 * - 기초 팩토리 메서드를 오버라이드여 다른 유형의 제품을 반환하도록 설정
 */
public class RoadLogistics extends Logistics {

    /**
     * 팩토리 메서드는 항상 새로운 인스턴스들을 생성해야 할 필요가 없음
     * - 기존 객체들을 캐시, 객체 풀 또는 다른 소스로부터 반환 가능
     */
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
