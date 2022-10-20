package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword (){
        LoginPage loginpage =  new LoginPage(driver);
        loginpage.load();
        /* Diese 2 CodeLinien kann man zusammenfassen in einer Code-Linie:
        loginpage.setEmail("madrane9@hotmail.com");
        loginpage.setPassword("madrane9");
        */
         loginpage.login("madrane9@hotmail.com", "madrane9");

        TodoPage todoPage = new TodoPage(driver);
        boolean isWelcomeDisplayed = todoPage.iswelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);



    }
}