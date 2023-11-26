package com.pattern.design.creationalDesignPatterns.factoryMethod;

public class App {

    private static Logistics creator;

    public void initialize(String type) {
        if ("truck".equals(type)) {
            creator = new RoadLogistics();
            return;
        }

        if ("ship".equals(type)) {
            creator = new SeaLogistics();
            return;
        }

        throw new IllegalArgumentException("Unknown operating system.");
    }

    public static void main(String[] args) {
        App app = new App();

        app.initialize("truck");
        creator.planDelivery(); //=> Truck deliver

        app.initialize("ship");
        creator.planDelivery(); //=> Ship deliver
    }
}
