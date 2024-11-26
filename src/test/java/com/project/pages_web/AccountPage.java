package com.project.pages_web;

import com.project.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage extends BasePage{

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#txtUserName")
    public WebElement userNameInput;

    @FindBy(css = "#txtPassword")
    public WebElement passwordInput;

    @FindBy(css = "#btnLogin")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='txtUserName']/../div[2]")
    public WebElement errorMessage;

    public void loginUser(String userName, String password){
        BrowserUtils.waitForVisibility(userNameInput,2);
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


}
