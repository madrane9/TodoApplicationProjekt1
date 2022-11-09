package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
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

    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + "/todo");
        return this;
    }

    public boolean iswelcomeMessageDisplayed() {
        return driver.findElement(welcomeMessage).isDisplayed();

    }

    public NewTodoPage clickOnPlusButton (){
       driver.findElement(addButton).click();
       return new NewTodoPage(driver);
    }

    public String getTodoText(){
         return driver.findElement(todoItem).getText();
    }
    public TodoPage clickOnDeleteButton(){
        driver.findElement(deleteButton).click();
                return this;
    }

    public boolean IsNoTodosMessageDisplayed(){
        return driver.findElement(noToDosMessage).isDisplayed();
    }
}
