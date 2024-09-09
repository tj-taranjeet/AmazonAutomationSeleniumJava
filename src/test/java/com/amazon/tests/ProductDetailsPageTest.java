package com.amazon.tests;

import com.amazon.base.BaseTest;
import com.amazon.pages.AmazonLandingPage;
import com.amazon.pages.ProductDetailsPage;
import com.amazon.pages.SearchResultsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductDetailsPageTest extends BaseTest {

    @DataProvider(name = "dataForAddProductToCartTest")
    private Object[][] dataForAddProductToCartTest() {
        return new Object[][] {{"Piano", 4}};
    }
    @Test(priority = 1, dataProvider = "dataForAddProductToCartTest")
    public void addProductToCartTest(String productName, int productNumberFromTheListOfAllProducts) {
        AmazonLandingPage amazonLandingPage = PageFactory.initElements(driver, AmazonLandingPage.class);
        SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        ProductDetailsPage productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);

        amazonLandingPage.searchProduct(productName);
        searchResultsPage.selectProduct(productNumberFromTheListOfAllProducts);
        productDetailsPage.addProductToCart();
        Assert.assertNotEquals(productDetailsPage.productCountInCartBeforeAddingProduct,
                productDetailsPage.productCountInCartAfterAddingProduct);
    }
}
