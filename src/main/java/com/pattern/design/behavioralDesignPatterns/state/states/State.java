package com.pattern.design.behavioralDesignPatterns.state.states;

import com.pattern.design.behavioralDesignPatterns.state.ui.Player;

/**
 * 상태 인터페이스
 * - 상태별 메서드 선언
 * - 메서드들은 모든 구상 상태에서 유효해야 함(호출될 일이 없는 쓸모없는 메서드들이 일부 상태 내에 존재하는 것은 원하지 않을 것이므로..)
 */
public abstract class State {
    Player player;

    State(Player player) {
        this.player = player;
    }

    /**
     * 콘텍스트와 구상 상태들 모두 콘텍스트의 다음 상태를 설정할 수 있으며, 콘텍스트에 연결된 상태 객체를 교체하여 실제 상태 천이를 수행
     */
    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
}