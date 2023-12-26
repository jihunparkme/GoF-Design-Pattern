package com.pattern.design.behavioralDesignPatterns.mediator.components;

import com.pattern.design.behavioralDesignPatterns.mediator.mediator.Mediator;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * 컴포넌트
 * - 어떠한 비즈니스 로직을 포함한 다양한 클래스들
 * - 각 컴포넌트에는 중재자에 대한 참조가 있는데, 이 중재자는 중재자 인터페이스의 유형으로 선언
 * - 컴포넌트는 중재자의 실제 클래스를 인식하지 못하므로 컴포넌트를 다른 중재자에 연결하여 다른 프로그램에서 재사용 가능
 */
public class Title extends JTextField implements Component {
    private Mediator mediator;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        mediator.markNote();
    }

    @Override
    public String getName() {
        return "Title";
    }
}