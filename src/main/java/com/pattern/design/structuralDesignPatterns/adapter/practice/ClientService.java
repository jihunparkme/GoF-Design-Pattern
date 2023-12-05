package com.pattern.design.structuralDesignPatterns.adapter.practice;

public class ClientService implements ClientInterface {
    @Override
    public String method(String data) {
        return "client service do something";
    }
}
