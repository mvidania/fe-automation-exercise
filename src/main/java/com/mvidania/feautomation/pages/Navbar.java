package com.mvidania.feautomation.pages;

import com.mvidania.feautomation.utils.BrowserUtils;
import com.mvidania.feautomation.utils.Selectors;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Navbar {

    @Autowired
    BrowserUtils browserUtils;

    private static final Logger LOG = LoggerFactory.getLogger(Navbar.class);

    public void navigateToHome() throws InterruptedException {
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.NAVBAR_HOME)).click();
    }

    public void navigateToCart() throws InterruptedException {
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.NAVBAR_CART)).click();
    }
}
