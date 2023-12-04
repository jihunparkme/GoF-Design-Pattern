package com.pattern.design.creationalDesignPatterns.singleton.non_thread_safe;

public class DemoSingleThread {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value); // FOO
        System.out.println(anotherSingleton.value); // FOO
    }
}