package com.pattern.design.structuralDesignPatterns.adapter.round;

/**
 * 둥근 구멍
 */
public class RoundHole implements Round {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    public boolean fits(Round peg) {
        return (this.getRadius() >= peg.getRadius());
    }
}
