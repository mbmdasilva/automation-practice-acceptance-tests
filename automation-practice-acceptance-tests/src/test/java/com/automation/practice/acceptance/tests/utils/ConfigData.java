package com.automation.practice.acceptance.tests.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigData {

    public Config getConfig() {
        return config;
    }

    Config config;

    public ConfigData() {
        String environment = System.getProperty("environment", "qa");
        this.config = ConfigFactory.parseResources("reference.conf").getConfig(environment);
    }

    public static class ConfigKeys {
        public static final String URL = "url";
    }
}
