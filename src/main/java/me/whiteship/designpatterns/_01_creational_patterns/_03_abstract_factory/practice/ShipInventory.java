package me.whiteship.designpatterns._01_creational_patterns._03_abstract_factory.practice;

import me.whiteship.designpatterns._01_creational_patterns._02_factory_method.practice.Ship;
import me.whiteship.designpatterns._01_creational_patterns._02_factory_method.practice.ShipFactory;

public class ShipInventory {

    public static void main(String[] args) {
        ShipFactory shipFactory = new WhiteshipFactory(new WhiteshipPartsFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
