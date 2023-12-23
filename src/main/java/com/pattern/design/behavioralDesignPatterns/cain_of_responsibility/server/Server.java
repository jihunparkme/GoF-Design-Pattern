package com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.server;

import com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware.Middleware;

import java.util.HashMap;
import java.util.Map;

/**
 * Server class.
 */
public class Server {
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    /**
     * 클라이언트는 개체 체인을 서버에 전달
     * - 유연성을 향상시키고 서버 클래스를 테스트하는 것을 더 쉽게 만듦
     */
    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    /**
     * 서버는 클라이언트로부터 이메일과 비밀번호를 받아 승인 요청을 체인으로 전달
     */
    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.

            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}