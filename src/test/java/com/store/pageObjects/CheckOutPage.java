package com.store.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    WebDriver driver;
    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[name='message']")
    private WebElement txtCommentMessage;
    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    private WebElement btnPlaceOrder;

    public void enterComment(){
        txtCommentMessage.sendKeys("Testing");
    }
    public void clickOnPlaceOrder(){
        btnPlaceOrder.click();
    }
}
