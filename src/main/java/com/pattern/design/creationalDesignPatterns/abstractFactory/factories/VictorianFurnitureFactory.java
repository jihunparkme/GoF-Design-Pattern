package com.pattern.design.creationalDesignPatterns.abstractFactory.factories;

import com.pattern.design.creationalDesignPatterns.abstractFactory.chairs.Chair;
import com.pattern.design.creationalDesignPatterns.abstractFactory.chairs.VictorianChair;
import com.pattern.design.creationalDesignPatterns.abstractFactory.sofas.Sofa;
import com.pattern.design.creationalDesignPatterns.abstractFactory.sofas.VictorianSofa;
import com.pattern.design.creationalDesignPatterns.abstractFactory.tables.Table;
import com.pattern.design.creationalDesignPatterns.abstractFactory.tables.VictorianTable;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}
