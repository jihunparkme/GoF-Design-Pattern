package com.pattern.design.creationalDesignPatterns.abstractFactory;

public class ModernTable implements Table {
    @Override
    public void hasLegs() {
        System.out.println("ModernTable has Legs");
    }

    @Override
    public void sitOn() {
        System.out.println("ModernTable sitOn");
    }
}
