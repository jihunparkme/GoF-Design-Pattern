package com.pattern.design.creationalDesignPatterns.singleton.non_thread_safe;

/**
 * Singleton
 * - 싱글턴 클래스는 정적 메서드 getInstance 선언
 * - 이 메서드는 자체 클래스의 같은 인스턴스를 반환
 *
 * - 싱글턴의 생성자는 항상 클라이언트 코드에서부터 숨겨져야 한다.
 * - getInstance 메서드를 호출하는 것이 Singleton 객체를 가져올 수 있는 유일한 방법이어야 한다.
 */
public final class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
