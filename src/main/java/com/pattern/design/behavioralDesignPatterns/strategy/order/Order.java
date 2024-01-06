package com.pattern.design.behavioralDesignPatterns.strategy.order;

import com.pattern.design.behavioralDesignPatterns.strategy.strategies.PayStrategy;

/**
 * 콘텍스트
 * - 구상 전략 중 하나에 대한 참조를 유지하고 전략 인터페이스를 통해서만 이 객체와 통신
 */
public class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy strategy) {
        strategy.collectPaymentDetails();
        // 전략에서 지불 데이터를 수집하고 저장
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}