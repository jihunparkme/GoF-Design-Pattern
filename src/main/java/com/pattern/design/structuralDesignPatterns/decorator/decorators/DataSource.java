package com.pattern.design.structuralDesignPatterns.decorator.decorators;

/**
 * Component
 * - 컴포넌트는 래퍼들과 래핑된 객체들 모두에 대한 공통 인터페이스 선언
 */
public interface DataSource {
    void writeData(String data);

    String readData();
}
