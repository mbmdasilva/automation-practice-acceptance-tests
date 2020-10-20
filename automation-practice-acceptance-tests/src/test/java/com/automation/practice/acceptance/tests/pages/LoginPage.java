package com.automation.practice.acceptance.tests.pages;

import com.automation.practice.acceptance.tests.actions.CommonUIActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonUIActions {

    @FindBy(css = "#email")
    WebElement userName;

    @FindBy(css = "#passwd")
    WebElement passWord;

    @FindBy(css = "#SubmitLogin")
    WebElement submitLogin;

    @FindBy(css = ".logout")
    WebElement logOut;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUserName(String username){
        typeInto(userName, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        typeInto(passWord, password);
       return this;
    }

    public LoginPage clickLogin(){
        waitForElementVisibility(submitLogin);
        submitLogin.click();
        return this;
    }

    public LoginPage clickLogOut(){
        waitForElementVisibility(logOut);
        logOut.click();
        return this;
    }
}
