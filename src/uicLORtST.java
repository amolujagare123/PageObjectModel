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
public class uicLORtST
{
    @Test
    public void tsColor()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost/ip");
        String expected = "#2C8EDD";

        WebElement btnLogin = driver.findElement(By.xpath("//button"));
        String btnColor = btnLogin.getCssValue("background-color");
        System.out.println(btnColor);
        String actual = Color.fromString(btnColor).asHex();
       // System.out.println(hexColor);
    /*    String actual = "#ffffff";
        Assert.assertEquals(actual,expected);*/
        Assert.assertEquals(actual.toUpperCase(),expected);

    }
}
