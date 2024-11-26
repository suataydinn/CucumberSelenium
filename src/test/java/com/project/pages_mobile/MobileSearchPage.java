package com.project.pages_mobile;

import com.project.pages_web.BasePage;
import com.project.utilities.BrowserUtils;
import com.project.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MobileSearchPage extends BasePage {

    @FindBy(xpath = "//div[@data-test-id='search-bar-input']")
    public WebElement searchInput;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInputBox;

    @FindBy(xpath = "//div[@role='listbox']/ul/li")
    public List <WebElement> searchList;


    WebDriver driver = Driver.get();
    public MobileSearchPage() {
        PageFactory.initElements(driver, this);
    }


    public void searchProduct(String product){
        BrowserUtils.clickWithJSNotScroll(searchInput);
        BrowserUtils.waitFor(3);
        searchInputBox.sendKeys(product);
        for (int i = 1; i < 5; i++) {
            Assert.assertTrue(searchList.get(i).getText().contains(product));
        }

        searchList.get(1).click();
    }
}
