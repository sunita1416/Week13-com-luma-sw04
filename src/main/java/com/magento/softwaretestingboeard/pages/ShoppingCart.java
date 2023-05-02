package com.magento.softwaretestingboeard.pages;

import com.magento.softwaretestingboeard.utilities.Utility;
import org.openqa.selenium.By;

public class ShoppingCart extends Utility {
    By shoppingCartText = By.xpath("//span[@class='base']");
    By productCronusYogaPantName = By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']");
    By productYogaPantSizeText = By.xpath("//dd[contains(text(),'32')]");
    By productCronusYogaPantColourText = By.xpath("//dd[contains(text(),'Black')]");
    By productOvernightDuffleText = By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']");
    By productOverNightDuffleQtyText = By.xpath("//input[@title='Qty']");
    By productOvernightDufflePriceText = By.xpath("(//span[@class='cart-price']//span)[2]");
    By qtyFieldInCart = By.xpath("(//input[@class='input-text qty'])[1]");
    By updateShoppingCartButton = By.xpath("//div[@class='cart main actions']/descendant::button[2]");
    By productPrice = By.xpath("//td[@data-th='Subtotal']//span[@class='price']");

    public String verifyShoppingCartTitle() {
        return getTextElement(shoppingCartText);
    }
    public String verifyProductCronusYogaPantName(){
        return getTextElement(productCronusYogaPantName);
    }
    public String verifyProductCronusYogaPantSizeText(){
        return getTextElement(productYogaPantSizeText);
    }
    public String verifyProductCronusYogaPantColourText(){
        return getTextElement(productCronusYogaPantColourText);
    }
    public String verifyProductNameOvernightDuffle(){
        return getTextElement(productOvernightDuffleText);
    }
    public String verifyProductOvernightDuffleQtyText(String value){
        return getTheAttributeValue(productOverNightDuffleQtyText, value);
    }
    public String verifyProductOvernightDufflePriceText(){
        return getTextElement(productOvernightDufflePriceText);
    }
    public void changeFieldInCart(String qty){
        clearField(qtyFieldInCart);
        waitUntilVisibilityOfElementLocated(qtyFieldInCart,5);
        sendTextToElement(qtyFieldInCart,qty);
    }
    public void updateShoppingCart(){
        waitUntilVisibilityOfElementLocated(updateShoppingCartButton,5);
        clickOnElement(updateShoppingCartButton);
    }
    public String verifyProductPrice(){
        return getTextElement(productPrice);
    }

}
