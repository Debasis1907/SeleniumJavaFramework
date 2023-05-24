package com.store.Pojo;

public class LoginPojo {

    public String Email;
    public String password;

    public String product;

    public String productsTitle;

    public String CardName;

    public String CardNumber;
    public String CVC;
    public String ExpiryMonth;
    public String ExpiryYear;

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getCVC() {
        return CVC;
    }

    public void setCVC(String CVC) {
        this.CVC = CVC;
    }

    public String getExpiryMonth() {
        return ExpiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        ExpiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return ExpiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        ExpiryYear = expiryYear;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductsTitle() {
        return productsTitle;
    }

    public void setProductsTitle(String productsTitle) {
        this.productsTitle = productsTitle;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
