package com.pattern.design.structuralDesignPatterns.adapter.practice;

/**
 * 서비스
 * - 일반적으로 타사 또는 레거시 클래스
 * - 클라이언트는 서비스 클래스를 직접 사용 불가
 */
public class OtherService {
    public String serviceMethod(Long data) {
        return "other service do something";
    }
}
