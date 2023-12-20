package com.pattern.design.structuralDesignPatterns.decorator.decorators;

/**
 * 기초 데코레이터 클래스
 * - 래핑된 객체를 참조하기 위한 필드 존재
 * - 필드의 유형은 구상 컴포넌트들과 구상 데코레이터들을 모두 포함할 수 있도록 컴포넌트 인터페이스로 선언
 * - 그 후 기초 데코레이터는 모든 작업들을 래핑된 객체에 위임
 */
public class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}
