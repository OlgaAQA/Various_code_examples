package testExamples.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Step;
import org.apache.commons.io.IOUtils;
import testExamples.tests.TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.BooleanSupplier;

import static com.codeborne.selenide.Condition.name;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testExamples.tests.TestData.emailRandom;

public class ExElementsPage extends TestBase {


    // locators & elements
    static Faker faker = new Faker();
    public static SelenideElement formTitle = $(".main-header"),
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit");
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            current_address = faker.address().fullAddress(),
            permanent_address = faker.address().secondaryAddress();


    // actions
    @Step("Переход к неоюходимой странице")
    public ExElementsPage openPageExEl(String url) {
        openPage(url);
        takeScreenshot();
        return this;
    }

    @Step("Проверка наименования страницы")
    public ExElementsPage checkOpenPageExEl(String FORM_TITLE) {
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    @Step("Проверка наименования страницы Скачивание и Загрузка файлов")
    public ExElementsPage checkOpenPageExElUploadAndDownload(String FORM_TITLE) {
        $(".example").shouldHave(text(FORM_TITLE));
        return this;
    }

    @Step("Ввод рандомного имя пользователя")
    public ExElementsPage setUserName() {
        userName.setValue(firstName);
        userName.append(" ");
        userName.append(lastName);
        return this;
    }

    @Step("Ввод рандомного емейла")
    public ExElementsPage typeUserEmail() {
        userEmail.setValue(emailRandom);
        return this;
    }

    @Step("Ввод текущего адреса")
    public ExElementsPage typeСurrentAddress() {
        currentAddress.setValue(current_address);
        return this;
    }

    @Step("Ввод постоянного адреса")
    public ExElementsPage typePermanentAddress() {
        permanentAddress.setValue(permanent_address);
        return this;
    }

    @Step("Клик по кнопке Отправить")
    public ExElementsPage clickSubmit() {
        submit.click();
        return this;
    }

    @Step("Проверка Text Box")
    public ExElementsPage checkTextBox() {
       $(".mb-1",0).shouldHave(text(firstName));
        $(".mb-1",0).shouldHave(text(lastName));
        $(".mb-1",1).shouldHave(text(emailRandom));
        $(".mb-1",2).shouldHave(text(current_address));
        $(".mb-1",3).shouldHave(text(permanent_address));
        return this;
    }

    @Step("Двойной клик и проверка")
    public ExElementsPage doubleClick() {
        $("#doubleClickBtn").doubleClick();
        $("#doubleClickMessage").shouldHave(text("You have done a double click"));
        return this;
    }

    @Step("Правый клик и проверка")
    public ExElementsPage rightClick() {
        $("#rightClickBtn").contextClick();
        $("#rightClickMessage").shouldHave(text("You have done a right click"));
        return this;
    }

    @Step("Обычный клик и проверка")
    public ExElementsPage dynamicClick() {
        $(byText("Click Me")).click();
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
        return this;
    }

    @Step("Загрузка файла по относительному пути")
    public ExElementsPage uploadFile() {
        File exampleFile = new File("src/test/resources/img/catrider.jpg");
        $("input[type='file']").uploadFile(exampleFile);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("catrider.jpg"));
        $(".example").shouldHave(text("File Uploaded!"));
        $("#uploaded-files").shouldHave(text("catrider.jpg"));
        return this;
    }

    @Step("Скачивание файла")
    public ExElementsPage downloadFile() {
       $("#downloadButton").click();
        return this;
    }
}
