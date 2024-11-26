package com.project.pages_web;

import com.project.utilities.BrowserUtils;
import com.project.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@role='listbox']/div[1]/div")
    public List <WebElement> searchList;

    @FindBy(css = "h1")
    public WebElement searchResultKeyword;

    WebDriver driver = Driver.get();
    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product){
        BrowserUtils.clickWithJSNotScroll(searchInput);
        BrowserUtils.waitFor(3);
        searchInput.sendKeys(product);
        for (int i = 1; i < 5; i++) {
            Assert.assertTrue(searchList.get(i).getText().contains(product));
        }

        searchList.get(1).click();
    }

}
