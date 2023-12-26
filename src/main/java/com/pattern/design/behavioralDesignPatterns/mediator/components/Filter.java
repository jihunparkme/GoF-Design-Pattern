package com.pattern.design.behavioralDesignPatterns.mediator.components;

import com.pattern.design.behavioralDesignPatterns.mediator.mediator.Mediator;
import com.pattern.design.behavioralDesignPatterns.mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * 컴포넌트
 * - 어떠한 비즈니스 로직을 포함한 다양한 클래스들
 * - 각 컴포넌트에는 중재자에 대한 참조가 있는데, 이 중재자는 중재자 인터페이스의 유형으로 선언
 * - 컴포넌트는 중재자의 실제 클래스를 인식하지 못하므로 컴포넌트를 다른 중재자에 연결하여 다른 프로그램에서 재사용 가능
 */
public class Filter extends JTextField implements Component {
    private Mediator mediator;
    private ListModel listModel;

    public Filter() {}

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        String start = getText();
        searchElements(start);
    }

    public void setList(ListModel listModel) {
        this.listModel = listModel;
    }

    private void searchElements(String s) {
        if (listModel == null) {
            return;
        }

        if (s.equals("")) {
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            notes.add((Note) listModel.getElementAt(i));
        }
        DefaultListModel<Note> listModel = new DefaultListModel<>();
        for (Note note : notes) {
            if (note.getName().contains(s)) {
                listModel.addElement(note);
            }
        }
        mediator.setElementsList(listModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}