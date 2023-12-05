package com.pattern.design.structuralDesignPatterns.adapter.round;

/**
 * 둥근 못
 */
public class RoundPeg implements Round {
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }
}
