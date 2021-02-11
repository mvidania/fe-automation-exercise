package com.mvidania.feautomation.utils;

import com.mvidania.feautomation.factories.DriverFactory;
import com.mvidania.feautomation.factories.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

@Component
public class WebDriverComponent {

    WebDriver webDriver     = DriverFactory.getDriver(DriverType.CHROME);
    WebDriverWait wait = new WebDriverWait(webDriver, 10);

    {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getDriverWait(){
        return wait;
    }

}
