package com.mvidania.feautomation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/onlineshop",
        plugin = {"pretty"},
        glue = {"com.mvidania.feautomation.gherkinsteps.onlineshop"})
public class DemoOnlineShopTest {

}
