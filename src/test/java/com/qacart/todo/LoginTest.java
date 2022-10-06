package com.qacart.todo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    @Test
    public void ShouldBeAbleToLoginWithEmailAndPassword (){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://qacart-todo.herokuapp.com/login");

        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("madrane9@hotmail.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("madrane9");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        boolean isWelcomeDisplayed = driver.findElement(By.cssSelector("[data-testid=\"welcome\"]")).isDisplayed();
        Assert.assertTrue(isWelcomeDisplayed);
        driver.quit();


    }
}