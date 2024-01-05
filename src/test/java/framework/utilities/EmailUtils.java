package framework.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class EmailUtils {
    public static String generateEmailAddress() {

        String generatedString = RandomStringUtils.randomNumeric(4);
        String email = "carbon_voice" + generatedString + "@gmail.com";
//        Report.info("\n\t*****************************\n\nGenerated Email Address is " + email + "\n\n");

        return email;

    }

    public static String generateName(){
        String name= RandomStringUtils.randomAlphabetic(7);
      //  Report.info("\n\t***************************\n\nGenerated name is "+name+"\n\n" );

        return name;
    }

    public static String generateRandomEmail()
    {
        String generatedstring= RandomStringUtils.randomAlphabetic(6);
        String email=generatedstring +"@yopmail.com";
        return email;
    }


}
