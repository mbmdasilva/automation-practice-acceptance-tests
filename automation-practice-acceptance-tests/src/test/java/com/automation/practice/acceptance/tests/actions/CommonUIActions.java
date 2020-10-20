package com.automation.practice.acceptance.tests.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonUIActions {

    protected WebDriver driver;
    private WebDriverWait onWait;
    public Actions actions;

    public CommonUIActions(WebDriver driver) {
        this.driver = driver;
        onWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void waitForElementVisibility(WebElement element) {
        onWait.pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(element));
    }

    public CommonUIActions typeInto(WebElement element, String value) {
        waitForElementVisibility(element);
        element.clear();
        element.sendKeys(value);
        return this;
    }

    public CommonUIActions verifyPageTitle(String title){
        onWait.pollingEvery(Duration.ofSeconds(2)).until(ExpectedConditions.titleIs(title));
        return this;
    }
}
