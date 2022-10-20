package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By EmailField        = By.cssSelector("[data-testid=\"email\"]");
    private By passwordField        = By.cssSelector("[data-testid=\"password\"]");
    private By submitButton         = By.cssSelector("[data-testid=\"submit\"]");



    public void load(){
        driver.get("https://qacart-todo.herokuapp.com/login");

    }

    public TodoPage login(String email, String password){
        driver.findElement(EmailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
        return new TodoPage(driver);
    }

    /*
    public void setEmail(String email){
        driver.findElement(EmailField).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    */


}
