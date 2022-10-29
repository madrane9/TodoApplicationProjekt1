package com.qacart.todo.testcases;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class Dummy {
    public static void main(String[] args) {

        String responseBody ="{\n" +
                "    \"firstName\":\"alexx\",\n" +
                "    \"lastName\":\"samm\",\n" +
                "    \"email\":\"faker7@gmail.com\",\n" +
                "    \"password\":\"12345678\"\n" +
                "}";
       Response response =  given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(responseBody)
                .when()
                .post("/api/v1/users/register")
                .then().extract().response();
        String accessToken = response.path("access_token");
        System.out.println(accessToken);




    }
}
