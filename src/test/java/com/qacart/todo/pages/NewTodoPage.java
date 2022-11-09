package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewTodoPage extends BasePage {

    public NewTodoPage(WebDriver driver) {
        super(driver);
    }
    private By newToDo = By.cssSelector("[data-testid=\"new-todo\"]");
    private By submitButton = By.cssSelector("[data-testid=\"submit-newTask\"]");

    public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }
public TodoPage adNewTask(String item){
        driver.findElement(newToDo).sendKeys(item);
        driver.findElement(submitButton).click();
        return new TodoPage(driver);
}
}
