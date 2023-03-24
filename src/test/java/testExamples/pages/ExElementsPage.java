package testExamples.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import testExamples.tests.TestBase;
import testExamples.utils.RandomUtils;
import java.io.File;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
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
            editName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            current_address = faker.address().fullAddress(),
            permanent_address = faker.address().secondaryAddress();
    Integer randomAge = RandomUtils.getRandomInt(1, 130),
            salary = RandomUtils.getRandomInt(100, 2500);


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
        $(".mb-1", 0).shouldHave(text(firstName));
        $(".mb-1", 0).shouldHave(text(lastName));
        $(".mb-1", 1).shouldHave(text(emailRandom));
        $(".mb-1", 2).shouldHave(text(current_address));
        $(".mb-1", 3).shouldHave(text(permanent_address));
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

    @Step("Сворачивание и разворачивание списка по кнопке")
    public ExElementsPage expandAndCollapse() {
        $(".rct-option-expand-all").click();
        $(".rct-option-collapse-all").click();
        return this;
    }

    @Step("Сворачивание и разворачивание списка по порядку")
    public ExElementsPage expandAndCollapseInOrder() {
        $(".rct-collapse-btn").click();
        $(".rct-node-collapsed .rct-collapse-btn").click();
        $(".rct-node-collapsed .rct-collapse-btn").click();
        $(".rct-node-collapsed .rct-collapse-btn", 2).click();
        return this;
    }

    @Step("Поставить и снять все чекбоксы во всем списке")
    public ExElementsPage checkAndUncheckAllCheckboxesList() {
        $(".rct-checkbox .rct-icon-uncheck").click();
        $(".rct-checkbox .rct-icon-check").click();
        return this;
    }

    @Step("Поставить и снять все чекбоксы в одном разделе")
    public ExElementsPage checkAndUncheckAllCheckboxesSection() {
        $(".rct-checkbox .rct-icon-uncheck", 1).click();
        $(".rct-checkbox .rct-icon-check").click();
        return this;
    }

    @Step("Поставить некоторые чекбоксы и проверка корректности выбора")
    public ExElementsPage checkCheckboxesAndCheck() {
        $(".rct-option-expand-all").click();
        $(".rct-checkbox .rct-icon-uncheck", 3).click();
        $(".text-success").shouldHave(text("commands"));
        $(".rct-checkbox .rct-icon-uncheck", 7).click();
        $(".text-success", 1).shouldHave(text("public"));
        $(".rct-checkbox .rct-icon-uncheck", 8).click();
        $(".text-success", 2).shouldHave(text("downloads"));
        $(".text-success", 3).shouldHave(text("wordFile"));
        $(".text-success", 4).shouldHave(text("excelFile"));
        $(".rct-option-collapse-all").click();
        return this;
    }

    @Step("Ввести данные пользователя в таблицу и проверка результата")
    public ExElementsPage enterUserDataInTheTableAndCheckTheResult() {
        $("#addNewRecordButton").click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(emailRandom);
        $("#age").setValue(String.valueOf(randomAge));
        $("#salary").setValue(String.valueOf(salary));
        $("#department").setValue(current_address);
        $("#submit").click();

        $$(".rt-td").shouldHave(itemWithText(firstName));
        $$(".rt-td").shouldHave(itemWithText(lastName));
        $$(".rt-td").shouldHave(itemWithText(emailRandom));
        $$(".rt-td").shouldHave(itemWithText(String.valueOf(randomAge)));
        $$(".rt-td").shouldHave(itemWithText(String.valueOf(salary)));
        return this;
    }

    @Step("Поиск добавленного пользователя")
    public ExElementsPage userSearch() {
        $("#searchBox").sendKeys(firstName);
        $(".rt-td").shouldHave(text(firstName));
        return this;
    }

    @Step("Редактирование пользователя")
    public ExElementsPage userEditing() {
        $(".mr-2").click();
        $("#firstName").setValue(editName);
        $("#submit").click();
        $("#searchBox").setValue(String.valueOf(editName));
        $(".rt-td").shouldHave(text(editName));
        return this;
    }

    @Step("Удаление пользователя")
    public ExElementsPage userDelete() {
        $("#delete-record-4").click();
        $(".rt-noData").shouldHave(Condition.text("No rows found"));
        return this;
    }
}
