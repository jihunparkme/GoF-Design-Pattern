package com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware;

/**
 * 핸들러
 * - 모든 구상 핸들러에 공통적인 인터페이스를 선언
 * - 일반적으로 여기에는 요청을 처리하기 위한 단일 메서드만 포함되지만 때로는 체인의 다음 핸들러를 세팅하기 위한 다른 메서드가 있을 수도 있음
 */
public interface Handler {
    boolean check(String email, String password);
}
