import freemarker.template.SimpleDate;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pc3 on 11/19/2019.
 */
public class DateSelectionExam
{
    @Test
    public void tstDate() throws ParseException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://jqueryui.com");

        driver.findElement(By.xpath("//a[text()='Datepicker']")).click();

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        driver.findElement(By.id("datepicker")).click();

        String setDateStr = "01/01/2018"; // dd/MM/yyyy

        SimpleDateFormat sdSetDate = new SimpleDateFormat("dd/MM/yyyy");

        Date setDate = sdSetDate.parse(setDateStr);


        String currDateStr = driver.findElement(By.className("ui-datepicker-title")).getText();
        // November 2019 - MMMM yyyy


        SimpleDateFormat currSetDate = new SimpleDateFormat("MMMM yyyy");

        Date currDate = currSetDate.parse(currDateStr);


        int monthsDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();

        boolean isFuture=true;
        if(monthsDiff<0)
        {
            isFuture = false;
            monthsDiff=-1*monthsDiff;
        }

        for (int i=0; i<monthsDiff;i++)
        {

            if(isFuture)
                driver.findElement(By.xpath("//span[text()='Next']")).click(); //next
            else
                driver.findElement(By.xpath("//span[text()='Prev']")).click(); // prev

        }

        SimpleDateFormat sdDay = new SimpleDateFormat("dd");
        String dayStr =   sdDay.format(setDate);
        System.out.println(dayStr);

        int day = Integer.parseInt(dayStr);

        driver.findElement(By.xpath("//a[text()='"+day+"']")).click();

    }
}
