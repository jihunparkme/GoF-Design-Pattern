package com.pattern.design.creationalDesignPatterns.prototype.shapes;

/**
 * ConcretePrototype
 * - 구상 프로토타입 클래스는 복제 메서드를 구현
 * - 원본 객체의 데이터를 복제본에 복사하는 것 외에도 이 메서드는 복제 프로세스와 관련된 일부 예외적인 경우들도 처리 가능
 * - 예: 연결된 객체 복제, 재귀 종속성 풀기
 */
public class Circle extends Shape {
    public int radius;

    public Circle() {
    }

    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.radius = target.radius;
        }
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle) || !super.equals(object2)) return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }
}