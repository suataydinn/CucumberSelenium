package com.project.step_definitions;

import com.project.web_pages.MainPage;
import com.project.web_pages.SearchPage;
import com.project.utilities.BrowserUtils;
import com.project.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;



public class SearchDefs {
    WebDriver driver = Driver.get();
    MainPage page = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Given("search {string} product")
    public void searchProduct(String arg0) {
    }
}