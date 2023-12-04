package com.pattern.design.creationalDesignPatterns.singleton.thread_safe;

/**
 * Double Checked Locking
 * - 해당 클레스를 락으로 사용
 * - 멀티 스레드에 안전하고, 필요한 시점에 인스턴스 생성
 * - 복잡한 이론적인 배경
 */
public final class Singleton {
    // 올바르게 작동하려면 필드를 휘발성으로 선언
    private static volatile Singleton instance;

    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        Singleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Singleton.class) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}