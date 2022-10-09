package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {
    @Test
    public void shouldBeAbleToAddNewTodo () {

        driver.get("https://qacart-todo.herokuapp.com/login");

        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("madrane9@hotmail.com");
        driver.findElement(By.cssSelector("[data-testid=\"password\"]")).sendKeys("madrane9");
        driver.findElement(By.cssSelector("[data-testid=\"submit\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"add\"]")).click();
        driver.findElement(By.cssSelector("[data-testid=\"new-todo\"]")).sendKeys("Learn Selenium");
        driver.findElement(By.cssSelector("[data-testid=\"submit-newTask\"]")).click();
        String actualResult = driver.findElement(By.cssSelector("[data-testid=\"todo-item\"]")).getText();
        Assert.assertEquals(actualResult, "Learn Selenium");

    }
        @Test
        public void shouldBeAbleToDeleteTodo() {
            driver = new DriverFactory().initializeDrive();
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

