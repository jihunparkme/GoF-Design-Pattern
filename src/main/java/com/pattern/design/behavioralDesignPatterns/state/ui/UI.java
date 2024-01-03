package com.pattern.design.behavioralDesignPatterns.state.ui;

import javax.swing.*;
import java.awt.*;

public class UI {
    private Player player;
    private static JTextField textField = new JTextField();

    public UI(Player player) {
        this.player = player;
    }

    public void init() {
        JFrame frame = new JFrame("Test player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel context = new JPanel();
        context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
        frame.getContentPane().add(context);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        context.add(textField);
        context.add(buttons);

        // 컨텍스트는 사용자의 입력을 상태 객체로 처리하는 대표자이다.
        // 모든 상태가 입력을 다르게 처리할 수 있으므로 현재 어떤 상태가 활성화되어 있는지에 따라 결과가 달라진다.
        JButton play = new JButton("Play");
        play.addActionListener(e -> textField.setText(player.getState().onPlay()));

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> textField.setText(player.getState().onLock()));

        JButton next = new JButton("Next");
        next.addActionListener(e -> textField.setText(player.getState().onNext()));

        JButton prev = new JButton("Prev");
        prev.addActionListener(e -> textField.setText(player.getState().onPrevious()));

        frame.setVisible(true);
        frame.setSize(300, 100);

        buttons.add(play);
        buttons.add(stop);
        buttons.add(next);
        buttons.add(prev);
    }
}