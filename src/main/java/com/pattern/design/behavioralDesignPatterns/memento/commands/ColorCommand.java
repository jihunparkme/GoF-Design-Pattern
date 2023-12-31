package com.pattern.design.behavioralDesignPatterns.memento.commands;

import com.pattern.design.behavioralDesignPatterns.memento.editor.Editor;
import com.pattern.design.behavioralDesignPatterns.memento.shapes.Shape;

import java.awt.*;

/**
 * 케어테이커는
 * - 언제' 그리고 '왜' 오리지네이터의 상태를 캡처해야 하는지 뿐만 아니라 상태가 복원돼야 하는 시기도 알고 있음
 * - 메멘토들의 스택을 저장하여 오리지네이터의 기록을 추적
 * - 오리지네이터가 과거로 돌아가야 할 때 케어테이커는 맨 위의 메멘토를 스택에서 가져온 후 오리지네이터의 복원 메서드에 전달
 */
public class ColorCommand implements Command {
    private Editor editor;
    private Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}