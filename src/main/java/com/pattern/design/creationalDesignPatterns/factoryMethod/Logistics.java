package com.pattern.design.creationalDesignPatterns.factoryMethod;

/**
 * Creator
 * - Creator 클래스는 새로운 제품 객체들을 반환하는 팩토리 메서드 선언
 */
public abstract class Logistics {

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    /**
     *  abstract 로 모든 자식 클래스들이 각각 이 메서드의 자체 버전들을 구현하도록 강제할 수 있음
     *  - 대안적으로 기초 팩토리 메서드가 디폴트 제품 유형을 반환하도록 하는 것도 가능
     */
    public abstract Transport createTransport();
}
