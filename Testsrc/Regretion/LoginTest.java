package Regretion;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by pc3 on 11/8/2019.
 */
public class LoginTest
{
    WebDriver driver = Driver.getDriver(Driver.DriverTypes.CHROME);
    @Test
    public void loginTst() throws IOException {
      // System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

       /* ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");
        String myUrl = rb.getString("url");*/


       FileInputStream input = new FileInputStream("C:\\Users\\pc3\\IdeaProjects\\PageObjectModel\\Resorces\\InvoicePlane.properties");
       // FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"\\InvoicePlane.properties");

        Properties prop = new Properties();

        // load a properties file
        prop.load(input);

        String myUrl = prop.getProperty("url");


        driver.get(myUrl);

        Login login = new Login(driver);
        login.setTstEmail("amolujagare@gmail.com");
        login.setTstPasword("admin123");
        login.clickbtnLogin();


    }

}
