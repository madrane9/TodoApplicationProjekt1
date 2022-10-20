package com.qacart.todo.testcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoTest extends BaseTest {

    @Test
    public void shouldBeAbleToAddNewTodo () {
        LoginPage loginpage =  new LoginPage(driver);
        loginpage.load();
        TodoPage todopage = loginpage.login("madrane9@hotmail.com", "madrane9");
        NewTodoPage newTodoPage =  todopage.clickOnPlusButton();
        newTodoPage.adNewTask("Learn Selenium");


        String actualResult = todopage.getTodoText();
        Assert.assertEquals(actualResult, "Learn Selenium");

    }
        @Test
        public void shouldBeAbleToDeleteTodo() {
            LoginPage loginpage =  new LoginPage(driver);
            loginpage.load();
            TodoPage todopage = loginpage.login("madrane9@hotmail.com", "madrane9");
            NewTodoPage newTodoPage = todopage.clickOnPlusButton();
            newTodoPage.adNewTask("Learn Selenium");

            //Delete Button
            todopage.clickOnDeleteButton();
            boolean isNoTodoMessageDisplayed = todopage.IsNoTodosMessageDisplayed();
            Assert.assertTrue(isNoTodoMessageDisplayed);

        }
    }

