package com.project.step_definitions;

import com.project.utilities.BrowserUtils;
import com.project.utilities.ConfigurationReader;
import com.project.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {
    public static String publicScenario;

    @Before
    public void setUp(Scenario scenario) {

        String browser="";
        for (String tag : scenario.getSourceTagNames()) {
            if (tag.equals("@browserWeb")) {
                publicScenario=tag;
                browser=ConfigurationReader.get("browserWeb");
                //Driver.get().get(ConfigurationReader.get("url1")); gibi urlde çeçitlendirilebilir
            } else if (tag.equals("@browserMobile")) {
                publicScenario=tag;
                browser=ConfigurationReader.get("browserMobile");
            }
        }
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        switch (browser) {
            case "chrome-headless" :
                Driver.get().manage().window().setSize(new Dimension(1440, 900));
                break;

            default:
                Driver.get().manage().window().maximize();
        }

        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForPageToLoad(30);

        BrowserUtils.scrollToSize(0,-500);

    }

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }

    @Before("@abc")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After("@abc")
    public void closeDb(){
        System.out.println("\tdisconnecting to database...");

    }


}
