package com.pattern.design.creationalDesignPatterns.abstractFactory.chairs;

/**
 * ConcreteProduct
 * - 구상 제품들은 변형들로 그룹화된 추상 제품들의 다양한 구현들
 * - 각 추상 제품(의자/소파)은 주어진 모든 변형(빅토리안/현대식)에 구현되어야 한다.
 */
public class ModernChair implements Chair {
    @Override
    public void hasLegs() {
        System.out.println("ModernChair has Legs");
    }

    @Override
    public void sitOn() {
        System.out.println("ModernChair sitOn");
    }
}
