package com.pattern.design.behavioralDesignPatterns.cain_of_responsibility;

import com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware.Middleware;
import com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware.RoleCheckMiddleware;
import com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware.ThrottlingMiddleware;
import com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware.UserExistsMiddleware;
import com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    /**
     * 클라이언트
     * - 앱의 논리에 따라 체인들을 한 번만 구성하거나 동적으로 구성 가능
     * - 요청은 체인의 모든 핸들러에 보낼 수 있으며, 꼭 첫 번째 핸들러일 필요는 없다.
     */
    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // 모든 검사가 연결되어 있다. 클라이언트는 동일한 구성 요소를 사용하여 다양한 체인 구축이 가능하다.
        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        // 서버가 클라이언트 코드에서 체인을 가져온다.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}