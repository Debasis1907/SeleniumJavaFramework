package com.store.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement btnProceedToCheckOut;

    public void clickOnProceedToCheckOut(){
        btnProceedToCheckOut.click();
    }
}
