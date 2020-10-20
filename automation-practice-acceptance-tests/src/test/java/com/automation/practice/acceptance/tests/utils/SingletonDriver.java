package com.automation.practice.acceptance.tests.utils;

import org.openqa.selenium.WebDriver;

public class SingletonDriver {

    public static final WebDriver driver = new DriverFactory().getWebDriver();
}
