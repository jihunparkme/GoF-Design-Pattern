package com.pattern.design.structuralDesignPatterns.adapter.square;

/**
 * 서비스 (정사각형 못)
 * - 일반적으로 타사 또는 레거시 클래스
 * - 클라이언트는 서비스 클래스를 직접 사용 불가
 */
public class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        return Math.pow(this.width, 2);
    }
}
