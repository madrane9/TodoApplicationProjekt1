package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo () {
        LoginPage loginpage =  new LoginPage(driver);
        String actualResult = loginpage.load()
                .login("madrane9@hotmail.com", "madrane9")
                .clickOnPlusButton()
                .adNewTask("Learn Selenium")
                .getTodoText();
        Assert.assertEquals(actualResult, "Learn Selenium");

    }
        @Test (enabled = false)
        public void shouldBeAbleToDeleteTodo() {
            LoginPage loginpage =  new LoginPage(driver);
            boolean isNoTodoMessageDisplayed =  loginpage
                    .load()
                    .login("madrane9@hotmail.com", "madrane9")
                    .clickOnPlusButton().adNewTask("Learn Selenium")
                    .clickOnDeleteButton()
                    .IsNoTodosMessageDisplayed();
            Assert.assertTrue(isNoTodoMessageDisplayed);

        }
    }

