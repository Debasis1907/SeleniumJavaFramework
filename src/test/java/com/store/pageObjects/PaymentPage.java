package com.store.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver driver;
    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[data-qa='name-on-card']")
    private WebElement txtEnterCardName;

    @FindBy(css = "input[data-qa='card-number']")
    private WebElement txtEnterCardNumber;

    @FindBy(css = "input[data-qa='cvc']")
    private WebElement txtEnterCVC;

    @FindBy(css = "input[data-qa='expiry-month']")
    private WebElement txtEnterExpiryMonth;

    @FindBy(css = "input[data-qa='expiry-year']")
    private WebElement txtEnterExpiryYear;

    @FindBy(css = "button[data-qa='pay-button']")
    private WebElement btnConfirmOrder;

    @FindBy(xpath = "(//div/p)[1]")
    private WebElement confirmationMessage;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement btnContinue;

    public PaymentPage enterCardDetails(String CardName,String CNumber,String cvc,String month,String year){
        CloseAd();
        txtEnterCardName.sendKeys("Debasis");
        txtEnterCardNumber.sendKeys("4236-5230-1256-1001");
        txtEnterCVC.sendKeys("111");
        txtEnterExpiryMonth.sendKeys("12");
        txtEnterExpiryYear.sendKeys("2030");
        return this;
    }

    public PaymentPage clickOnConfirmOrder(){
        CloseAd();
        btnConfirmOrder.click();
        return this;
    }

    public String getConfirmationMessage(){
        return confirmationMessage.getText();
    }

    public void clickOnContinue(){
        btnContinue.click();
    }
    public void CloseAd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }

}
