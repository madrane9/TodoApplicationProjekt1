package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword (){

        driver.get("https://qacart-todo.herokuapp.com/login");
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("madrane9@hotmail.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("madrane9");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        boolean isWelcomeDisplayed = driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).isDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);



    }
}