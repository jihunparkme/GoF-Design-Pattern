package com.pattern.design.behavioralDesignPatterns.observer.publisher;

import com.pattern.design.behavioralDesignPatterns.observer.listeners.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 기초 출판사(구독 관리 코드 및 알림 메서드 포함)
 * - 다른 객체에 이벤트를 발생
 * - 이벤트는 출판사가 상태를 전환하거나 어떤 행동들을 실행할 때 발생
 * - 출판사에는 구독 인프라가 포함되어 있으며, 이 인프라는 현재 구독자들이 리스트를 떠나고 새 구독자들이 리스트에 가입할 수 있도록 함
 */
public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}