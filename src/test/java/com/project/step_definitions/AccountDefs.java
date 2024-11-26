package com.project.step_definitions;

import com.project.pages_web.AccountPage;
import com.project.pages_web.MainPage;
import com.project.utilities.BrowserUtils;
import io.cucumber.java.en.*;

public class AccountDefs {

    MainPage mainPage = new MainPage();
    AccountPage accountPage = new AccountPage();

    @Given("click account button")
    public void click_account_button() {
        mainPage.registerLocator.click();
    }

    @When("click login button")
    public void click_login_button() {
        mainPage.loginLocator.click();
    }

    @Then("user see error message")
    public void userSeeErrorMessage() {
        BrowserUtils.verifyElementDisplayed(accountPage.errorMessage);
    }

    @And("send {string} e-mail {string} password")
    public void sendEMailPassword(String mail, String password) {
        accountPage.loginUser(mail, password);
    }

    @Then("user should be able to login")
    public void userShouldBeAbleToLogin() {
    }
}
