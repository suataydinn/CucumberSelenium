package com.project.web_pages;

import com.project.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage() {PageFactory.initElements(Driver.get(), this);}

}
