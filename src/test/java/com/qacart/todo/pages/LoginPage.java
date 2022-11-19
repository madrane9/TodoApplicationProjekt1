package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By EmailField        = By.cssSelector("[data-testid=\"email\"]");
    private By passwordField        = By.cssSelector("[data-testid=\"password\"]");
    private By submitButton         = By.cssSelector("[data-testid=\"submit\"]");


    @Step("Load the login page")
    public LoginPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;

    }
   @Step
    public TodoPage login(String email, String password){
        driver.findElement(EmailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return new TodoPage(driver);
    }


}
