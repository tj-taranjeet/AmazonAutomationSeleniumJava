package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopRibbon extends BasePage{

    @FindBy(css = "a[aria-label='Amazon.in']")
    protected WebElement homeButton;
    @FindBy(css = "a[id='nav-global-location-popover-link']")
    protected WebElement locationButton;
    @FindBy(css = "input[aria-label='or enter an Indian pincode']")
    protected WebElement inputPincodeField;
    @FindBy(xpath = "//span[contains(text(),'Apply')] / preceding-sibling::input[1]")
    protected WebElement applyButton;
    @FindBy(css = "span[id='glow-ingress-line2']")
    protected WebElement pincodeFieldText;
    @FindBy(css = "input[placeholder='Search Amazon.in']")
    protected WebElement searchBox;
    @FindBy(css = "input[type='submit']")
    protected WebElement searchButton;
    @FindBy(css = "div[class='a-section a-spacing-small a-spacing-top-small']")
    protected WebElement searchResult;
    @FindBy(css = "div[id='nav-tools'] > a:first-child")
    protected WebElement languageButton;
    @FindBy(css = "div[class='a-row a-spacing-mini'] > div > label > i")
    protected List<WebElement> listOfLanguages;
    @FindBy(css = "span[id='icp-save-button']")
    protected WebElement saveButton;
    @FindBy(css = "a[data-nav-role='signin']")
    protected WebElement signinButton;
    @FindBy(css = "input[type='email']")
    protected WebElement emailField;
    @FindBy(css = "input[id='continue']")
    protected WebElement continueButton;
    @FindBy(css = "input[type='password']")
    protected WebElement passwordField;
    @FindBy(css = "input[id='signInSubmit']")
    protected WebElement signInButton;
    @FindBy(css = "span[id='nav-link-accountList-nav-line-1']")
    protected WebElement usernameElement;


    public TopRibbon(WebDriver driver) {
        super(driver);
    }


    public void goToHomePage() {
        waitFor3Seconds();
        homeButton.click();
    }


    public void changeLocation(int pincode) {
        waitForVisibilityThenClick(locationButton);
        waitForVisibilityOfElement(inputPincodeField);
        inputPincodeField.clear();
        inputPincodeField.sendKeys(String.valueOf(pincode));
        waitForVisibilityThenClick(applyButton);
        goToHomePage();
    }
    public String getPincodeFieldText() {
        return pincodeFieldText.getText();
    }


    public void signIntoUserAccount(String email, String password) {
        waitForVisibilityThenClick(signinButton);
        waitForVisibilityOfElement(emailField);
        emailField.sendKeys(email);
        continueButton.click();
        passwordField.sendKeys(password);
        signInButton.click();
    }
    public String getUsernameText() {
        return usernameElement.getText();
    }


    public void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();
    }
    public String getSearchResultText() {
        return searchResult.getText();
    }

}
