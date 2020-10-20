package com.automation.practice.acceptance.tests.pages;

import com.automation.practice.acceptance.tests.actions.CommonUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class CreateAccountPage extends CommonUIActions {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#customer_firstname")
    WebElement customerFirstName;

    @FindBy(css = "#customer_lastname")
    WebElement customerLastName;

    @FindBy(css = "#email")
    WebElement email;

    @FindBy(css = "#passwd")
    WebElement password;

    @FindBy(css = "#days")
    WebElement days;

    @FindBy(css = "#months")
    WebElement months;

    @FindBy(css = "#years")
    WebElement years;

    @FindBy(css = "#firstname")
    WebElement firstName;

    @FindBy(css = "#lastname")
    WebElement lastName;

    @FindBy(css = "#company")
    WebElement company;

    @FindBy(css = "#address1")
    WebElement addressLine_1;

    @FindBy(css = "#address2")
    WebElement addressLine_2;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#id_state")
    WebElement state;

    @FindBy(css = "#postcode")
    WebElement postcode;

    @FindBy(css = "#phone")
    WebElement phone;

    @FindBy(css = "#submitAccount")
    WebElement submitAccount;

    @FindBy(css = "#phone_mobile")
    WebElement phone_mobile;


    public CreateAccountPage selectTitle(int value) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement title= driver.findElement(By.cssSelector(String.format("#id_gender%s", value)));
        title.click();
        return this;
    }

    public  CreateAccountPage enterCustomerFirstName(String value) {
        typeInto(customerFirstName, value);
        return this;
    }

    public CreateAccountPage enterCustomerLastName(String value){
        typeInto(customerLastName, value);
        return this;
    }

    public CreateAccountPage enterEmail(String value ) {
        if (!email.getText().equalsIgnoreCase(value)) {
            typeInto(email, value);
        }
        typeInto(email, value);
        return this;
    }

    public CreateAccountPage enterPassword(String value) {
        typeInto(password, value);
        return this;
    }

    public CreateAccountPage selectDOB(String day,String month,String year) {
        days.findElement(By.cssSelector(String.format("option[value='%s']", day))).click();
        months.findElement(By.cssSelector(String.format("option[value='%s']", month))).click();
        years.findElement(By.cssSelector(String.format("option[value='%s']", year))).click();
        return this;
    }

    public CreateAccountPage enterFirstName(String value) {
        if (!firstName.getText().equalsIgnoreCase(value)) {
            typeInto(firstName, value);
        }
        return this;
    }

    public CreateAccountPage enterLastName(String value) {
        if (!lastName.getText().equalsIgnoreCase(value)) {
            typeInto(lastName, value);
        }
        return this;
    }

    public CreateAccountPage enterCompany(String value) {
        typeInto(company, value);
        return this;
    }

    public CreateAccountPage enterAddressLine1(String value) {
        typeInto(addressLine_1, value);
        return this;
    }

    public CreateAccountPage enterAddressLine2(String value) {
        typeInto(addressLine_2, value);
        return this;
    }

    public CreateAccountPage enterCity(String value) {
        typeInto(city, value);
        return this;
    }

    public CreateAccountPage selectState(int value) {
        state.findElement(By.cssSelector(String.format("option[value='%s']", value))).click();
        return this;
    }

    public CreateAccountPage enterPostCode(String value) {
        typeInto(postcode, value);
        return this;
    }

    public CreateAccountPage enterHomePhone(String value) {
        typeInto(phone, value);
        return this;
    }

    public CreateAccountPage enterMobilePhone(String value) {
        typeInto(phone_mobile, value);
        return this;
    }

    public CreateAccountPage submitCreateAccountRequest(){
        submitAccount.click();
        return this;
    }
}
