package com.pattern.design.behavioralDesignPatterns.observer;

import com.pattern.design.behavioralDesignPatterns.observer.editor.Editor;
import com.pattern.design.behavioralDesignPatterns.observer.listeners.EmailNotificationListener;
import com.pattern.design.behavioralDesignPatterns.observer.listeners.LogOpenListener;

public class Demo {
    /**
     * 클라이언트는 출판사 및 구독자 객체들을 별도로 생성한 후 구독자들을 출판사 업데이트에 등록
     */
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        /**
         * Save to log /path/to/log/file.txt: Someone has performed open operation with the following file: test.txt
         * Email to admin@example.com: Someone has performed save operation with the following file: test.txt
         */
        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}