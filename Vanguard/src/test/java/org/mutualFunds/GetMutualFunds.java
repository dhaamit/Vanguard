//Author Amit Dharmale
package org.mutualFunds;

import org.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.pageObjects.MutualFundsPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.utilities.TestDataConstants;
import java.io.IOException;

public class GetMutualFunds extends BaseTest  {
    WebDriver driver;
    MutualFundsPage mutualFundsPage;
    public GetMutualFunds() throws IOException {
        super(TestDataConstants.MUTUALFUNDSURL);
        driver = super.getDriver();
    }

    @BeforeTest
    public void initialize()
    {
       mutualFundsPage = new MutualFundsPage(driver);
    }

    @Test(groups = {"regression", "functional"})
    public void verifyTitle() {
        Assert.assertEquals(mutualFundsPage.getTitle(), "Vanguard mutual funds");
    }

    @Test(groups = {"regression", "functional"})
    public void verifyName() {
        System.out.println(mutualFundsPage.getIndexOfSymbol("VAIGX"));
    }

    @AfterTest()
    public void closeTest() {
        driver.close();
    }
}