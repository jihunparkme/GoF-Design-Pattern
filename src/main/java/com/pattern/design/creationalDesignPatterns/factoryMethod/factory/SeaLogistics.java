package com.pattern.design.creationalDesignPatterns.factoryMethod.factory;

import com.pattern.design.creationalDesignPatterns.factoryMethod.products.Ship;
import com.pattern.design.creationalDesignPatterns.factoryMethod.products.Transport;

/**
 * ConcreteCreator
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
