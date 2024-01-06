package com.pattern.design.behavioralDesignPatterns.strategy.strategies;

/**
 * 전략 인터페이스
 * - 모든 구상 전략에 공통
 * - 콘텍스트가 전략을 실행하는 데 사용하는 메서드를 선언
 */
public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}