package com.pattern.design.behavioralDesignPatterns.state.states;

import com.pattern.design.behavioralDesignPatterns.state.ui.Player;

/**
 * 구상 상태
 * - 상태별 메서드들에 대한 자체적인 구현을 제공
 * - 여러 상태에서 유사한 코드의 중복을 피하기 위해 어떤 공통 행동을 캡슐화하는 중간 추상 클래스 제공 가능
 *
 * - 상태 객체들은 콘텍스트 객체에 대한 역참조를 저장 가능
 * - 이 참조를 통해 상태는 콘텍스트 객체에서 모든 필요한 정보를 가져올 수 있고 상태 천이를 시작 가능
 */
public class LockedState extends State {

    LockedState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing";
        } else {
            return "Locked...";
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
}