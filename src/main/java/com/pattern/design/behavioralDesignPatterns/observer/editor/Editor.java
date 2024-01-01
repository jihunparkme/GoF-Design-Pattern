package com.pattern.design.behavioralDesignPatterns.observer.editor;

import com.pattern.design.behavioralDesignPatterns.observer.publisher.EventManager;

import java.io.File;

/**
 * 구상 출판
 * - 실제 비즈니스 논리 포함
 */
public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    /**
     * 새 이벤트가 발생하면 출판사는 구독자 리스트를 살펴본 후 각 구독자 객체의 구독자 인터페이스에 선언된 알림 메서드를 호출
     */
    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    /**
     * 새 이벤트가 발생하면 출판사는 구독자 리스트를 살펴본 후 각 구독자 객체의 구독자 인터페이스에 선언된 알림 메서드를 호출
     */
    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}