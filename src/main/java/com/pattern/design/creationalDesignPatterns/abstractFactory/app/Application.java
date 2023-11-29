package com.pattern.design.creationalDesignPatterns.abstractFactory.app;

import com.pattern.design.creationalDesignPatterns.abstractFactory.chairs.Chair;
import com.pattern.design.creationalDesignPatterns.abstractFactory.factories.FurnitureFactory;
import com.pattern.design.creationalDesignPatterns.abstractFactory.sofas.Sofa;
import com.pattern.design.creationalDesignPatterns.abstractFactory.tables.Table;

public class Application {
    private Chair chair;
    private Sofa sofa;
    private Table table;

    public Application(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.table = factory.createTable();
    }

    public void hasLegs() {
        this.chair.hasLegs();
        this.sofa.hasLegs();
        this.table.hasLegs();
    }

    public void sitOn() {
        this.chair.sitOn();
        this.sofa.sitOn();
        this.table.sitOn();
    }
}
