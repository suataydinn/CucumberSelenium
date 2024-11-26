package com.project.pages_web;

import com.project.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public abstract class BasePage {
    WebDriver driver = Driver.get();

    @FindBy(css = "#myAccount")
    public WebElement registerLocator;

    @FindBy(css = "#login")
    public WebElement loginLocator;
}

