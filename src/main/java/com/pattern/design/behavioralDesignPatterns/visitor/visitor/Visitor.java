package com.pattern.design.behavioralDesignPatterns.visitor.visitor;

import com.pattern.design.behavioralDesignPatterns.visitor.shapes.Circle;
import com.pattern.design.behavioralDesignPatterns.visitor.shapes.CompoundShape;
import com.pattern.design.behavioralDesignPatterns.visitor.shapes.Dot;
import com.pattern.design.behavioralDesignPatterns.visitor.shapes.Rectangle;

/**
 * 비지터 인터페이스
 * - 객체 구조의 구상 요소를 인수로 사용할 수 있는 비지터 메서드의 집합을 선언
 * - 메서드들은 오버로딩으로 같은 이름을 가질 수 있지만 매개변수 유형은 달라야 함
 */
public interface Visitor {
    String visit(Dot dot);

    String visit(Circle circle);

    String visit(Rectangle rectangle);

    String visit(CompoundShape cg);
}