package com.pattern.design.behavioralDesignPatterns.command.editor;

import com.pattern.design.behavioralDesignPatterns.command.commands.*;

import javax.swing.*;
import java.awt.*;

/**
 * 수신자 클래스
 * - 일부 비즈니스 로직이 포함
 * - 대부분 객체는 수신자 역할을 할 수 있음
 * - 커맨드는 요청이 수신자에게 전달되는 방법에 대한 세부 정보만 처리하는 반면, 수신자 자체는 실제 작업을 수행
 */
public class Editor {
    public JTextArea textField;
    public String clipboard;
    private CommandHistory history = new CommandHistory();

    public void init() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        Editor editor = this;
        // 사용자가 새 명령 객체와 상호 작용할 때마다 새 명령 객체를 생성
        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(editor)));
        ctrlX.addActionListener(e -> executeCommand(new CutCommand(editor)));
        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(editor)));
        ctrlZ.addActionListener(e -> undo());
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            // 작업을 실행한 후 명령은 기록 스택으로 푸시
            history.push(command);
        }
    }

    /**
     * 실행 취소 작업을 수행하면 기록에서 마지막으로 실행된 명령을 가져와 역작업을 수행하거나 해당 명령으로 저장된 편집기의 과거 상태를 복원
     */
    private void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}