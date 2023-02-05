package testExamples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import testExamples.pages.ExRegistrationPage;

public class TestBase {

    ExRegistrationPage exRegistrationPage = new ExRegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1900x1080";

    }


}
