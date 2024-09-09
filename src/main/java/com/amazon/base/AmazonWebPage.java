package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonWebPage extends BasePage{

    protected TopRibbon topRibbon;

    public AmazonWebPage(WebDriver driver) {
        super(driver);
        topRibbon = PageFactory.initElements(driver, TopRibbon.class);
    }


    public void changeLocation(int pincode) {
        topRibbon.changeLocation(pincode);
    }
    public String getPincodeFieldText() {
        return topRibbon.getPincodeFieldText();
    }


    public void signIntoUserAccount(String email, String password) {
        topRibbon.signIntoUserAccount(email, password);
    }
    public String getUsernameText() {
        return topRibbon.getUsernameText();
    }


    public void searchProduct(String productName) {
        topRibbon.searchProduct(productName);
    }
    public String getSearchResultText() {
        return topRibbon.getSearchResultText();
    }

}
