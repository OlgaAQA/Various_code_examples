package testExamples.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1900x1080";

    }


}
