//Author - @Amit Dharmale
package org.corporatePortal;

import org.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.pageObjects.CorporatePortalPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utilities.DataUtil;
import org.utilities.TestDataConstants;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CorporatePortalOurSitesTest extends BaseTest {
    WebDriver driver;
    CorporatePortalPage corpPortalPage;
    final String TESTDATAFILEPATH = "./src/test/resources/TestData/CorporatePortalSitesList.txt";
    public CorporatePortalOurSitesTest() throws IOException {
        super(TestDataConstants.CORPORATEFUNDSURL);
        driver = super.getDriver();
    }

    @BeforeTest
    public void initialize() {
        corpPortalPage = new CorporatePortalPage(this.driver);
    }

    @DataProvider(name = "dataForCorporatePortalSites")
    public Object[][] dataForCorpSite(){
        List <String[]> dVal = new ArrayList<>();
        dVal = DataUtil.readTestData(TESTDATAFILEPATH);
        Object [][] dataObj = new Object[dVal.size()][];
        for (int i=0; i<dVal.size() ; i++)
        {
            dataObj[i] = dVal.get(i);
        }
       return dataObj;
    }

    @Test(dataProvider = "dataForCorporatePortalSites", groups = {"regression"})
    public void verifySites(final String [] dataVal) throws InterruptedException {
        final String currentLink;
        final String linkName = dataVal[0];
        final String linkURL = dataVal[1];
        corpPortalPage.clickLinkOnOurSites(linkName);
        currentLink = driver.getCurrentUrl();
        Assert.assertTrue(currentLink.contains(linkURL));
        driver.navigate().back();
    }
    @AfterTest
    public void closeTest()
    {
        driver.close();
    }
}
