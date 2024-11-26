package com.project.step_definitions;

import com.project.pages_web.*;
import com.project.pages_mobile.MobileSearchPage;
import com.project.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;


public class MobileSearchDefs {

    WebDriver driver = Driver.get();
    MainPage page = new MainPage();
    MobileSearchPage mobileSearchPage = new MobileSearchPage();


    @Given("mobile search {string} product")
    public void mobileSearchProduct(String product) {
        mobileSearchPage.searchProduct(product);
    }
}
