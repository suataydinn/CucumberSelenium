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

        // set publicScenario
        for (String tag : scenario.getSourceTagNames()) {
            publicScenario = tag;

            switch (tag) {
                case "@browserWeb":
                    browser = ConfigurationReader.get("browserWeb");
                    break;

                case "@browserMobile":
                    browser = ConfigurationReader.get("browserMobile");
                    break;

                default:
                    // Farklı bir URL veya işlem burada ele alınabilir
                    // Örneğin: Driver.get().get(ConfigurationReader.get("url1"));
                    browser = null;
                    break;
            }
        }

        if(publicScenario.equals("@Api")){
            // do nothing
        }else{
            Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

            switch (browser) {
                case "chrome-headless" :
                    Driver.get().manage().window().setSize(new Dimension(1440, 900));
                    break;

                default:
                    Driver.get().manage().window().maximize();
            }

            // go to url
            Driver.get().get(ConfigurationReader.get("url"));
            BrowserUtils.waitForPageToLoad(10);

            //accept cookie
            if(Driver.get().findElements(By.cssSelector("#sp-cc-accept")).size()>0) Driver.get().findElement(By.cssSelector("#sp-cc-accept")).click();

        }

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
