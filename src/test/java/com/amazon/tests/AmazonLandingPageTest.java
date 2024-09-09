package com.amazon.tests;

import com.amazon.base.BaseTest;
import com.amazon.pages.AmazonLandingPage;
import com.amazon.propertyreader.PropertyReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonLandingPageTest extends BaseTest {

    protected AmazonLandingPage amazonLandingPage;

    @BeforeClass
    public void initializePage() {
        amazonLandingPage = PageFactory.initElements(driver, AmazonLandingPage.class);
    }


    @DataProvider(name = "dataForChangeLocationTest")
    private Object[][] dataForChangeLocationTest() {
        return new Object[][]{{152001}, {144620}};
    }
    @Test(priority = 1, dataProvider = "dataForChangeLocationTest")
    public void changeLocationTest(int pincode) {
        amazonLandingPage.changeLocation(pincode);
        Assert.assertTrue(amazonLandingPage.getPincodeFieldText().contains(String.valueOf(pincode)));
    }


    @Test(priority = 2)
    public void signIntoUserAccountTest() {
        amazonLandingPage.signIntoUserAccount(PropertyReader.readProperties("email"),
                PropertyReader.readProperties("password"));
        Assert.assertTrue(amazonLandingPage.getUsernameText().contains(PropertyReader.readProperties("username")));
    }


    @DataProvider(name = "dataForSearchProductTest")
    private Object[][] dataForSearchProductTest() {
        return new Object[][]{{"Scent"}, {"Cleaning Supplies"}};
    }
    @Test(priority = 3, dataProvider = "dataForSearchProductTest")
    public void searchProductTest(String productName) {
        amazonLandingPage.searchProduct(productName);
        Assert.assertTrue(amazonLandingPage.getSearchResultText().contains(productName));
    }

}
