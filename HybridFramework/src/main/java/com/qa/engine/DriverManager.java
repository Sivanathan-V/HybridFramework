package com.qa.engine;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class DriverManager extends ProjectBase {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver2) {
        driver.set(driver2);
    }
    public void launchBrowser() {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();

        EdgeOptions option=new EdgeOptions();
        option.addArguments("--start-maximized");
        option.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DriverManager.driver.set(driver);
    }


}

