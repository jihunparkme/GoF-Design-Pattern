package com.pattern.design.behavioralDesignPatterns.memento.history;

import com.pattern.design.behavioralDesignPatterns.memento.editor.Editor;

/**
 * 메멘토 클래스
 * - 오리지네이터 상태의 스냅샷 역할을 하는 값 객체
 * - 관행적으로 메멘토는 불변으로 만든 후 생성자를 통해 데이터를 한 번만 전달
 */
public class Memento {
    private String backup;
    private Editor editor;

    public Memento(Editor editor) {
        this.editor = editor;
        this.backup = editor.backup();
    }

    public void restore() {
        editor.restore(backup);
    }
}