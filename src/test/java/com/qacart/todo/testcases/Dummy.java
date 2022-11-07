package com.qacart.todo.testcases;

import com.qacart.todo.objects.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class Dummy {
    public static void main(String[] args) {

  User user = new User("tester3","tester3", "test3@gmx.de","123456"  );
       Response response =  given()
                .baseUri("https://qacart-todo.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/api/v1/users/register")
                .then().extract().response();
        String accessToken = response.path("access_token");
        System.out.println(accessToken);




    }
}
