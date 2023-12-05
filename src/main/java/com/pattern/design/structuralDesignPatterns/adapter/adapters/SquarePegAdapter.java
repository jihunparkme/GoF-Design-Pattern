package com.pattern.design.structuralDesignPatterns.adapter.adapters;

import com.pattern.design.structuralDesignPatterns.adapter.round.Round;
import com.pattern.design.structuralDesignPatterns.adapter.square.SquarePeg;

/**
 * 어댑터
 * - 클라이언트와 서비스 양쪽에서 작동할 수 있는 클래스
 * - 서비스 객체를 래핑하는 동안 클라이언트 인터페이스를 구현
 * - 어댑터는 어댑터 인터페이스를 통해 클라이언트로부터 호출들을 수신한 후 이 호출을 래핑된 서비스 객체가 이해할 수 있는 형식의 호출들로 변환
 */
public class SquarePegAdapter implements Round {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        // 해당 못에 적합한 최소 반지름 계산
        return (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
    }
}
