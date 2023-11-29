package com.pattern.design.creationalDesignPatterns.abstractFactory.sofas;

public class ModernSofa implements Sofa {
    @Override
    public void hasLegs() {
        System.out.println("ModernSofa has Legs");
    }

    @Override
    public void sitOn() {
        System.out.println("ModernSofa sitOn");
    }
}
