package com.pattern.design.structuralDesignPatterns.composite;

import com.pattern.design.structuralDesignPatterns.composite.editor.ImageEditor;
import com.pattern.design.structuralDesignPatterns.composite.shapes.Circle;
import com.pattern.design.structuralDesignPatterns.composite.shapes.CompoundShape;
import com.pattern.design.structuralDesignPatterns.composite.shapes.Dot;
import com.pattern.design.structuralDesignPatterns.composite.shapes.Rectangle;

import java.awt.*;

public class Demo {
    /**
     * 클라이언트
     * - 컴포넌트 인터페이스를 통해 모든 요소들과 작동
     * - 그 결과 클라이언트는 트리의 단순 요소들 또는 복잡한 요소들 모두에 대해 같은 방식으로 작업 가능
     */
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}