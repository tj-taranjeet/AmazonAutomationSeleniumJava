package com.amazon.tests;

import com.amazon.base.BaseTest;
import com.amazon.pages.AmazonLandingPage;
import com.amazon.pages.SearchResultsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchResultsPageTest extends BaseTest {

    @DataProvider(name = "dataForSelectProductTest")
    public Object[][] dataForSelectProductTest() {
        return new Object[][]{{"Eau de parfum", 3}};
    }

    @Test(priority = 1, dataProvider = "dataForSelectProductTest")
    public void selectProductTest(String productName, int productNumber) {
        AmazonLandingPage amazonLandingPage = PageFactory.initElements(driver, AmazonLandingPage.class);
        SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);

        amazonLandingPage.searchProduct(productName);
        searchResultsPage.selectProduct(productNumber);
        Assert.assertTrue(searchResultsPage.didSelectedProductOpen());
    }
}
