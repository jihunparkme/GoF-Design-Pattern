package com.pattern.design.behavioralDesignPatterns.state.ui;

import com.pattern.design.behavioralDesignPatterns.state.states.ReadyState;
import com.pattern.design.behavioralDesignPatterns.state.states.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Context
 * - ConcreteStates 객체 중 하나에 대한 참조를 저장하고 모든 상태별 작업을 그 곳에 위임
 * - Context는 상태 인터페이스를 통해 상태 객체와 통신하며, 새로운 상태 객체를 전달하기 위한 세터(setter)를 노출
 */
public class Player {
    private State state;
    private boolean playing = false;
    private List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        this.state = new ReadyState(this);
        setPlaying(true);
        for (int i = 1; i <= 12; i++) {
            playlist.add("Track " + i);
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String startPlayback() {
        return "Playing " + playlist.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playlist.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        this.currentTrack = 0;
    }
}