package org.corporatePortal;

import org.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.pageObjects.CorporatePortalPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.utilities.TestDataConstants;

import java.io.IOException;
import java.util.List;

public class CorporatePortalOurSites extends BaseTest {
    WebDriver driver;
    CorporatePortalPage corpPortalPage;
    public CorporatePortalOurSites() throws IOException {
        super(TestDataConstants.CORPORATEFUNDSURL);
        driver=super.getDriver();
    }

    @BeforeTest
    public void initialize()
    {
        corpPortalPage = new CorporatePortalPage(this.driver);
    }
    @Test(groups={"regression"})
    public void verifySites()
    {
        String currentLink;
        corpPortalPage.clickLinkOnOurSites("Personal investors");
        currentLink = driver.getCurrentUrl();
        Assert.assertEquals(currentLink,"https://investor.vanguard.com/");
    }
}
