package com.mvidania.feautomation.pages;

import com.mvidania.feautomation.utils.BrowserUtils;
import com.mvidania.feautomation.utils.Selectors;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetails {

    @Autowired
    BrowserUtils browserUtils;

    private static final Logger LOG = LoggerFactory.getLogger(ProductDetails.class);

    public void addProductToCart() throws InterruptedException {
        LOG.info("****** Click on add to cart button");
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.ADD_TO_CART_BUTTON)).click();
    }
}
