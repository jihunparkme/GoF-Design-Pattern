package com.pattern.design.behavioralDesignPatterns.observer.listeners;

import java.io.File;

/**
 * 구상 구독자
 * - 출판사가 보낸 알림들에 대한 응답으로 몇 가지 작업을 수행
 * - 이러한 모든 클래스는 출판사가 구상 클래스들과 결합하지 않도록 같은 인터페이스를 구현
 */
public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    /**
     * 일반적으로 구독자들은 업데이트를 올바르게 처리하기 위해 콘텍스트 정보가 어느 정도 필요
     * - 출판사들은 종종 콘텍스트 데이터를 알림 메서드의 인수들로 전달
     * - 출판사는 자신을 인수로 전달할 수 있으며, 구독자가 필요한 데이터를 직접 가져오도록 함
     */
    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}