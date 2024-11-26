package com.project.pages_web;

import com.project.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    WebDriver driver = Driver.get();
    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

}
