package com.pattern.design.creationalDesignPatterns.prototype;


import com.pattern.design.creationalDesignPatterns.prototype.shapes.Circle;
import com.pattern.design.creationalDesignPatterns.prototype.shapes.Rectangle;
import com.pattern.design.creationalDesignPatterns.prototype.shapes.Shape;

import java.util.List;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        // 프로토타입 인터페이스를 따르는 모든 객체의 복사본 생성 가능
        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        shapes.add(rectangle);

        cloneAndCompare(shapes, shapesCopy);
    }

    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        /**
         * 0: Shapes are different objects (yay!)
         * 0: And they are identical (yay!)
         * 1: Shapes are different objects (yay!)
         * 1: And they are identical (yay!)
         * 2: Shapes are different objects (yay!)
         * 2: And they are identical (yay!)
         */
        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                System.out.println(i + ": Shapes are different objects (yay!)");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    System.out.println(i + ": And they are identical (yay!)");
                } else {
                    System.out.println(i + ": But they are not identical (booo!)");
                }
            } else {
                System.out.println(i + ": Shape objects are the same (booo!)");
            }
        }
    }
}