package testExamples.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import testExamples.pages.ExElementsPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static testExamples.tests.TestData.emailRandom;

public class ExElements extends TestBase {
    ExElementsPage exElementsPage = new ExElementsPage();

    @Test
    void testBox() {


        exElementsPage.openPageTextBox("https://demoqa.com/text-box")
                .checkOpenPage("Text Box")
                .setUserName()
                .typeUserEmail(emailRandom);
        //Заполнения первый адрес
        $("#currentAddress").setValue("FUUUU");
        //Заполнение второй адрес
        $("#permanentAddress").setValue("FUUUU");
        // Спбмит
        $("#submit").click();
        //Проверка


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

//        step("Открытие страницы Upload and Download", () -> {
//        openPage("https://demoqa.com/upload-download");
//        exElementsPage.checkOpenPage("Upload and Download");
//        takeScreenshot();
//        });

        step("Открытие страницы Upload the-internet.herokuapp.com", () -> {
            openPage("https://the-internet.herokuapp.com/upload");
            $(".example").shouldHave(text("File Uploader"));
            takeScreenshot();
        });

        step("Загрузка файла по относительному пути", () -> {
            File exampleFile = new File("src/test/resources/img/catrider.jpg");
            $("input[type='file']").uploadFile(exampleFile);
            $("#file-submit").click();
            $("#uploaded-files").shouldHave(text("catrider.jpg"));

        });

    }


}
