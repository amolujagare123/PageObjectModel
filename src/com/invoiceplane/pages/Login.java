package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pc3 on 11/8/2019.
 */
public class Login
{
  WebDriver driver;

  @FindBy(name="email")
  public WebElement txtEmail;

  @FindBy(name="password")
  public WebElement txtPasword;

  @FindBy(xpath="//button")
 public WebElement btnLogin;
    @FindBy(xpath="//a")
    WebElement btnForgot;

    @FindBy(xpath = "//label[@for='email']")
    public WebElement txtLebelEmail;

    @FindBy(xpath = "//label[@for='password']")
   public WebElement txtLabelPass;


  public Login(WebDriver driver)
  {
  // this.driver= driver;
    PageFactory.initElements(driver, this);
 }
  public void setTstEmail(String username)
  {
    txtEmail.sendKeys(username);
  }
  public void setTstPasword(String pasword)
  {
    txtPasword.sendKeys(pasword);
  }
  public void clickbtnLogin()
  {
    btnLogin.click();
  }
    public void clickbtnForgot()
    {
        btnForgot.click();
    }
    public String getLabelEmailText()
    {
        return txtLebelEmail.getText();
    }
    public String getlabelPass()
    {
        return  txtLabelPass.getText();

    }


}
