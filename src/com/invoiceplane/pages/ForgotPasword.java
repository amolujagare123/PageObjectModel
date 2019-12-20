package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pc3 on 11/14/2019.
 */
public class ForgotPasword
{
   // WebDriver driver;

    @FindBy(name = "email")
    WebElement tstEmail;

    @FindBy(xpath="//button")
    WebElement btnLogin;

    public ForgotPasword(WebDriver driver)
    {
        //this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void setTstemail(String username)
    {
        tstEmail.sendKeys(username);
    }
    public void clickbtnLogin()
    {
        btnLogin.click();
    }

}
