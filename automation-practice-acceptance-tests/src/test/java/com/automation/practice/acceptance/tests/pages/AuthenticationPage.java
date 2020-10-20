package com.automation.practice.acceptance.tests.pages;

import com.automation.practice.acceptance.tests.actions.CommonUIActions;
import com.automation.practice.acceptance.tests.utils.DataBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends CommonUIActions {

    CreateAccountPage createAccountPage;
    LoginPage loginPage;
    WebDriver driver;
    DataBuilder dataBuilder;

    public AuthenticationPage (WebDriver driver, DataBuilder dataBuilder) {
        super(driver);
        this.createAccountPage = new CreateAccountPage(driver);
        this.loginPage = new LoginPage(driver);
        this.driver = driver;
        this.dataBuilder = dataBuilder;
    }



    @FindBy(css = "#email_create")
    WebElement emailAddress;

    @FindBy(css = "#SubmitCreate")
    WebElement createAccountButton;

    public AuthenticationPage enterEmailAddress(){
        typeInto(emailAddress, dataBuilder.getEmail());
        return this;
    }

    public AuthenticationPage clickCreateAccount() {
        createAccountButton.click();
        return this;
    }

    public AuthenticationPage createAccount() {
        createAccountPage.selectTitle(dataBuilder.getTitle())
                .enterCustomerFirstName(dataBuilder.getFirstN())
                .enterCustomerLastName(dataBuilder.getLastN())
                .enterEmail(dataBuilder.getEmail())
                .enterPassword(dataBuilder.getPassWord())
                .selectDOB(dataBuilder.getDob().get(0), dataBuilder.getDob().get(1), dataBuilder.getDob().get(2))
                .enterFirstName(dataBuilder.getFirstN())
                .enterLastName(dataBuilder.getLastN())
                .enterCompany(dataBuilder.getCompany())
                .enterAddressLine1(dataBuilder.getEnterAddressLine1())
                .enterAddressLine2(dataBuilder.getEnterAddressLine2())
                .enterCity(dataBuilder.getEnterCity())
                .selectState(dataBuilder.getEnterState())
                .enterPostCode(dataBuilder.getEnterPostCode())
                .enterMobilePhone(dataBuilder.getEnterMobilePhone())
                .submitCreateAccountRequest();
        return this;
    }

    public AuthenticationPage userLogin() {
        loginPage.enterUserName(dataBuilder.getEmail())
                .enterPassword(dataBuilder.getPassWord())
                .clickLogin();
                return this;
    }

    public AuthenticationPage userSignOut()  {
        loginPage.clickLogOut();
        return this;
    }
}
