package com.pattern.design.behavioralDesignPatterns.memento.editor;

import com.pattern.design.behavioralDesignPatterns.memento.commands.Command;
import com.pattern.design.behavioralDesignPatterns.memento.history.History;
import com.pattern.design.behavioralDesignPatterns.memento.history.Memento;
import com.pattern.design.behavioralDesignPatterns.memento.shapes.CompoundShape;
import com.pattern.design.behavioralDesignPatterns.memento.shapes.Shape;

import javax.swing.*;
import java.io.*;
import java.util.Base64;

/**
 * 오리지네이터
 * - 자신의 상태에 대한 스냅샷을 생성 가능, 필요시 스냅샷에서 자신의 상태를 복원
 * - 자신의 상태를 메멘토 내부에 저장하는 메서드와 해당 상태를 메멘토로부터 복원하는 또 다른 메서드를 정의
 */
public class Editor extends JComponent {
    private Canvas canvas;
    private CompoundShape allShapes = new CompoundShape();
    private History history; // 상태에 대한 스냅샷

    public Editor() {
        canvas = new Canvas(this);
        history = new History();
    }

    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    public CompoundShape getShapes() {
        return allShapes;
    }

    /**
     * 메멘토 클래스는 오리지네이터 내부에 중첩
     * - 오리지네이터가 메멘토의 필드와 메서드가 비공개로 선언된 경우에도 접근할 수 있도록
     */
    public void execute(Command c) {
        history.push(c, new Memento(this));
        c.execute();
    }

    public void undo() {
        if (history.undo())
            canvas.repaint();
    }

    public void redo() {
        if (history.redo())
            canvas.repaint();
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.allShapes);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.allShapes = (CompoundShape) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.print("ClassNotFoundException occurred.");
        } catch (IOException e) {
            System.out.print("IOException occurred.");
        }
    }
}
