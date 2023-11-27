package com.pattern.design.creationalDesignPatterns.abstractFactory;

public class Demo {
    private static Application configureApplication(String pattern) {
        Application app;
        FurnitureFactory factory = null;

        if ("Modern".equals(pattern)) {
            factory = new ModernFurnitureFactory();
        } else if("Victorian".equals(pattern)) {
            factory = new VictorianFurnitureFactory();
        } else {
            throw new IllegalArgumentException("Unknown operating system.");
        }

        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        modernPattern();
        victorianPattern();
    }

    private static void modernPattern() {
        Application modern = configureApplication("Modern");
        /**
         * ModernChair sitOn
         * ModernSofa sitOn
         * ModernTable sitOn
         */
        modern.sitOn();
        /**
         * ModernChair has Legs
         * ModernSofa has Legs
         * ModernTable has Legs
         */
        modern.hasLegs();
    }

    private static void victorianPattern() {
        Application victorian = configureApplication("Victorian");

        /**
         * VictorianChair sitOn
         * VictorianSofa sitOn
         * VictorianTable sitOn
         */
        victorian.sitOn();
        /**
         * VictorianChair has Legs
         * VictorianSofa has Legs
         * VictorianTable has Legs
         */
        victorian.hasLegs();
    }
}
