package com.pattern.design.structuralDesignPatterns.adapter.practice;

/**
 * 클라이언트
 * - 프로그램의 기존 비즈니스 로직을 포함하는 클래스
 */
public class Client {

    private static final ClientService clientService = new ClientService();
    private static final OtherService otherService = new OtherService();

    /**
     * 클라이언트 코드는 클라이언트 인터페이스를 통해 어댑터와 작동하는 한 구상 어댑터 클래스와 결합하지 않음.
     * 덕분에 기존 클라이언트 코드를 손상하지 않고 새로운 유형의 어댑터들을 프로그램에 도입 가능
     * 이것은 서비스 클래스의 인터페이스가 변경되거나 교체될 때 유용
     * - 클라이언트 코드를 변경하지 않은 채 새 어댑터 클래스를 생성 가능
     */
    public static void main(String[] args) {
        asIs();
        toBe();
    }

    private static void asIs() {
        System.out.println("AS-IS");
        ClientInterface service = clientService;
        String result = service.method("10");
        System.out.println(result);
        // client service do something
    }

    private static void toBe() {
        System.out.println("TO-BE");
        ClientInterface service = new Adapter(otherService);
        String result = service.method("10");
        System.out.println(result);
        // convert to service format
        // other service do something
    }
}
