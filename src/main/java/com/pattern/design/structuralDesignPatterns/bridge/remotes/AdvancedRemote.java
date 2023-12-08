package com.pattern.design.structuralDesignPatterns.bridge.remotes;

import com.pattern.design.structuralDesignPatterns.bridge.devices.Device;

/**
 * 정제된 추상화
 * - 제어 논리의 변형들을 제공
 * - 일반 구현 인터페이스를 통해 다른 구현들과 작업
 */
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
