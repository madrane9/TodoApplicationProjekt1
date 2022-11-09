package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo () {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        TodoPage todoPage = new TodoPage(driver);
        todoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());
        String actualResult = todoPage
                .load()
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
                    .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                    .clickOnPlusButton().adNewTask("Learn Selenium")
                    .clickOnDeleteButton()
                    .IsNoTodosMessageDisplayed();
            Assert.assertTrue(isNoTodoMessageDisplayed);

        }
    }

