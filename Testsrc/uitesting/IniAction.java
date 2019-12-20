package uitesting;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utility.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.util.ResourceBundle;

/**
 * Created by pc3 on 11/29/2019.
 */
public class IniAction
{
    protected WebDriver driver= Driver.getDriver(Driver.DriverTypes.FIREFOX);
    protected Login login;
    @BeforeClass
    public void beforemMyClass()
    {
        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");
        String myUrl = rb.getString("url");
        driver.get(myUrl);
        login = new Login(driver);
    }

}
