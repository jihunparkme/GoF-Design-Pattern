package com.pattern.design.creationalDesignPatterns.prototype.cache;

import com.pattern.design.creationalDesignPatterns.prototype.shapes.Circle;
import com.pattern.design.creationalDesignPatterns.prototype.shapes.Rectangle;
import com.pattern.design.creationalDesignPatterns.prototype.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

/**
 * PrototypeRegistry
 * - 프로토타입 레지스트리는 자주 사용하는 프로토타입들에 쉽게 접근하는 방법을 제공
 * - 이 레지스트리는 복사될 준비가 된 미리 만들어진 객체들의 집합을 저장
 * - 가장 간단한 프로토타입 레지스트리는 name → prototype 해시 맵
 * - 그러나 단순히 이름을 검색하는 것보다 더 나은 검색 기준이 필요한 경우 훨씬 더 탄탄한 레지스트리 구축 가능
 */
public class BundledShapeCache {
    private Map<String, Shape> cache = new HashMap<>();

    public BundledShapeCache() {
        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "Green";

        Rectangle rectangle = new Rectangle();
        rectangle.x = 6;
        rectangle.y = 9;
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "Blue";

        cache.put("Big green circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    public Shape put(String key, Shape shape) {
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key) {
        return cache.get(key).clone();
    }
}