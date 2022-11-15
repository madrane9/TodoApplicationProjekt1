package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo () throws InterruptedException {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTodoPage newTodoPage = new NewTodoPage(driver);
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult = newTodoPage
                .load()
                .adNewTask("Learn Selenium")
                .getTodoText();
        Assert.assertEquals(actualResult, "Learn Selenium");

    }
        @Test (enabled = false)
        public void shouldBeAbleToDeleteTodo() {
            LoginPage loginpage =  new LoginPage(driver);
            boolean isNoTodoMessageDisplayed =  loginpage
                    .load()
                    .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                    .clickOnPlusButton().adNewTask("Learn Selenium")
                    .clickOnDeleteButton()
                    .IsNoTodosMessageDisplayed();
            Assert.assertTrue(isNoTodoMessageDisplayed);

        }
    }

