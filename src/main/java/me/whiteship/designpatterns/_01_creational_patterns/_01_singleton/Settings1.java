package me.whiteship.designpatterns._01_creational_patterns._01_singleton;

/**
 * private 생성자와 public static 메소드를 사용하는 방법
 */
public class Settings1 {

    private static Settings1 instance;

    // private constructor
    private Settings1() {
    }

    // Global Access
    public static Settings1 getInstance() {
        if (instance == null) {
            instance = new Settings1();
        }

        return instance;
    }
}
