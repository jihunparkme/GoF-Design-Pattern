package com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware;

import com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.server.Server;

/**
 * 구상 핸들러(Checks whether a user with the given credentials exists.)
 * - 요청을 처리하기 위한 실제 코드가 포함
 * - 각 핸들러는 요청을 받으면 이 요청을 처리할지와 함께 체인을 따라 전달할지 결정
 * - 핸들러들은 일반적으로 자체 포함형이고 불변하며, 생성자를 통해 필요한 모든 데이터를 한 번만 받는다.
 */
public class UserExistsMiddleware extends Middleware {
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}