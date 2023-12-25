package com.pattern.design.behavioralDesignPatterns.command.commands;

import com.pattern.design.behavioralDesignPatterns.command.editor.Editor;

/**
 * 구상 커맨드
 * - 다양한 유형의 요청을 구현
 * - 자체적으로 작업을 수행해서는 안되며, 비즈니스 논리 객체 중 하나에 호출을 전달
 * - 코드를 단순화하기 위해 이러한 클래스들은 병합될 수 있음
 *
 * - 수신 객체에서 메서드를 실행하는 데 필요한 매개 변수는 구상 커맨드의 필드들로 선언 가능
 * - 생성자를 통해서만 이러한 필드들의 초기화를 허용함으로써 커맨드 객체들을 불변으로 생성
 */
public class PasteCommand extends Command {

    public PasteCommand(Editor editor) {
        super(editor);
    }

    @Override
    public boolean execute() {
        if (editor.clipboard == null || editor.clipboard.isEmpty()) return false;

        backup();
        editor.textField.insert(editor.clipboard, editor.textField.getCaretPosition());
        return true;
    }
}
