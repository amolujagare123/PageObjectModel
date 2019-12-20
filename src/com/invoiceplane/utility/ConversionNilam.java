package com.invoiceplane.utility;

import freemarker.template.SimpleDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pc3 on 12/5/2019.
 */
public class ConversionNilam
{
    public static String convertCountry(String country)
    {
        String convertedCountry ="";
        switch (country)
        {
            case "IN":
                 convertedCountry="India";
                break;
            case "CN":
                convertedCountry="China";
                break;
            case "AD":
                convertedCountry="Andorra";
                break;
            case "AF":
                convertedCountry="Afghanistan";
                break;
            case "AL" :
                convertedCountry="Albania";
                break;
            case "DZ" :
                convertedCountry="Algeria";
                break;
            case "AO" :
                convertedCountry="Angola";
                break;
        }
        return convertedCountry;
    }
    public static String convertGender(String gender)
    {
        String convertedGender="";
        switch (gender)
        {
            case "1":
                convertedGender="Female";
                break;
            case "0":
                convertedGender="Male";
                break;
            case "2":
                convertedGender="Other";
                break;

        }
        return convertedGender;
    }
    public static String convertDate(String date) throws ParseException {
        String convertedDate ="";
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date stdate = sd.parse(date);

        SimpleDateFormat sd1 = new SimpleDateFormat("dd/MM/yyyy");
        convertedDate = sd1.format(stdate);

        return convertedDate;


    }

}
