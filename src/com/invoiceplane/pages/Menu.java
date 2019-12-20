package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pc3 on 11/18/2019.
 */
public class Menu
{
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Dashboard']")
    WebElement lnkDashboard;

    @FindBy(xpath = "//span[text()='Clients']")
    WebElement lnkClient;

    @FindBy(xpath = "//a[text()='Add Client']")
    WebElement lnkAddClient;

    @FindBy(xpath = "//a[text()='View Clients']")
    WebElement lnkViewClient;

    @FindBy(xpath = "//span[text()='Quotes']")
    WebElement lnkQuotes;

    @FindBy(xpath = "//a[text()=\"Create Quote\"]")
    WebElement lnkCreateQuotes;

    @FindBy(xpath = "//a[text()='View Quotes']")
    WebElement lnkViewQuotes;

    @FindBy(xpath = "//span[text()='Invoices']")
    WebElement lnkInvoice;

    @FindBy(xpath = "//a[text()='Create Invoice']")
    WebElement lnkCreateInvoice;

    @FindBy(xpath = "//a[text()='View Invoices']")
    WebElement lnkViewInvoice;

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void clickDashboard()
    {
        lnkDashboard.click();
    }

    public void clickAddClient()
    {
        lnkClient.click();
        lnkAddClient.click();
    }
    public void clickViewClient()
    {
        lnkClient.click();
        lnkViewClient.click();
    }
    public void clickCreateQuote()
    {
        lnkQuotes.click();
        lnkCreateQuotes.click();
    }
    public void clickViewQuotes()
    {
        lnkQuotes.click();
        lnkViewQuotes.click();
    }
    public void clickCreateInvoice()
    {
        lnkInvoice.click();
        lnkCreateInvoice.click();
    }
    public void clickViewInvoice()
    {
        lnkInvoice.click();
        lnkViewInvoice.click();
    }


}
