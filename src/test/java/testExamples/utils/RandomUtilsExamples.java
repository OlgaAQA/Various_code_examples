package testExamples.utils;

import java.util.Random;


public class RandomUtilsExamples {
    public static String getRandomNumberString(int length) {
        String SALTCHARS = "0123456789";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }
}
