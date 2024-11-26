package com.project.step_definitions;

import com.project.pages_web.MainPage;
import com.project.pages_web.SearchPage;
import com.project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;



public class SearchDefs {
    WebDriver driver = Driver.get();
    MainPage page = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Given("search {string} product")
    public void searchProduct(String product) {
        searchPage.searchProduct(product);
    }

    @Then("search result should be {string}")
    public void searchResultShouldBe(String product) {
        Assert.assertEquals("verify search result title" ,searchPage.searchResultKeyword.getText() , product);
    }


}