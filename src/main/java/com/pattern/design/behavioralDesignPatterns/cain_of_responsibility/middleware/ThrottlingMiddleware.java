package com.pattern.design.behavioralDesignPatterns.cain_of_responsibility.middleware;

/**
 * 구상 핸들러(Checks whether there are too many failed login requests.)
 * - 요청을 처리하기 위한 실제 코드가 포함
 * - 각 핸들러는 요청을 받으면 이 요청을 처리할지와 함께 체인을 따라 전달할지 결정
 * - 핸들러들은 일반적으로 자체 포함형이고 불변하며, 생성자를 통해 필요한 모든 데이터를 한 번만 받는다.
 */
public class ThrottlingMiddleware extends Middleware {
    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    /**
     * 메서드의 시작과 끝 모두에 checkNext() 호출을 삽입할 수는 없음
     * - 모든 미들웨어 개체에 대한 단순한 루프보다 훨씬 더 많은 유연성을 제공
     * - 예를 들어, 체인의 한 요소는 다른 모든 검사 후에 검사를 실행함으로써 검사 순서를 변경 가능
     */
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(email, password);
    }
}