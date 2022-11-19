package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoPage extends BasePage {

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    private By welcomeMessage = By.cssSelector("[data-testid=\"welcome\"]");
    private By addButton = By.cssSelector("[data-testid=\"add\"]");

    private By todoItem = By.cssSelector("[data-testid=\"todo-item\"]");
    private By deleteButton = By.cssSelector("[data-testid=\"delete\"]");

    private By noToDosMessage = By.cssSelector("[data-testid=\"no-todos\"]");
    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.TODO_END_POINT);
        return this;
    }
    @Step
    public boolean iswelcomeMessageDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();

    }
    @Step
    public NewTodoPage clickOnPlusButton (){
       driver.findElement(addButton).click();
       return new NewTodoPage(driver);
    }
    @Step
    public String getTodoText(){
         return driver.findElement(todoItem).getText();
    }
    @Step
    public TodoPage clickOnDeleteButton(){
        driver.findElement(deleteButton).click();
                return this;
    }
    @Step
    public boolean IsNoTodosMessageDisplayed(){
        return driver.findElement(noToDosMessage).isDisplayed();
    }
}
