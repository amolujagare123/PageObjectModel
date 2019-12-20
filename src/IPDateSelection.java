import freemarker.template.SimpleDate;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;

/**
 * Created by pc3 on 11/20/2019.
 */
public class IPDateSelection
{
    @Test
    public void tstDateSel() throws ParseException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/ip");
        driver.manage().window().maximize();

        WebElement tstLUsername = driver.findElement(By.name("email"));
        tstLUsername.sendKeys("amolujagare@gmail.com");
        WebElement tstPasword = driver.findElement(By.name("password"));
        tstPasword.sendKeys("admin123");
        WebElement tstBtn = driver.findElement(By.xpath("//button"));
        tstBtn.click();
        driver.findElement(By.xpath("//span[text()='Clients']")).click();
        driver.findElement(By.xpath("//span[text()='Add Client']")).click();
        driver.findElement(By.name("client_birthdate")).click();

        String setDateStr = "16/01/1992";
        SimpleDateFormat sdSetDate = new SimpleDateFormat("dd/MM/yyyy");
        Date setDate = sdSetDate.parse(setDateStr);

        String setDateCur = driver.findElement(By.className("datepicker-switch")).getText();
        SimpleDateFormat curSetDate = new SimpleDateFormat("MMMM yyyy");
        Date currDate= curSetDate.parse(setDateCur);

        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture= true;
        if(monthDiff<0)
        {
            isFuture= false;
            monthDiff=-1*monthDiff;

        }
        for (int i=0; i<monthDiff; i++)
        {
            if(isFuture)
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")).click();
            else
                driver.findElement(By.className("prev")).click();
        }
        SimpleDateFormat sdDay = new SimpleDateFormat("dd");
        String dayStr = sdDay.format(setDate);
        //int day = Integer.parseInt(dayStr);

        driver.findElement(By.xpath("//td[text()='"+dayStr+"']")).click();







    }
}
