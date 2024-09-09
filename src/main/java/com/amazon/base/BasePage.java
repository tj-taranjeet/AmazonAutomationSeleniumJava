package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForVisibilityThenClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickabilityThenClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitForVisibility(List<WebElement> listOfElements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfElements));
    }

    public void waitFor3Seconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted exception caught, coming from waitFor3Seconds method");
        }
    }

    public void loopThroughListandSelect(List<WebElement> list, String option) {
        for(WebElement w : list) {
            if(w.getText().equalsIgnoreCase(option)) {
                w.click();
                break;
            }
        }
    }
}
