package com.automation.practice.acceptance.tests.runner;

import com.automation.practice.acceptance.tests.utils.SingletonDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);
    WebDriver driver= SingletonDriver.driver;

    @Before
    public void beforeScenario(Scenario scenario) {
        LOG.info("###### Starting Scenario : {} ######", scenario.getName());
        driver.manage().deleteAllCookies();
    }


    @After
    public void afterScenario(Scenario scenario) {
        LOG.info("###### Finished Scenario : {} ######", scenario.getName());
        embedScreenshot(scenario);
        driver.quit();
    }

    public void embedScreenshot(Scenario scenario){
        if (scenario.isFailed()) {
            try {
                System.out.println("Scenario FAILED... screen shot taken");
                scenario.write(driver.getCurrentUrl());
                byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
            } catch (WebDriverException e) {
                LOG.error(e.getMessage());
            }
        }
    }
}
