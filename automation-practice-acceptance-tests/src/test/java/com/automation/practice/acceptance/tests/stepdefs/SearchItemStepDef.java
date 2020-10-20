package com.automation.practice.acceptance.tests.stepdefs;

import com.automation.practice.acceptance.tests.pages.AuthenticationPage;
import com.automation.practice.acceptance.tests.pages.HomePage;
import com.automation.practice.acceptance.tests.pages.SearchItem;
import com.automation.practice.acceptance.tests.utils.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchItemStepDef {

    WebDriver driver= SingletonDriver.driver;

    HomePage homePage = new HomePage(driver);
    DataBuilder dataContext = new DataBuilder().build();
    AuthenticationPage authenticationPage = new AuthenticationPage(driver, dataContext);
    SearchItem searchItem = new SearchItem(driver);
    Map<WebElement, Double> prices = new HashMap<>();
    ConfigData configData = new ConfigData();
    ScenarioContext scenarioContext= new ScenarioContext();

    @Given("^A new customer account is created$")
    public void a_new_customer_account_is_created() {
        homePage.goToHomePage(configData.getConfig().getString(ConfigData.ConfigKeys.URL));
        homePage.verifyPageTitle("My Store");
        homePage.clickOnSignIn();
        authenticationPage.enterEmailAddress().clickCreateAccount();
        authenticationPage.createAccount();
        authenticationPage.userSignOut();
        homePage.verifyPageTitle("Login - My Store");
    }

    @Given("^The customer logs in with the new account$")
    public void the_customer_logs_in_with_the_new_account() {
        homePage.clickOnSignIn();
        authenticationPage.userLogin();
    }

    @When("^The customer search for the most expensive (.*)$")
    public void the_customer_search_for_the_most_expensive_dresses(String saleItem) {
        searchItem.movePriceSlider();
         SalesItems item = SalesItems.valueOf(saleItem.toUpperCase());
         prices = searchItem.fetchPriceFilterItem(item);
    }

    @When("^The selected dress is added to cart$")
    public void the_selected_dress_is_added_to_cart() {
        int size = scenarioContext.sortMap(prices).size();
        double itemPrice= (Double)scenarioContext.sortMap(prices).values().toArray()[size-1];
        searchItem.addHighestPriceItemToCart((WebElement) scenarioContext.sortMap(prices).keySet().toArray()[size-1]);
        double selectedItem = searchItem.getPriceItemInCart();
        assertThat(itemPrice).isEqualTo(selectedItem);
    }

    @When("^The customer log out and back in again$")
    public void the_customer_log_out_and_back_in_again() {
        authenticationPage.userSignOut();
        homePage.verifyPageTitle("Order - My Store");
        homePage.clickOnSignIn();
        authenticationPage.userLogin();
    }

    @Then("^The selected dress must still be in the cart$")
    public void the_selected_dress_must_still_be_in_the_cart() {
        int size = scenarioContext.sortMap(prices).size();
        double itemPrice = (Double)scenarioContext.sortMap(prices).values().toArray()[size-1];
        double selectedItem = searchItem.getPriceItemInCart();
        assertThat(itemPrice).isEqualTo(selectedItem);
    }
}