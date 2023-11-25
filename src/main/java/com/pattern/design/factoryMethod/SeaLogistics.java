package com.pattern.design.factoryMethod;

/**
 * ConcreteCreator
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
