package com.mvidania.feautomation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrowserUtils {

    @Autowired
    private WebDriverComponent driver;

    private static final Logger LOG = LoggerFactory.getLogger(BrowserUtils.class);

    public void acceptAddedProductPopup() throws InterruptedException {
        LOG.info("****** Closing popup after adding product to cart");
        driver.getDriverWait().until(ExpectedConditions.alertIsPresent());
        driver.getWebDriver().switchTo().alert().accept();
    }

    public WebElement waitIfElementIsPresent(By by) throws InterruptedException {
        WebElement element = driver.getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }

    public boolean waitUntilElementDisappear(By by){
        return driver.getDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void closeBrowser(){
        driver.getWebDriver().quit();
    }

}
