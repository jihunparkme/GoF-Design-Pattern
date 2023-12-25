package com.pattern.design.behavioralDesignPatterns.command;

import com.pattern.design.behavioralDesignPatterns.command.editor.Editor;

/**
 * 발송자 클래스(invoker)
 * - 요청을 시작하는 역할
 * - 커맨드 객체에 대한 참조를 저장하기 위한 필드 존재
 * - 발송자는 요청을 수신자에게 직접 보내는 대신 해당 커맨드를 작동
 * - 발송자는 커맨드 객체를 생성할 책임이 없으며, 일반적으로 생성자를 통해 클라이언트로부터 미리 생성된 커맨드를 받음
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }
}
