package com.store.TestCases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.pageObjects.HomePage;
import com.store.pageObjects.SignUp_loginPage;
import com.store.Pojo.LoginPojo;
import com.store.utilities.ReadExcel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TC_verifySignUp_LoginTest extends BaseClass{


    HomePage homePage;
    SignUp_loginPage signUpLoginPage;
    @Test(enabled = true)
    public void verifyRegistrationAndSignUp(){
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUp_loginPage(driver);
        homePage.clickOnSignUp();
        signUpLoginPage
                .enterUserName("Debasis")
                .enterEmail("testautomation3@gmail.com")
                .clickOnSignUp()
                .enterAccountDetails("test@1234")
                .enterAddressDetails("Test","Automation","1st Main Road","New Jersey","New Jersey","10001","9087278000")
                .clickOnCreateAccount();
        Assert.assertEquals("ACCOUNT CREATED!",signUpLoginPage.getAccountCreatedMessage());
        signUpLoginPage.clickContinue();
        homePage.clickOnDeleteAccount();
        Assert.assertEquals("ACCOUNT DELETED!",homePage.getAccountDeletedMessage());
        homePage.clickContinue();
    }

    @Test(enabled = true)
    public void verifyLoginUsingJsonData() throws IOException {

        File loginPayload = new File(System.getProperty("user.dir") + "//src//test//resources//TestData//testData.json");
        ObjectMapper objectMapper = new ObjectMapper();
        LoginPojo login = objectMapper.readValue(loginPayload, LoginPojo.class);

        homePage = new HomePage(driver);
        signUpLoginPage = new SignUp_loginPage(driver);
        homePage.clickOnSignUp();
        signUpLoginPage.loginIntoApplication(login.getEmail(),login.getPassword());
        String actualUserName = homePage.getLoggedInUserName();
        if(actualUserName.equals("Debasis")){
            captureScreenshot(driver,"verifyLogin");
            Assert.assertTrue(true);
        }
        else{
            captureScreenshot(driver,"verifyLogin");
            Assert.assertTrue(false);
        }
        homePage.ClickOnLogOut();
    }

    @Test(dataProvider = "LoginDataProvider")
    public void verifyLoginUsingTestNG(String email,String password,String expectedUserName) throws IOException {
        homePage = new HomePage(driver);
        signUpLoginPage = new SignUp_loginPage(driver);
        homePage.clickOnSignUp();
        signUpLoginPage.loginIntoApplication(email,password);
        String actualUserName = homePage.getLoggedInUserName();
        if(actualUserName.equals(expectedUserName)){
            captureScreenshot(driver,"verifyLogin");
            Assert.assertTrue(true);
        }
        else{
            captureScreenshot(driver,"verifyLogin");
            Assert.assertTrue(false);
        }
        homePage.ClickOnLogOut();
    }

    @DataProvider(name="LoginDataProvider")
    public String[][] LoginDataProvider(){
        String filePath = System.getProperty("user.dir") + "//src//test//resources//TestData//testData.xlsx";
        int rows = ReadExcel.getRowCount(filePath,"LoginData");
        int col = ReadExcel.getColCount(filePath,"LoginData");

        String data[][] = new String[rows-1][col];
        for(int i = 1;i<rows;i++){
            for(int j = 0;j<col;j++){
                data[i-1][j] = ReadExcel.getCellValue(filePath,"LoginData",i,j);
            }
        }
        return data;
    }
}
