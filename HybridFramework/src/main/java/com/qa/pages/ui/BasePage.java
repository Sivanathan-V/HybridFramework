package com.qa.pages.ui;

import com.google.common.collect.ImmutableList;
import com.qa.engine.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Properties;

import static com.qa.engine.ProjectBase.logInfo;

public abstract class BasePage {
    private final WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.driver.get();
        PageFactory.initElements(this.driver, this);
    }

    public WebDriver getDriver(){ return DriverManager.driver.get(); }

    public static String getAttribute(WebElement element, String attributeName) {
            return element.getAttribute(attributeName);
    }

    public String getAttribute(By webElement, String attribute) {
        return getDriver().findElement(webElement).getAttribute(attribute);
    }

    public void waitForVisibility(WebElement webElement) {
        if (getDriver() instanceof AndroidDriver) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } else if (getDriver() instanceof IOSDriver){
            Instant timeout = Instant.now().plusSeconds(60);

            while (!webElement.isEnabled()) {
                if (webElement.isEnabled())
                    break;
                if (Instant.now().isAfter(timeout))
                    throw new TimeoutException("Element is not present in the page");
            }
        }else {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(25));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        }
    }

    public void waitForVisibility(By webElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    public void click(WebElement webElement) {
        waitForVisibility(webElement);
        webElement.click();
        logInfo("Element clicked " + webElement);
    }

    public void click(By webElement) {
        waitForVisibility(webElement);
        getDriver().findElement(webElement).click();
    }

    public void sendKeys(WebElement webElement, String value) {
        waitForVisibility(webElement);
        webElement.sendKeys(value);
        logInfo("value entered " + value);
    }

    public void clear(WebElement webElement, String message) {
        waitForVisibility(webElement);
        webElement.clear();
        logInfo(message);
    }

    public void clickAndSendKeys(WebElement webElement, String txt, String message) {
        webElement.click();
        webElement.sendKeys(txt);
        logInfo(message);
    }

    public void clickAndSendKeys(By webElement, String txt, String msg) {
        getDriver().findElement(webElement).click();
        getDriver().findElement(webElement).sendKeys(txt);
        logInfo(msg);
    }
}
