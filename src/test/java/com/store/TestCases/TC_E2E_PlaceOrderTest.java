package com.store.TestCases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.pageObjects.*;
import com.store.Pojo.LoginPojo;
import com.store.utilities.ReadDataFromJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TC_E2E_PlaceOrderTest extends BaseClass{

    HomePage homePage;
    SignUp_loginPage signUpLoginPage;

    ProductsPage productsPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;

    PaymentPage paymentPage;

    @Test
    public void TC01_PlaceOrder_LoginBeforeCheckout() throws IOException, InterruptedException {

        File loginPayload = new File(System.getProperty("user.dir") + "//src//test//resources//TestData//testData.json");
        ObjectMapper objectMapper = new ObjectMapper();
        //LoginPojo data = objectMapper.readValue(loginPayload, LoginPojo.class); // Reading data from json object

        List<LoginPojo>data = objectMapper.readValue(loginPayload, new TypeReference<List<LoginPojo>>() {
        });

        homePage = new HomePage(driver);
        signUpLoginPage = new SignUp_loginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        paymentPage = new PaymentPage(driver);

        homePage.clickOnSignUp();
        signUpLoginPage.loginIntoApplication(data.get(0).getEmail(), data.get(0).getPassword());

        homePage.clickOnProductsLink();
        Assert.assertEquals(productsPage.getProductsTitle(),data.get(0).getProductsTitle());

        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getText().equals(data.get(0).getProduct())){
                productsPage.clickOnViewProduct();
                break;
            }
        }
        productsPage
                .addToCart()
                .clickOnViewCart();
        cartPage.clickOnProceedToCheckOut();

        checkOutPage.enterComment();
        checkOutPage.clickOnPlaceOrder();

        paymentPage.enterCardDetails(data.get(0).CardName, data.get(0).CardNumber, data.get(0).CVC, data.get(0).ExpiryMonth, data.get(0).getExpiryYear()).clickOnConfirmOrder();
        Assert.assertEquals(paymentPage.getConfirmationMessage(),"Congratulations! Your order has been confirmed!");
        paymentPage.clickOnContinue();

        homePage.ClickOnLogOut();
        Assert.assertEquals(homePage.getHomePageTitle(),"Automation Exercise - Signup / Login");
    }
}
