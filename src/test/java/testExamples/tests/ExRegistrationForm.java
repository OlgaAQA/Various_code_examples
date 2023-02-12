package testExamples.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testExamples.pages.ExRegistrationPage;
import static io.qameta.allure.Allure.step;
import static testExamples.tests.TestData.*;

public class ExRegistrationForm extends TestBase {

    ExRegistrationPage exRegistrationPage = new ExRegistrationPage();

    @Test
    @DisplayName("Пример теста | Регистрация студента | DemoQa")
    @Feature("Регистрация")
    @Story("Успешная регистрация")
    @Owner("OlgaQA")
    @Link(name = "DemoQA", url = "https://demoqa.com/automation-practice-form")
    void successTest() {

        step("Открытие страницы DemoQA", () -> {
            openPage("https://demoqa.com/automation-practice-form");
            exRegistrationPage.checkOpenPage();
            takeScreenshot();
        });

        step("Ввод имени и фамилии", () -> {
            exRegistrationPage.typeUserName("Boris", "Godunov");
        });

        step("Ввод рандомного емейла : "+ emailRandom , () -> {
            exRegistrationPage.typeUserEmail(emailRandom);
            takeScreenshot();
        });

        step("Проверка радио-баттонов", () -> {
            exRegistrationPage.checkRadio();
        });

        step("Ввод рандомного номера телефона : " + mobileRandomNumber, () -> {
            exRegistrationPage.typeUserMobile(mobileRandomNumber);
            takeScreenshot();
        });

        step("Проверка функциональности календаря", () -> {
            exRegistrationPage.checkCalendar();
            takeScreenshot();
        });

        step("Ввод даты в календарь", () -> {
            exRegistrationPage.calendar.setDate("30", "July", "1993");
            takeScreenshot();
        });

        step("Проверка добавления предметов", () -> {
            exRegistrationPage.checkSab();
        });

        step("Проверка чек-боксов", () -> {
            exRegistrationPage.checkCheckBox();
        });

        step("Загрузка файла", () -> {
            exRegistrationPage.uploadFile();
        });

        step("Ввод рандомного адреса : " + textAddressRandom, () -> {
            exRegistrationPage.checkCurrentAddress(textAddressRandom);
            takeScreenshot();
        });

        step("Проверка двух селектов выбора страны и региона", () -> {
            exRegistrationPage.checkSelect();
        });

        step("Проверка данных", () -> {
            exRegistrationPage.checkSuccess();
            takeScreenshot();
        });

    }
}