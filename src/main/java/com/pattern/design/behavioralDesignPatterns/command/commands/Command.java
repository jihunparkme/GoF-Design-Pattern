package com.pattern.design.behavioralDesignPatterns.command.commands;

import com.pattern.design.behavioralDesignPatterns.command.editor.Editor;

/**
 * 커맨드 인터페이스
 * - 일반적으로 커맨드를 실행하기 위한 단일 메서드만 선언
 */
public abstract class Command {
    public Editor editor;
    private String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }

    public abstract boolean execute();
}
