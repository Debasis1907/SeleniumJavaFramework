package com.store.pageObjects;

import com.store.utilities.commonFunctions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp_loginPage {

    public WebDriver driver;
    commonFunctions cmnFunctions = new commonFunctions();

    public SignUp_loginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[data-qa='signup-name']")
    private WebElement txtUsername;

    @FindBy(css = "[data-qa='signup-email']")
    private WebElement txtEmailAddress;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement btnSignUp;

    @FindBy(id = "id_gender1")
    private WebElement rdTitle;

    @FindBy(css = "[data-qa='password']")
    private WebElement txtPassword;
    @FindBy(css = "[id='newsletter']")
    private WebElement checkNewsLetter;
    @FindBy(css = "[data-qa='first_name']")
    private WebElement txtFirstName;

    @FindBy(css = "[data-qa='last_name']")
    private WebElement txtLastName;

    @FindBy(css = "[data-qa='address']")
    private WebElement txtAddress;

    @FindBy(css = "[data-qa='state']")
    private WebElement txtState;

    @FindBy(css = "[data-qa='city']")
    private WebElement txtCity;

    @FindBy(css = "[data-qa='zipcode']")
    private WebElement txtZipcode;

    @FindBy(css = "[data-qa='mobile_number']")
    private WebElement txtMobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement btnCreateAccount;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    private WebElement accountCreatedMessage;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement btnContinue;

    @FindBy(css = "select[data-qa='days']")
    private WebElement selectDate;

    @FindBy(css = "select[data-qa='months']")
    private WebElement selectMonth;

    @FindBy(css = "select[data-qa='years']")
    private WebElement selectYear;

    @FindBy(css = "[data-qa='country']")
    private WebElement selectCountry;

    @FindBy(css = "[data-qa='login-email']")
    private WebElement txtEmailID_Login;

    @FindBy(css = "[data-qa='login-password']")
    private WebElement txtPassword_Login;

    @FindBy(css = "[data-qa='login-button']")
    private WebElement btnLogin;

    //Method to Login to application

    public void loginIntoApplication(String emailID,String pass){
        txtEmailID_Login.sendKeys(emailID);
        txtPassword_Login.sendKeys(pass);
        btnLogin.click();
    }

    public SignUp_loginPage enterUserName(String username){
        txtUsername.sendKeys(username);
        return this;
    }

    public SignUp_loginPage enterEmail(String email){
        txtEmailAddress.sendKeys(email);
        return this;
    }

    public SignUp_loginPage clickOnSignUp(){
        btnSignUp.click();
        return this;
    }

    public SignUp_loginPage enterAccountDetails(String password){
        CloseAd();
        rdTitle.click();
        txtPassword.sendKeys(password);
        cmnFunctions.selectByValue(selectDate,"7");
        cmnFunctions.selectByText(selectMonth,"May");
        cmnFunctions.selectByText(selectYear,"2000");
        checkNewsLetter.click();
        return this;
    }

    public SignUp_loginPage enterAddressDetails(String firstName, String lastName, String address, String state, String city, String zipcode, String mobileNumber){
        CloseAd();
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        txtAddress.sendKeys(address);
        cmnFunctions.selectByText(selectCountry,"United States");
        txtState.sendKeys(state);
        txtCity.sendKeys(city);
        txtZipcode.sendKeys(zipcode);
        txtMobileNumber.sendKeys(mobileNumber);
        return this;
    }

    public SignUp_loginPage clickOnCreateAccount(){
        CloseAd();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", btnCreateAccount);
        btnCreateAccount.click();
        return this;
    }

    public String getAccountCreatedMessage(){
        String message = accountCreatedMessage.getText();
        return message;
    }

    public void clickContinue(){
        CloseAd();
        btnContinue.click();
    }

    public void CloseAd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }
}
