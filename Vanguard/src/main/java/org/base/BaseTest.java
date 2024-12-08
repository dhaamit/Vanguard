package org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    String Url = "https://investor.vanguard.com/investment-products/list/mutual-funds";
    WebDriver driver;

    public BaseTest() {
        setDriver();
        getUrl(this.driver);
    }

    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        options();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void getUrl(WebDriver driver) {
        driver.get(this.Url);
    }

    void options() {
        driver.manage().window().maximize();
    }
}
