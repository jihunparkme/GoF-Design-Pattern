package com.pattern.design.structuralDesignPatterns.bridge;

import com.pattern.design.structuralDesignPatterns.bridge.devices.Device;
import com.pattern.design.structuralDesignPatterns.bridge.devices.Radio;
import com.pattern.design.structuralDesignPatterns.bridge.devices.Tv;
import com.pattern.design.structuralDesignPatterns.bridge.remotes.AdvancedRemote;
import com.pattern.design.structuralDesignPatterns.bridge.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    /**
     * 클라이언트는 추상화와 작업하는데만 관심
     * - 그러나 추상화 객체를 구현 객체들 중 하나와 연결하는 것도 클라이언트의 역할
     * - 원하는 유형의 리모컨을 특정 장치 객체와 연결
     */
    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}