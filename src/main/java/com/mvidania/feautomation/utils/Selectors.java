package com.mvidania.feautomation.utils;

public class Selectors {

    public static final String ADD_TO_CART_BUTTON="//a[text()='Add to cart']";
    public static final String PLACE_ORDER_BUTTON="//button[text()='Place Order']";
    public static final String NAVBAR_HOME="//a[@href='index.html']";
    public static final String NAVBAR_CART="//a[@href='cart.html']";
    public static final String PURCHASE_BUTTON="//button[text()='Purchase']";
    public static final String OK_BUTTON="//button[text()='OK']";
    public static final String CONFIRMATION_POPUP_DATA="//p[@class='lead text-muted ']";

    public static String findCategoryByName(String category){
        return "//a[text()='"+category+"']";
    }

    public static String findProductByName(String product){
        return "//a[text()='"+product+"']";
    }

    public static String findProductDeleteLink(String product){
        return "//td[text()='"+product+"']/following-sibling::td[2]/child::a";
    }

    public static String findInputById(String id){
        return "//div[@class='form-group']//input[@id='"+id+"']";
    }





}
