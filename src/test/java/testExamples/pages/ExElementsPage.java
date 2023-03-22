package testExamples.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import testExamples.tests.TestBase;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
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
    public ExElementsPage openPage(String url) {
        openPage(url);
        takeScreenshot();
        return this;
    }

    @Step("Проверка наименования страницы")
    public ExElementsPage checkOpenPage(String FORM_TITLE) {
        formTitle.shouldHave(text(FORM_TITLE));
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
}
