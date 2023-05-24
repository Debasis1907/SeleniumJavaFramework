package com.store.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //identify webelements
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    private WebElement btnSignUp;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement deleteAccount;

    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    private WebElement accountDeletedMessage;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement btnContinue;

    @FindBy(xpath = "//b[normalize-space()='Debasis']")
    private WebElement loggedInUsername;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement linkProducts;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement btnLogOut;
    public void clickOnSignUp(){
        btnSignUp.click();
    }

    public void clickOnDeleteAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccount));
        deleteAccount.click();
    }

    public String getAccountDeletedMessage(){
        String message = accountDeletedMessage.getText();
        return message;
    }

    public void clickContinue(){
        btnContinue.click();
    }

    public String getLoggedInUserName(){
        return loggedInUsername.getText();
    }

    public void clickOnProductsLink(){
        linkProducts.click();
    }

    public void ClickOnLogOut(){
        btnLogOut.click();
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }
}
