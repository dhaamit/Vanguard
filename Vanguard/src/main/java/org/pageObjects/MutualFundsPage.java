package org.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MutualFundsPage {
    WebDriver driver;
    CorporatePortalPage corpPortalPage;
    public MutualFundsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h1[@class='title']")
    WebElement title;

    @FindBy(xpath="//span[@data-rpa-tag-id='symbol']")
    List<WebElement> symbols;

    public String getTitle ()
    {
        return this.title.getText();
    }

    public int getIndexOfSymbol(final String symbol)
    {
        AtomicInteger index = new AtomicInteger();
        this.symbols.stream().forEach(item -> {
                if (item.getText().equals(symbol))
                    index.set(symbols.indexOf(item));
                }
        );
        return index.get();
    }
}
