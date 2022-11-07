package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;

public class Dummy {
    public static void main(String[] args) {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        System.out.println(registerApi.getUserId());
        System.out.println(registerApi.getToken());
        System.out.println(registerApi.getFirstName());


    }
}
