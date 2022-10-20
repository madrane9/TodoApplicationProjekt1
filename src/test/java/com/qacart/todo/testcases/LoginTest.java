package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword (){
        LoginPage loginpage =  new LoginPage(driver);
        boolean isWelcomeDisplayed =
                loginpage
                        .load()
                        .login("madrane9@hotmail.com", "madrane9")
                        .iswelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);



    }
}