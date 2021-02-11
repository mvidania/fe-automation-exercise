package com.mvidania.feautomation.pages;

import com.mvidania.feautomation.utils.BrowserUtils;
import com.mvidania.feautomation.utils.Selectors;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cart{

    @Autowired
    BrowserUtils browserUtils;

    private static final Logger LOG = LoggerFactory.getLogger(Cart.class);

    public void deleteProductFromCart(String product) throws InterruptedException {
        LOG.info("****** Deleting product {}", product);
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findProductDeleteLink(product))).click();
        this.browserUtils.waitUntilElementDisappear(By.xpath(Selectors.findProductDeleteLink(product)));
    }

    public void placeOrder() throws InterruptedException {
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.PLACE_ORDER_BUTTON)).click();
    }
}
