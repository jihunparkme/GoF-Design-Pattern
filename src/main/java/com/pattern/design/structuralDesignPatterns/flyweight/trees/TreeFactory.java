package com.pattern.design.structuralDesignPatterns.flyweight.trees;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 플라이웨이트 팩토리
 * - 기존 플라이웨이트들의 풀을 관리
 * - 이 팩토리로 인해 클라이언트들은 플라이웨이트들을 직접 만들지 않는 대신 원하는 플라이웨이트의 고유한 상태의 일부를 전달하여 팩토리를 호출
 * - 팩토리는 이전에 생성된 플라이웨이트들을 살펴보고 검색 기준과 일치하는 기존 플라이웨이트를 반환하거나 기준에 맞는 플라이웨이트가 발견되지 않으면 새로 생성
 */
public class TreeFactory {
    static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String otherTreeData) {
        TreeType result = treeTypes.get(name);
        if (result == null) {
            result = new TreeType(name, color, otherTreeData);
            treeTypes.put(name, result);
        }
        return result;
    }
}