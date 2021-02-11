package com.mvidania.feautomation.pages;

import com.mvidania.feautomation.constants.Urls;
import com.mvidania.feautomation.utils.BrowserUtils;
import com.mvidania.feautomation.utils.Selectors;
import com.mvidania.feautomation.utils.WebDriverComponent;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Home {

    @Autowired
    ProductDetails productDetails;

    @Autowired
    BrowserUtils browserUtils;

    @Autowired
    WebDriverComponent driver;

    private static final Logger LOG = LoggerFactory.getLogger(Home.class);

    public void loadDemoOnlineShopFullScreen(){
        LOG.info("****** Opening browser and loading demo online shop on full screen");
        driver.getWebDriver().get(Urls.DEMO_ONLINE_SHOP);
        driver.getWebDriver().manage().window().maximize();
    }

    public Home addProductToCart(String category,String product) throws InterruptedException {

        LOG.info("****** Adding product {} with category {}", product, category);
        this.selectProductByCategory(category, product);
        this.productDetails.addProductToCart();
        return this;
    }

    public Home selectCategory(String category) throws InterruptedException {
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findCategoryByName(category))).click();
        return this;
    }

    public Home selectProduct(String product) throws InterruptedException {
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findProductByName(product))).click();
        return this;
    }

    public Home selectProductByCategory(String category, String product) throws InterruptedException {
        this.selectCategory(category).selectProduct(product);
        return this;
    }
}
