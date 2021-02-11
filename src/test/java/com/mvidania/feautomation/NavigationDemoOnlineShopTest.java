package com.mvidania.feautomation;

import com.mvidania.feautomation.pages.*;
import com.mvidania.feautomation.utils.BrowserUtils;
import com.mvidania.feautomation.utils.WebDriverComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public abstract class NavigationDemoOnlineShopTest {

    @Autowired
    protected Home home;

    @Autowired
    protected ProductDetails productDetails;

    @Autowired
    protected Navbar navbar;

    @Autowired
    protected Cart cart;

    @Autowired
    protected OrderForm orderForm;

    @Autowired
    protected BrowserUtils browserUtils;

    @Autowired
    protected Confirmation confirmation;

    @Autowired
    WebDriverComponent driver;

}
