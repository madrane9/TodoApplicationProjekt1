package com.qacart.todo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TodoTest {
    @Test
    public void shouldBeAbleToAddNewTodo () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://qacart-todo.herokuapp.com/login");

        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("madrane9@hotmail.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("madrane9");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();

        String actualResult = driver.findElement(By.cssSelector("[data-testid=\"todo-item\"]")).getText();
        Assert.assertEquals(actualResult, "Learn Selenium");
        driver.quit();
    }
        @Test
        public void shouldBeAbleToDeleteTodo() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("https://qacart-todo.herokuapp.com/login");

            driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("madrane9@hotmail.com");
            driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("madrane9");
            driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
            driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
            driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Selenium");
            driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();
            driver.findElement(By.cssSelector("[data-testid=\"delete\"]")).click();
            boolean isNoTodoMessageDisplayed = driver.findElement(By.cssSelector("[data-testid=\"no-todos\"]")).isDisplayed();
            Assert.assertTrue(isNoTodoMessageDisplayed);
            driver.quit();

        }
    }

