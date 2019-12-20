package Regretion;

import com.invoiceplane.pages.ForgotPasword;
import com.invoiceplane.pages.Login;
import com.invoiceplane.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by pc3 on 11/14/2019.
 */
public class ForgotPaswordTest
{
    WebDriver driver = Driver.getDriver(Driver.DriverTypes.FIREFOX);
    @Test
    public void ForgotTst()
    {
      //  System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");

        String myUrl = rb.getString("url");

        driver.get(myUrl);
        Login login = new Login(driver);
        login.clickbtnForgot();

        ForgotPasword forgotPasword = new  ForgotPasword(driver);
        forgotPasword.setTstemail("nilamchavan9599@gmail.com");
        forgotPasword.clickbtnLogin();



    }
}
