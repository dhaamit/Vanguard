//Author Amit Dharmale
package org.mutualFunds;

import org.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.util.TestDataConstants;
import java.io.IOException;

public class GetMutualFunds extends BaseTest  {
    WebDriver driver;

    public GetMutualFunds(String url) throws IOException {
        super(TestDataConstants.MUTUALFUNDSURL);
    }

    @Test(groups = {"regression", "functional"})
    public void getMutualFunds() {
        String title;
        driver = super.getDriver();
        title = driver.findElement(By.xpath("//div[@class='discover-title']")).getText();
        System.out.println("inside Get Mutual Funds : " + title);
    }

    @Test(groups = {"regression", "functional"})
    public void secondFunction() {
        System.out.println("second Test");
    }

    @AfterTest()
    public void closeTest() {
        driver.close();
    }
}