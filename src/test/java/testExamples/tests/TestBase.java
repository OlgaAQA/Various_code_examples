package testExamples.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1900x1080";

    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }



}
