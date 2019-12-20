package uitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pc3 on 11/29/2019.
 */
public class LoginTest extends IniAction
{
    @Test
      public void checktstEmailVisibility()
{
    boolean expected = true;
    boolean actual = false;
    try {
        actual = login.txtEmail.isDisplayed();
    }
    catch (Exception e)
    {

    }
    Assert.assertEquals(actual,expected,"element is not there");

}
    @Test
    public void checktstPassVisibility()
    {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtPasword.isDisplayed();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"element is not there");

    }
    @Test
    public void checktstBtnVisibility()
    {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.btnLogin.isDisplayed();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"element is not there");

    }
    @Test
    public void checktstEmailEnable()
    {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtEmail.isEnabled();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"element is not there");

    }
    @Test
    public void checktstPassEnable()
    {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtPasword.isEnabled();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"element is not there");

    }
    @Test
    public void checktstBtnEnable()
    {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.btnLogin.isEnabled();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"element is not there");

    }
    @Test
    public void checktxtLabelEmail()
    {
        String expected = "Email";
        String actual ="";
        try {
            actual = login.getlabelPass();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"element of label is not there");

    }
    @Test
    public void checktxtWaterMarkEmail()
    {
        String expected = "email";
        String actual ="";
        try {
            actual = login.txtEmail.getAttribute("placeholder");
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"place holder is not there");

    }
    @Test
    public void checktxtLabelPass()
    {
        String expected = "Pasword";
        String actual ="";
        try {
            actual = login.txtLabelPass.getText();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"element of label is not there");

    }
    @Test
    public void checktxtWaterMarkPass()
    {
        String expected = "Password";
        String actual ="";
        try {
            actual = login.txtPasword.getAttribute("placeholder");
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"element of label is not there");

    }
}
