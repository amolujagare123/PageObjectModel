import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by pc3 on 12/2/2019.
 */
public class DataProviderExam
{
    @Test(dataProvider = "getData")
    public void tstLogin(String username, String pasword)
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://stock.scriptinglogic.net/");
        driver.manage().window().maximize();
        WebElement tstUserName1 = driver.findElement(By.name("username"));
        tstUserName1.sendKeys(username);
        WebElement tstPasword1 = driver.findElement(By.id("login-password"));
        tstPasword1.sendKeys(pasword);
        WebElement tstBtn1 = driver.findElement(By.name("submit"));
        tstBtn1.click();
    }

    @DataProvider
    public Object[][] getData() throws IOException
    {

        FileInputStream fp = new FileInputStream("data/DataProv1.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(fp);

        HSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();


        Object[][] data = new Object[rowCount][2];

        for (int i = 0; i < rowCount; i++)
        {

            HSSFRow row = sheet.getRow(i);

            HSSFCell username = row.getCell(0);
            data[i][0] = username.getStringCellValue();


            HSSFCell pass = row.getCell(1);
            data[i][1] = pass.getStringCellValue();


        }
        return data;

    }
}
