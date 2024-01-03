package com.pattern.design.behavioralDesignPatterns.state;

import com.pattern.design.behavioralDesignPatterns.state.ui.Player;
import com.pattern.design.behavioralDesignPatterns.state.ui.UI;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}