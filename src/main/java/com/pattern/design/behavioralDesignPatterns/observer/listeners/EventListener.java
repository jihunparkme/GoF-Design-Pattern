package com.pattern.design.behavioralDesignPatterns.observer.listeners;

import java.io.File;

/**
 * 구독자 인터페이스
 * - 알림 인터페이스를 선언하며 대부분의 경우 단일 update 메서드로 구성
 * - 이 메서드에는 출판사의 업데이트와 함께 어떤 이벤트의 세부 정보들을 전달할 수 있도록 하는 여러 매개변수가 존재
 */
public interface EventListener {
    void update(String eventType, File file);
}