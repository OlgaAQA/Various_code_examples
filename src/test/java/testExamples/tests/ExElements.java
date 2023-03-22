package testExamples.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import testExamples.pages.ExElementsPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;


public class ExElements extends TestBase {
    // Степы внутри пейджи

    ExElementsPage exElementsPage = new ExElementsPage();

    @Test
    void testBox() {

        exElementsPage.openPageExEl("https://demoqa.com/text-box")
                .checkOpenPageExEl("Text Box")
                .setUserName()
                .typeUserEmail()
                .typeСurrentAddress()
                .typePermanentAddress()
                .clickSubmit()
                .checkTextBox();

    }

    @Test
    void checkBox() {

        step("Открытие страницы Check Box", () -> {
            openPage("https://demoqa.com/checkbox");
            exElementsPage.checkOpenPageExEl("Check Box");
            takeScreenshot();


        });

    }


    @Test
    void webTables() {

        step("Открытие страницы Web Tables", () -> {
            openPage("https://demoqa.com/webtables");
            exElementsPage.checkOpenPageExEl("Web Tables");
            takeScreenshot();


        });

    }

    @Test
    void clickButton() {


            exElementsPage.openPageExEl("https://demoqa.com/buttons")
        .checkOpenPageExEl("Buttons");
$("#doubleClickBtn").doubleClick();
$("#doubleClickMessage").shouldHave(text("You have done a double click"));



    }

    @Test
    void uploadAndDownload() {

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
