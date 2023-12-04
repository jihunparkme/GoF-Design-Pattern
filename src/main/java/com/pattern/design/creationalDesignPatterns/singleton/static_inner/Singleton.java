package com.pattern.design.creationalDesignPatterns.singleton.static_inner;

/**
 * Static Inner Class
 * - 멀티 스레드에 안전
 * - 필요한 시점에 인스턴스 생성(lazy initialization)
 * - 초기화값을 전달받을 수 없음..?
 */
public final class Singleton {
    public String value;

    private Singleton(String value) {
        this.value = value;
    }

    private static class SingletonHolder {
        private static final Singleton SINGLETON = new Singleton("FOO");
    }

    public static Singleton getInstance() {
        return SingletonHolder.SINGLETON;
    }
}
