package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword (){
        LoginPage loginpage =  new LoginPage(getDriver());
        boolean isWelcomeDisplayed =
                loginpage
                        .load()
                        .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                        .iswelcomeMessageDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);



    }
}