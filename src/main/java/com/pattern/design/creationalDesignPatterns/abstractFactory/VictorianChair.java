package com.pattern.design.creationalDesignPatterns.abstractFactory;

/**
 * ConcreteProduct
 * - 구상 제품들은 변형들로 그룹화된 추상 제품들의 다양한 구현들
 * - 각 추상 제품(의자/소파)은 주어진 모든 변형(빅토리안/현대식)에 구현되어야 한다.
 */
public class VictorianChair implements Chair {
    @Override
    public void hasLegs() {
        System.out.println("VictorianChair has Legs");
    }

    @Override
    public void sitOn() {
        System.out.println("VictorianChair sitOn");
    }
}
