package com.invoiceplane.pages.Clients;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pc3 on 11/7/2019.
 */
public class AddClient
{
    WebDriver driver;
    @FindBy(name="client_name")
    WebElement tstClientName;
    @FindBy(name="client_surname")
    WebElement tstSurname;
    @FindBy(name="client_address_1")
    WebElement tstAddress1;
    @FindBy(name="client_address_2" )
    WebElement tstAddress2;
    @FindBy(name="client_city")
    WebElement tstCity;
    @FindBy(name="client_state")
    WebElement tstState;
    @FindBy(name="client_zip")
    WebElement tstZipCode;
    @FindBy(name="client_phone")
    WebElement tstPhoneNo;
    @FindBy(name="client_mobile")
    WebElement tstMobileNo;
    @FindBy(name="client_email")
    WebElement tstEmail;
    @FindBy(name="btn_submit")
    WebElement clickSave;

    @FindBy (id="select2-client_country-container")
    WebElement containerCountry;
    @FindBy(id="select2-client_language-container" )
    WebElement containerLanguage;
    @FindBy(id="select2-client_gender-container")
    WebElement containeGender;
    @FindBy(id="client_birthdate")
    WebElement clickBirthdate;

    @FindBy (xpath ="//input[@type='search']")
    WebElement txtSearch;




    public AddClient(WebDriver driver)
    {
         this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void setCountry(String country)
    {
        if(!country.equals("")) {
            containerCountry.click();
            txtSearch.sendKeys(country);
            driver.findElement(By.xpath("//li[text()='" + country + "']")).click();
        }
    }
    public void setLanguage(String language)
    {
        containerLanguage.click();



        txtSearch.sendKeys(language);




        driver.findElement(By.xpath("//li[normalize-space()='"+language+"']" )).click();
    }
    public  void setGender(String gender)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");

        containeGender.click();
       /* JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", containeGender);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value='"+gender+"';", txtSearch);*/
        txtSearch.sendKeys(gender);
        driver.findElement(By.xpath("//li[normalize-space()='"+gender+"']")).click();
    }
    public void setBirthdate(String setDateStr) throws ParseException
    {
        if(!setDateStr.equals("")) {


            clickBirthdate.click();

            //  String setDateStr = "16/01/1992";
            SimpleDateFormat sdSetDate = new SimpleDateFormat("dd/MM/yyyy");
            Date setDate = sdSetDate.parse(setDateStr);

            String setDateCur = driver.findElement(By.className("datepicker-switch")).getText();
            SimpleDateFormat curSetDate = new SimpleDateFormat("MMMM yyyy");
            Date currDate = curSetDate.parse(setDateCur);

            int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
            boolean isFuture = true;
            if (monthDiff < 0) {
                isFuture = false;
                monthDiff = -1 * monthDiff;

            }
            for (int i = 0; i < monthDiff; i++) {
                if (isFuture)
                    driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")).click();
                else
                    driver.findElement(By.className("prev")).click();
            }
            SimpleDateFormat sdDay = new SimpleDateFormat("dd");
            String dayStr = sdDay.format(setDate);
            int day = Integer.parseInt(dayStr);

            driver.findElement(By.xpath("//td[text()='" + day + "']")).click();
        }

    }

    public void serClientName(String clientname)
    {
        tstClientName.sendKeys(clientname);
    }
    public void setTstSurname(String surname)
    {
        tstSurname.sendKeys(surname);
    }
    public void setTstAddress1(String address1)
    {
        tstAddress1.sendKeys(address1);
    }
    public void setTstAddress2(String address2)
    {
        tstAddress2.sendKeys(address2);
    }
    public void setTstCity(String city)
    {
        tstCity.sendKeys(city);
    }
    public void setTstState(String state)
    {
        tstState.sendKeys(state);
    }
    public void setTstZipCode(String zipCode)
    {
        tstZipCode.sendKeys(zipCode);
    }
    public void setTstPhoneNo(String phoneNo)
    {
        tstPhoneNo.sendKeys(phoneNo);
    }
    public void setTstMobileNo(String mobileNo)
    {
        tstMobileNo.sendKeys(mobileNo);
    }
    public void setTstEmail(String email)
    {
        tstEmail.sendKeys(email);
    }
    public void clicksave()
    {
        clickSave.click();

    }

}
