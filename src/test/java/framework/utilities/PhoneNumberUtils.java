package framework.utilities;

import java.util.Random;

public class PhoneNumberUtils {

    public static String generatePhoneNumber() {

        Random myRandom = new Random();
        StringBuilder phoneNumber = new StringBuilder(10);

        Random firstTwoDigits = new Random();
        int random = 92 + firstTwoDigits.nextInt(7);

        phoneNumber.append(random);

        for (int counter = 0; counter < 8; counter++) {
            phoneNumber.append(1 + myRandom.nextInt(8));
        }

        return phoneNumber.toString();

    }
}
