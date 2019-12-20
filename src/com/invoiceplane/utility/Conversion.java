package com.invoiceplane.utility;

/**
 * Created by pc3 on 12/4/2019.
 */
public class Conversion {

    public static String convertCountry(String country)
    {
        String convertedCountry ="";


        switch (country)
        {
            case "IN" : convertedCountry="India"; break;
            case "AD" : convertedCountry="Andorra"; break;
            case "AF" : convertedCountry="Afghanistan"; break;
            case "AL" : convertedCountry="Albania"; break;
            case "DZ" : convertedCountry="Algeria"; break;
            case "AO" : convertedCountry="Angola"; break;
            case "AU" : convertedCountry="Australia"; break;
            case "BD" : convertedCountry="Bangladesh"; break;
            case "BB" : convertedCountry="Barbados"; break;
            case "BR" : convertedCountry="Brazil"; break;



        }

        return convertedCountry;


    }

    public static String convertGender(String Gender)
    {
        String convertedGender="";

        switch(Gender)
        {
            case "1" : convertedGender="Female"; break;
            case "0" : convertedGender="Male"; break;

        }
        return convertedGender;
    }

}
