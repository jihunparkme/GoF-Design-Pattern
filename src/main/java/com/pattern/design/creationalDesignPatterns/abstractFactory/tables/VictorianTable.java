package com.pattern.design.creationalDesignPatterns.abstractFactory.tables;

public class VictorianTable implements Table {
    @Override
    public void hasLegs() {
        System.out.println("VictorianTable has Legs");
    }

    @Override
    public void sitOn() {
        System.out.println("VictorianTable sitOn");
    }
}
