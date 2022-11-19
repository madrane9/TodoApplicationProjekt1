package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest{
    @Story("Login with Email and Password")
    @Description("It will login by filling the email and the password  and navigate to the todo page ")
    @Test(description = "Test the login functionality using email and password")
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