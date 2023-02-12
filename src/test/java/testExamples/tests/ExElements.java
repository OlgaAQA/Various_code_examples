package testExamples.tests;

import org.junit.jupiter.api.Test;
import testExamples.pages.ExElementsPage;
import static io.qameta.allure.Allure.step;

public class ExElements extends TestBase {
ExElementsPage exElementsPage = new ExElementsPage();

    @Test
    void testBox() {

        step("Открытие страницы Text Box", () -> {
   openPage("https://demoqa.com/text-box");
 exElementsPage.checkOpenPage("Text Box");
 takeScreenshot();


        });

    }

    @Test
    void checkBox() {

        step("Открытие страницы Check Box", () -> {
        openPage("https://demoqa.com/checkbox");
        exElementsPage.checkOpenPage("Check Box");
        takeScreenshot();


        });

    }

    @Test
    void radioButton() {

        step("Открытие страницы Radio Button", () -> {
        openPage("https://demoqa.com/radio-button");
        exElementsPage.checkOpenPage("Radio Button");
        takeScreenshot();


        });

    }

    @Test
    void webTables() {

        step("Открытие страницы Web Tables", () -> {
        openPage("https://demoqa.com/webtables");
        exElementsPage.checkOpenPage("Web Tables");
        takeScreenshot();


        });

    }

    @Test
    void clickButton() {

        step("Открытие страницы Buttons", () -> {
        openPage("https://demoqa.com/buttons");
        exElementsPage.checkOpenPage("Buttons");
        takeScreenshot();


        });

    }

    @Test
    void uploadAndDownload() {

        step("Открытие страницы Upload and Download", () -> {
        openPage("https://demoqa.com/upload-download");
        exElementsPage.checkOpenPage("Upload and Download");
        takeScreenshot();


    });

    }


}
