package com.pattern.design.structuralDesignPatterns.decorator.decorators;

import java.util.Base64;

/**
 * 구상 데코레이터
 * - 컴포넌트들에 동적으로 추가될 수 있는 추가 행동들을 정의
 * - 기초 데코레이터의 메서드를 오버라이드(재정의)하고 해당 행동을 부모 메서드를 호출하기 전이나 후에 실행
 */
public class EncryptionDecorator extends DataSourceDecorator {

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }
    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}