package com.pattern.design.creationalDesignPatterns.abstractFactory.sofas;

public class VictorianSofa implements Sofa {
    @Override
    public void hasLegs() {
        System.out.println("VictorianSofa has Legs");
    }

    @Override
    public void sitOn() {
        System.out.println("VictorianSofa sitOn");
    }
}
