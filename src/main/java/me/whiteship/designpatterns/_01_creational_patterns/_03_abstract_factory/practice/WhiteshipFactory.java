package me.whiteship.designpatterns._01_creational_patterns._03_abstract_factory.practice;

import me.whiteship.designpatterns._01_creational_patterns._02_factory_method.practice.DefaultShipFactory;
import me.whiteship.designpatterns._01_creational_patterns._02_factory_method.practice.Ship;
import me.whiteship.designpatterns._01_creational_patterns._02_factory_method.practice.Whiteship;

public class WhiteshipFactory extends DefaultShipFactory {

    private ShipPartsFactory shipPartsFactory;

    public WhiteshipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new Whiteship();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
