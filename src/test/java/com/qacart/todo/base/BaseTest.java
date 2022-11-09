package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.CookieUtils;
import io.restassured.http.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;


public class BaseTest {
    public WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new DriverFactory().initializeDrive();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();

            }
    public void injectCookiesToBrowser(List<Cookie> restAssuredCookies) {
        List<org.openqa.selenium.Cookie> seleniumCookies = CookieUtils.convertRestAssuredCookiestoSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie: seleniumCookies){
            driver.manage().addCookie(cookie);

        }
    }
}