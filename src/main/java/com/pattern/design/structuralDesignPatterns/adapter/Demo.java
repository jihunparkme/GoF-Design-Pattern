package com.pattern.design.structuralDesignPatterns.adapter;

import com.pattern.design.structuralDesignPatterns.adapter.adapters.SquarePegAdapter;
import com.pattern.design.structuralDesignPatterns.adapter.round.RoundHole;
import com.pattern.design.structuralDesignPatterns.adapter.round.RoundPeg;
import com.pattern.design.structuralDesignPatterns.adapter.square.SquarePeg;

public class Demo {
    /**
     * 둥근 구멍에 정사각형 못을 맞춰 넣기.
     */
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("반지름 5인 못은 반지름 5인 구멍에 적합.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);

        // 사각못 -> 원형못 어댑터
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("너비가 2인 사각못은 반지름 5인 원형 구멍에 적합.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("너비가 20인 사각못은 반지름 5인 원형 구멍에 부적합.");
        }
    }
}