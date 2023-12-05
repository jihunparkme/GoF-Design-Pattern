package com.pattern.design.structuralDesignPatterns.adapter.practice;

/**
 * 어댑터
 * - 클라이언트와 서비스 양쪽에서 작동할 수 있는 클래스
 * - 서비스 객체를 래핑하는 동안 클라이언트 인터페이스를 구현
 * - 어댑터는 어댑터 인터페이스를 통해 클라이언트로부터 호출들을 수신한 후 이 호출을 래핑된 서비스 객체가 이해할 수 있는 형식의 호출들로 변환
 */
public class Adapter implements ClientInterface {
    private OtherService adaptee;

    public Adapter(OtherService adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String method(String data) {
        Long specialData = convertToServiceFormat(data);
        return adaptee.serviceMethod(specialData);
    }

    private Long convertToServiceFormat(String data) {
        System.out.println("convert to service format");
        return Long.parseLong(data);
    }
}
