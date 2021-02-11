package com.mvidania.feautomation.gherkinsteps.onlineshop;

import com.mvidania.feautomation.NavigationDemoOnlineShopTest;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class NavigationDemoOnlineShopSteps extends NavigationDemoOnlineShopTest {

    @After
    public void teardown(){
        browserUtils.closeBrowser();
    }

    @Given("Open Online shop")
    public void open_online_shop() {
        home.loadDemoOnlineShopFullScreen();
    }

    @When("Navigate to category {string} and product {string} and click on add to cart")
    public void navigate_to_category_laptops(String category, String product) throws Exception {
        home.addProductToCart(category, product);
    }

    @Then("Accept confirmation pop up when first product is added")
    public void accept_alert_pop_up() throws Exception{
        browserUtils.acceptAddedProductPopup();
    }

    @When("Navigate again to category {string} and product {string} and click on add to cart")
    public void navigate_again_to_category_laptops(String category, String product) throws Exception {
        navbar.navigateToHome();
        home.addProductToCart(category,product);
    }

    @Then("Accept confirmation alert when second product is added")
    public void add_second_product_to_cart_() throws Exception{
        browserUtils.acceptAddedProductPopup();
    }

    @When("Go to shopping cart")
    public void go_to_shopping_cart() throws Exception{
        navbar.navigateToCart();
    }

    @Then("Delete product {string} from shopping cart")
    public void delete_product_from_shopping_Cart(String product) throws Exception{
        cart.deleteProductFromCart(product);
    }

    @And("Click on place order button")
    public void click_on_place_order() throws Exception{
        cart.placeOrder();
    }

    @When("Fill form fields->Name:{string}, Country:{string}, City:{string}, Credit card:{string}, Month:{string}, Year:{string}")
    public void fill_form_fields(String name,String country,String city,String creditcard,String month,String year) throws Exception {
        orderForm.fillInCustomerFormDetails(name,country,city,creditcard,month,year)
                      .acceptCustomerFormDetails();
    }

    @Then("Capture order {string} and {string}")
    public void read_orderid_and_amount(String param1, String param2) throws Exception {
        String[] fields = {param1,param2};
        confirmation.logOrderDataFromConfirmationPopup(fields);
    }

    @And("Assert purchase {string} equals {string}")
    public void assert_amount_equals_expected(String expected, String amount){
        assertEquals(this.confirmation.retrieveFieldValue(expected), amount);
    }

}
