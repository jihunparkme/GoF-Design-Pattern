package com.pattern.design.creationalDesignPatterns.factoryMethod;

/**
 * ConcreteCreator
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
