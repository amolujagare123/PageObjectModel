package databasetesting.Client;

import Regretion.LoginAction;
import com.invoiceplane.pages.Clients.AddClient;
import com.invoiceplane.pages.Menu;
import com.invoiceplane.utility.ConversionNilam;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static com.invoiceplane.utility.ConversionNilam.convertCountry;
import static com.invoiceplane.utility.ConversionNilam.convertDate;
import static com.invoiceplane.utility.ConversionNilam.convertGender;

/**
 * Created by pc3 on 11/28/2019.
 */
public class AddClientTest extends LoginAction {

    @Test(dataProvider = "getData")
    public void addClentTst(String ClientName, String ClientSurname, String Address1, String Address2, String City, String Country, String Language, String Gender, String State, String ZipCode, String PhoneNo, String Birthdate, String MobileNo, String Email) throws ParseException, ClassNotFoundException, SQLException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addclient = new AddClient(driver);
        addclient.serClientName(ClientName);
        addclient.setTstSurname(ClientSurname);
        addclient.setTstAddress1(Address1);
        addclient.setTstAddress2(Address2);
        addclient.setTstCity(City);
        addclient.setCountry(Country);
        addclient.setLanguage(Language);
        addclient.setGender(Gender);
        addclient.setTstState(State);
        addclient.setTstZipCode(ZipCode);
        addclient.setTstPhoneNo(PhoneNo);
        addclient.setBirthdate(Birthdate);
        addclient.setTstMobileNo(MobileNo);
        addclient.setTstEmail(Email);
        addclient.clicksave();

        ArrayList <String> expected = new ArrayList<>();
        expected.add(ClientName);
        expected.add(ClientSurname);
        expected.add(Address1);
        expected.add(Address2);
        expected.add(City);
        expected.add(Country);
        expected.add(Language.toLowerCase());
        expected.add(Gender);
        expected.add(State);
        expected.add(ZipCode);
        expected.add(PhoneNo);
        expected.add(Birthdate);
        expected.add(MobileNo);
        expected.add(Email);


        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/ip";

        String user = "root";
        String password ="root";

        Connection con = DriverManager.getConnection(url, user,password);

        Statement st=con.createStatement();

        String sql ="select * from ip_clients where client_name='"+ClientName+"'";
        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while(rs.next())
        {


            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));

            String shortCountryFromDatabase = rs.getString("client_country"); // in short form

            String contryConverted = convertCountry(shortCountryFromDatabase); // full form country


            actual.add(contryConverted); // full form country


            actual.add(rs.getString("client_language"));

            String genderFromDatabase = rs.getString("client_gender");
            String genderConverted = convertGender(genderFromDatabase);
            actual.add(genderConverted);

            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));
            actual.add(rs.getString("client_phone"));

            String dateFromDatabase = rs.getString("client_birthdate");
            String dateconverted = convertDate(dateFromDatabase);
            actual.add(dateconverted);


            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));

        }
       Assert.assertEquals(actual,expected);

    }

    @DataProvider
    public   Object[][] getData() throws IOException
    {

        FileInputStream fp = new FileInputStream("data/DataProv.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fp);

        XSSFSheet sheet = workbook.getSheet("Sheet3");

        int rowCount = sheet.getPhysicalNumberOfRows();


        Object[][] data = new Object[rowCount-1][14];

        for (int i = 0; i < rowCount-1; i++)
        {

            XSSFRow row = sheet.getRow(i + 1);


            for (int j = 0; j < 14; j++) {
                XSSFCell cell =row.getCell(i);
                if(cell == null)
                    data[i][j]="";
                else {

                    cell.setCellType(CellType.STRING);
                    data[i][j] = cell.getStringCellValue();
                }
            }

           /*
            XSSFCell clientName = row.getCell(0);
            if(clientName == null)
                data[i][0]="";
            else {

                clientName.setCellType(CellType.STRING);
                data[i][0] = clientName.getStringCellValue();
            }

            XSSFCell clientSurnam = row.getCell(1);
            if (clientSurnam==null)
                data[i][1]="";
            else {

                clientSurnam.setCellType(CellType.STRING);
                data[i][1] = clientSurnam.getStringCellValue();
            }

            XSSFCell address1 = row.getCell(2);
            if (address1==null)
                data[i][2]="";
            else {
                address1.setCellType(CellType.STRING);
                data[i][2] = address1.getStringCellValue();
            }

            XSSFCell address2 = row.getCell(3);
            if(address2==null)
                data[i][3]="";
            else {
                address2.setCellType(CellType.STRING);
                data[i][3] = address2.getStringCellValue();
            }

            XSSFCell city = row.getCell(4);
            if(city==null)
                data[i][4]="";
            else {
                city.setCellType(CellType.STRING);
                data[i][4] = city.getStringCellValue();
            }

            XSSFCell country = row.getCell(5);
            if(country==null)
                data[i][5]="";
            else {
                country.setCellType(CellType.STRING);
                data[i][5] = country.getStringCellValue();
            }

            XSSFCell language = row.getCell(6);
            if(language==null)
                data[i][6]="";
            else {
                language.setCellType(CellType.STRING);
                data[i][6] = language.getStringCellValue();
            }
            XSSFCell gender = row.getCell(7);
            if(gender==null)
                data[i][7]="";
            else {
                gender.setCellType(CellType.STRING);
                data[i][7] = gender.getStringCellValue();
            }
            XSSFCell state = row.getCell(8);
            if(state==null)
                data[i][8]="";
            else {
                state.setCellType(CellType.STRING);
                data[i][8] = state.getStringCellValue();
            }
            XSSFCell zipCode = row.getCell(9);
            if(zipCode==null)
                data[i][9]="";
            else {
                zipCode.setCellType(CellType.STRING);
                data[i][9] = zipCode.getStringCellValue();
            }
            XSSFCell phoneNo = row.getCell(10);
            if(phoneNo==null)
                data[i][10]="";
            else {
                phoneNo.setCellType(CellType.STRING);
                data[i][10] = phoneNo.getStringCellValue();
            }
            XSSFCell birthdate = row.getCell(11);
            if(birthdate==null)
                data[i][11]="";
            else {
                birthdate.setCellType(CellType.STRING);
                data[i][11] = birthdate.getStringCellValue();
            }
            XSSFCell mobileNo = row.getCell(12);
            if(mobileNo==null)
                data[i][12]="";
            else {
                mobileNo.setCellType(CellType.STRING);
                data[i][12] = mobileNo.getStringCellValue();
            }
            XSSFCell email = row.getCell(13);
            if(email==null)
                data[i][13]="";
            else {
                email.setCellType(CellType.STRING);
                data[i][13] = email.getStringCellValue();
            }*/

        }
        return data;
    }

}
