package com.store.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class commonFunctions {

    public void selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByText(WebElement element,String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
}
