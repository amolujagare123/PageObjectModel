package Regretion.Client;

import Regretion.LoginAction;
import com.invoiceplane.pages.Clients.AddClient;
import com.invoiceplane.pages.Menu;
import org.testng.annotations.Test;

import java.text.ParseException;

/**
 * Created by pc3 on 11/8/2019.
 */
public class AddClientTest extends LoginAction
{
/*WebDriver driver= Driver.getDriver(Driver.DriverTypes.CHROME);
    @BeforeClass
    public void LoginTst()
    {
        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");
        String myUrl = rb.getString("url");
        driver.get(myUrl);

        Login login = new Login(driver);
        login.setTstEmail("amolujagare@gmail.com");
        login.setTstPasword("admin123");
        login.clickbtnLogin();

    }*/

    @Test
    public void addClentTst() throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addclient = new AddClient(driver);
        addclient.serClientName("Rani");
        addclient.setTstSurname("Chavan");
        addclient.setTstAddress1("xyz");
        addclient.setTstAddress2("pqr");
        addclient.setTstCity("Pune");
        addclient.setCountry("India");
        addclient.setLanguage("English");
        addclient.setGender("Female");
        addclient.setTstState("Maharastra");
        addclient.setTstZipCode("415003");
        addclient.setTstPhoneNo("703836012");
        addclient.setBirthdate("16/01/2014");
        addclient.setTstMobileNo("703830612");
        addclient.setTstEmail("nilamchavan9599@gmail.com");
        addclient.clicksave();
    }
}
