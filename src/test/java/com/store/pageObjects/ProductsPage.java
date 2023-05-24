package com.store.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.ClosedByInterruptException;
import java.time.Duration;

public class ProductsPage {

    WebDriver driver;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement linkViewProduct;

    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    private WebElement linkViewCart;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement btnAddToCart;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getProductsTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Automation Exercise - All Products"));
        return driver.getTitle();
    }

    public ProductsPage addToCart(){
        CloseAd();
        btnAddToCart.click();
        return this;
    }

    public void clickOnViewProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        CloseAd();
        linkViewProduct.click();
    }

    public ProductsPage clickOnViewCart(){
        CloseAd();
        linkViewCart.click();
        return this;
    }

    public void CloseAd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }
}
