package com.amazon.pages;

import com.amazon.base.AmazonWebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SearchResultsPage extends AmazonWebPage {

    @FindBy(css = "span.a-size-base-plus")
    protected List<WebElement> listOfSearchedProducts;
    @FindBy(css = "div[class='tabular-buybox-label'][tabular-attribute-name='Sold by']")
    public WebElement sellersInfo;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectProduct(int productNumber) {
        listOfSearchedProducts.get(productNumber).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandleList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowHandleList.get(1));
        waitFor3Seconds();
    }

    public boolean didSelectedProductOpen() {
        if(sellersInfo.isDisplayed()){
            return true;
        }
        return false;
    }

}
