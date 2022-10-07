package com.qacart.todo.testcases;

import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword (){
        driver = new DriverFactory().initializeDrive();
        driver.get("https://qacart-todo.herokuapp.com/login");
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("madrane9@hotmail.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("madrane9");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        boolean isWelcomeDisplayed = driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).isDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
        driver.quit();


    }
}