package testExamples.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import testExamples.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ExElementsPage extends TestBase {

    // locators & elements
    static Faker faker = new Faker();
    public static SelenideElement formTitle = $(".main-header"),
            userName = $("#userName"),
            userEmail = $("#userEmail");
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName();

    // actions
    @Step("Переход к неоюходимой странице")
    public ExElementsPage openPageTextBox(String url) {
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
    public ExElementsPage typeUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }


}
