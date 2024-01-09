package com.pattern.design.behavioralDesignPatterns.visitor;

import com.pattern.design.behavioralDesignPatterns.visitor.shapes.*;
import com.pattern.design.behavioralDesignPatterns.visitor.visitor.XMLExportVisitor;

public class Demo {
    /**
     * Client
     * - 클라이언트는 일반적으로 컬렉션 또는 기타 복잡한 객체(ex. 복합체 트리)를 나타냄
     * - 일반적으로 클라이언트는 해당 컬렉션의 객체와 어떠한 추상 인터페이스를 통해 작업하기 때문에 모든 구상 요소 클래스들을 인식하지 못함
     */
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
    }

    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}