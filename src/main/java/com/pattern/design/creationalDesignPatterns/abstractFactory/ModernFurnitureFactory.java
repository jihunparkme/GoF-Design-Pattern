package com.pattern.design.creationalDesignPatterns.abstractFactory;

/**
 * ConcreteFactory
 * - 구상 팩토리들은 추상 팩토리의 생성 메서드들을 구현
 * - 각 구상 팩토리는 제품들의 특정 변형들에 해당하며 해당 특정 변형들만 생성
 */
public class ModernFurnitureFactory implements FurnitureFactory {

    /**
     *  구상 팩토리들은 구상 제품들을 인스턴스화하나, 그 제품들의 생성 메서드들의 시그니처들은 그에 해당하는 추상 제품들을 반환
     *  그래야 팩토리를 사용하는 클라이언트 코드가 팩토리에서 받은 제품의 특정 변형과 결합되지 않음
     */

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}
