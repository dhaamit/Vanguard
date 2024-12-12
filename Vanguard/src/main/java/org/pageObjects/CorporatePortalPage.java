//Author - @Amit Dharmale
package org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CorporatePortalPage {
    WebDriver driver;
    Wait<WebDriver> wait;
    public CorporatePortalPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(2));
    }

    @FindBy(id="ourSites")
    public WebElement ourSitesLink;

    @FindBy(id="navdropdownlist")
    public WebElement ourSitesDropdown;

    public void clickOurSites(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.ourSitesLink));
        this.ourSitesLink.click();
    }
    public void clickLinkOnOurSites(String strLinkText) throws InterruptedException {
        if (!driver.getCurrentUrl().contains("corporate-portal")) {
            driver.navigate().back();
        }
        this.clickOurSites();
        this.wait.until(ExpectedConditions.elementToBeClickable(this.ourSitesDropdown.findElement(By.xpath("//a[contains(text(),'"+strLinkText+"')]"))));
        this.ourSitesDropdown.findElement(By.xpath("//a[contains(text(),'"+strLinkText+"')]")).click();
    }
}
