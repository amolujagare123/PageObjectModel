package Regretion;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utility.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by pc3 on 11/18/2019.
 */
public class LoginAction {

    protected WebDriver driver = Driver.getDriver(Driver.DriverTypes.FIREFOX );

    @BeforeClass
    public void login() throws IOException {
          ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");
            String myUrl = rb.getString("url");
            driver.get(myUrl);

            Login login = new Login(driver);
            login.setTstEmail("amolujagare@gmail.com");
            login.setTstPasword("admin123");
            login.clickbtnLogin();

        }

}
