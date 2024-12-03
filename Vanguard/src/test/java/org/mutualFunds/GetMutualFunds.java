//created by @dhaamit
package org.mutualFunds;

import org.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.Driver;

public class GetMutualFunds extends BaseTest {
    final String mutualFundUrl = "/investment-products/list/mutual-funds";
    WebDriver driver;
    @Test
    public void getMutualFunds()
    {
        String title;
    //        driver.get("https://investor.vanguard.com" + mutualFundUrl);
        driver = super.getDriver();
        title = driver.findElement(By.xpath("//div[@class='discover-title']")).getText();
        System.out.println("inside Get Mutual Funds : " + title);
    }
}
