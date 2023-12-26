package com.pattern.design.behavioralDesignPatterns.mediator.mediator;

import com.pattern.design.behavioralDesignPatterns.mediator.components.Component;

import javax.swing.*;

/**
 * 중재자 인터페이스
 * - 일반적으로 단일 알림 메서드만을 포함하는 컴포넌트들과의 통신 메서드를 선언
 * - 컴포넌트들은 자체 객체를 포함하여 모든 콘텍스트를 이 메서드의 인수로 전달할 수 있지만,
 * - 이는 수신자 컴포넌트와 발송자 클래스 간의 결합이 발생하지 않는 방식으로만 가능
 */
public interface Mediator {
    void addNewNote(Note note);
    void deleteNote();
    void getInfoFromList(Note note);
    void saveChanges();
    void markNote();
    void clear();
    void sendToFilter(ListModel listModel);
    void setElementsList(ListModel list);
    void registerComponent(Component component);
    void hideElements(boolean flag);
    void createGUI();
}