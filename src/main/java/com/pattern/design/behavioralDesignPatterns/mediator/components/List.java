package com.pattern.design.behavioralDesignPatterns.mediator.components;

import com.pattern.design.behavioralDesignPatterns.mediator.mediator.Mediator;
import com.pattern.design.behavioralDesignPatterns.mediator.mediator.Note;

import javax.swing.*;

/**
 * 컴포넌트
 * - 어떠한 비즈니스 로직을 포함한 다양한 클래스들
 * - 각 컴포넌트에는 중재자에 대한 참조가 있는데, 이 중재자는 중재자 인터페이스의 유형으로 선언
 * - 컴포넌트는 중재자의 실제 클래스를 인식하지 못하므로 컴포넌트를 다른 중재자에 연결하여 다른 프로그램에서 재사용 가능
 */
@SuppressWarnings("unchecked")
public class List extends JList implements Component {
    private Mediator mediator;
    private final DefaultListModel LIST_MODEL;

    public List(DefaultListModel listModel) {
        super(listModel);
        this.LIST_MODEL = listModel;
        setModel(listModel);
        this.setLayoutOrientation(JList.VERTICAL);
        Thread thread = new Thread(new Hide(this));
        thread.start();
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void addElement(Note note) {
        LIST_MODEL.addElement(note);
        int index = LIST_MODEL.size() - 1;
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
        mediator.sendToFilter(LIST_MODEL);
    }

    public void deleteElement() {
        int index = this.getSelectedIndex();
        try {
            LIST_MODEL.remove(index);
            mediator.sendToFilter(LIST_MODEL);
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    public Note getCurrentElement() {
        return (Note)getSelectedValue();
    }

    @Override
    public String getName() {
        return "List";
    }

    private class Hide implements Runnable {
        private List list;

        Hide(List list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (list.isSelectionEmpty()) {
                    mediator.hideElements(true);
                } else {
                    mediator.hideElements(false);
                }
            }
        }
    }
}