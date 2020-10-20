package com.automation.practice.acceptance.tests.pages;

import com.automation.practice.acceptance.tests.actions.CommonUIActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonUIActions {

    @FindBy(css = ".login")
    WebElement signIn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage goToHomePage(String url){
        driver.get(url);
        return this;
    }

    public HomePage clickOnSignIn (){
        waitForElementVisibility(signIn);
        signIn.click();
        return this;
    }
}
