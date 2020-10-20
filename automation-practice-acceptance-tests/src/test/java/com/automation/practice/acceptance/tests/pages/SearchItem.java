package com.automation.practice.acceptance.tests.pages;

import com.automation.practice.acceptance.tests.actions.CommonUIActions;
import com.automation.practice.acceptance.tests.utils.SalesItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchItem extends CommonUIActions {

    public SearchItem(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    WebElement dresses;


    public void movePriceSlider() {
        dresses.click();
        int width = driver.findElement(By.cssSelector(".ui-slider-range")).getSize().getWidth();
        actions.clickAndHold(driver.findElements(By.cssSelector(".ui-slider-handle")).get(0));
        actions.moveByOffset(width, 0);
        actions.release().perform();
    }

    public Map<WebElement, Double> fetchPriceFilterItem(SalesItems value) {

         Map<WebElement, Double> prices = new HashMap<>();
                 switch(value){
                     case DRESSES:
                         List<WebElement> items = driver.findElements(By.cssSelector("div.right-block > div.content_price > span.price.product-price"));
                         items.forEach(element -> prices.put(element, Double.parseDouble(element.getText().replace("$", ""))));
                         break;
        }
       return prices;
    }

    public void addHighestPriceItemToCart(WebElement element) {
        element.click();
        driver.findElement(By.cssSelector("div > span[class='cross']")).click();
    }

    public Double getPriceItemInCart() {
        actions.clickAndHold(driver.findElement(By.cssSelector(".shopping_cart > a > b")));
        actions.release().perform();
        return Double.parseDouble(driver.findElement(By.cssSelector("#total_product")).getText().replace("$", ""));
    }

}
