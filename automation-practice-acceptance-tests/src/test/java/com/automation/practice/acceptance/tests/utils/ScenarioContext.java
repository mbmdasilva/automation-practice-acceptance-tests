package com.automation.practice.acceptance.tests.utils;

import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ScenarioContext {

    public Map<WebElement, Double> sortMap(Map<WebElement, Double> prices){
        return prices.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
