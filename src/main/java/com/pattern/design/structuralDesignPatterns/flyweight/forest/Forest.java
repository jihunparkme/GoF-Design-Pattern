package com.pattern.design.structuralDesignPatterns.flyweight.forest;

import com.pattern.design.structuralDesignPatterns.flyweight.trees.Tree;
import com.pattern.design.structuralDesignPatterns.flyweight.trees.TreeFactory;
import com.pattern.design.structuralDesignPatterns.flyweight.trees.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * 플라이웨이트의 클라이언트
 * - 플라이웨이트들의 공유된 상태를 저장하거나 계산
 * - 클라이언트의 관점에서 플라이웨이트는 일부 콘텍스트 데이터를 그의 메서드들의 매개변수들에 전달하여 런타임에 설정될 수 있는 템플릿 객체.
 */
public class Forest extends JFrame {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}
