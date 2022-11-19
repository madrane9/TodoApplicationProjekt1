package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;


public class BaseTest {
    protected ThreadLocal<WebDriver> driver  = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }
    @BeforeMethod
    public void setup() {

        WebDriver driver = new DriverFactory().initializeDrive();
        setDriver(driver);
    }

    @AfterMethod
    public void teardown() {
        getDriver().quit();

            }
    @Step
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiestoSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie: seleniumCookies){
            getDriver().manage().addCookie(cookie);

        }
    }
}