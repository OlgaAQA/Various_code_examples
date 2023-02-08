package testExamples.tests;

import com.github.javafaker.Faker;

import static testExamples.utils.RandomUtils.getRandomEmail;
import static testExamples.utils.RandomUtils.getRandomNumberString;

public class TestData {
    static Faker faker = new Faker();
    public static String email = getRandomEmail();
    public static String textAddress = faker.address().streetAddress();
    public static String mobileRandomNumber = getRandomNumberString(10);
}
