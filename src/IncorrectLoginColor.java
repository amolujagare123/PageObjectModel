import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pc3 on 12/4/2019.
 */
public class IncorrectLoginColor
{
    @Test
    public void tstColot()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("http://localhost/ip");

        WebElement userName= driver.findElement(By.name("email"));
        userName.sendKeys("nilamchavan@gmail.com");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin");
        WebElement btnLogin = driver.findElement(By.xpath("//button"));
        btnLogin.click();

        String expected = "#f2dede";
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        String btnColor = errorMsg.getCssValue("background-color");
        System.out.println(btnColor);
        String actual = Color.fromString(btnColor).asHex();
        Assert.assertEquals(actual,expected);


    }
}
