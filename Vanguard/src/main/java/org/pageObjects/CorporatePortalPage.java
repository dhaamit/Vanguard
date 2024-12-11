package org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CorporatePortalPage {
    WebDriver driver;
    public CorporatePortalPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="ourSites")
    public WebElement ourSitesLink;

    @FindBy(id="navdropdownlist")
    public WebElement ourSitesDropdown;

    public void clickOurSites(){
        this.ourSitesLink.click();
    }
    public void clickLinkOnOurSites(String strLinkText) {
        this.clickOurSites();
        this.ourSitesDropdown.findElement(By.linkText(strLinkText)).click();
    }
}
