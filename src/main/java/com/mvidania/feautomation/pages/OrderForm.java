package com.mvidania.feautomation.pages;

import com.mvidania.feautomation.constants.FrontElements;
import com.mvidania.feautomation.utils.BrowserUtils;
import com.mvidania.feautomation.utils.Selectors;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderForm{

    @Autowired
    BrowserUtils browserUtils;

    private static final Logger LOG = LoggerFactory.getLogger(OrderForm.class);

    public OrderForm fillInCustomerFormDetails(  String name,
                                                 String country,
                                                 String city,
                                                 String card,
                                                 String month,
                                                 String year) throws InterruptedException {
        LOG.info("****** Filling out order form with values: {},{},{},{},{},{}",name,country,city,card,month,year);
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findInputById(FrontElements.INPUT_NAME_ID))).sendKeys(name);
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findInputById(FrontElements.INPUT_COUNTRY_ID))).sendKeys(country);
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findInputById(FrontElements.INPUT_CITY_ID))).sendKeys(city);
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findInputById(FrontElements.INPUT_CREDITCARD_ID))).sendKeys(card);
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findInputById(FrontElements.INPUT_MONTH_ID))).sendKeys(month);
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.findInputById(FrontElements.INPUT_YEAR_ID))).sendKeys(year);
        return this;
    }

    public OrderForm acceptCustomerFormDetails() throws InterruptedException {
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.PURCHASE_BUTTON)).click();
        return this;
    }
}
