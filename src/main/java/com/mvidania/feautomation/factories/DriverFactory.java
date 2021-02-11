package com.mvidania.feautomation.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();

    //chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "./drivers/selenium/chromedriver.exe");
        return new ChromeDriver();
    };

    //We might add more driver suppliers

    //Add more drivers to the map
    static{
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
    }

    public static final WebDriver getDriver(DriverType type){
        return driverMap.get(type).get();
    }
}
