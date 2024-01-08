package com.pattern.design.behavioralDesignPatterns.template_method.networks;

/**
 * 추상 클래스
 * - 알고리즘 단계 역할을 하는 메서드 선언
 * - 메서드를 특정 순서로 호출하는 실제 템플릿 메서드도 선언
 * - 단계들은 abstract 로 선언되거나 일부 디폴트 구현
 */
public abstract class Network {
    String userName;
    String password;

    Network() {}

    public boolean post(String message) {
        if (logIn(this.userName, this.password)) {
            boolean result =  sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}
