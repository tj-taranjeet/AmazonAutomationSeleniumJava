package com.amazon.pages;

import com.amazon.base.AmazonWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends AmazonWebPage {

    @FindBy(css = "span[id='nav-cart-count']")
    protected WebElement cart;
    @FindBy(css = "input[id='add-to-cart-button']")
    protected WebElement addToCartButton;
    public String productCountInCartBeforeAddingProduct;
    public String productCountInCartAfterAddingProduct;
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }


    public void addProductToCart() {
        getProductCountInCartBeforeAddingProduct();
        waitForVisibilityThenClick(addToCartButton);
        getProductCountInCartAfterAddingProduct();
    }

    public String getProductCountInCartBeforeAddingProduct() {
        waitForVisibilityOfElement(cart);
        return productCountInCartBeforeAddingProduct = cart.getText();
    }

    public String getProductCountInCartAfterAddingProduct() {
        waitForVisibilityOfElement(cart);
        return productCountInCartAfterAddingProduct = cart.getText();
    }
}
