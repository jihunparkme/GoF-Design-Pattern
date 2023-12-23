package com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware;

/**
 * 기초 핸들러
 * - 선택적 클래스이며 여기에 모든 핸들러 클래스들에 공통적인 상용구 코드 삽입 가능
 * - 일반적으로 기초 핸들러 클래스는 다음 핸들러에 대한 참조를 저장하기 위한 필드를 정의
 * - 클라이언트는 핸들러를 이전 핸들러의 생성자 또는 세터(setter)에 해당 핸들러를 전달하여 체인을 구축
 * - 클래스는 디폴트 핸들러 행동을 구현 가능(즉, 다음 핸들러의 존재 여부를 확인한 후 다음 핸들러로 실행을 넘길 수 있음)
 */
public abstract class Middleware implements Handler {
    private Middleware next; // 다음 핸들러에 대한 참조

    /**
     * Middleware 개체 체인 생성
     */
    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    /**
     * 하위 클래스는 구체적인 검사를 통해 이 방법을 구현
     */
    @Override
    public abstract boolean check(String email, String password);

    /**
     * 체인에 다음 개체가 있다면 실행하고, 체은의 마지막 개체라면 종료
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}