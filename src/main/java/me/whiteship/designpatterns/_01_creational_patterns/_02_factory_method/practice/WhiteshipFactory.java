package me.whiteship.designpatterns._01_creational_patterns._02_factory_method.practice;

public class WhiteshipFactory extends DefaultShipFactory {

    @Override
    public Ship createShip() {
        return new Whiteship();
    }
}
