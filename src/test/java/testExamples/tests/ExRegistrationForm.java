package testExamples.tests;

import org.junit.jupiter.api.Test;
import testExamples.pages.ExRegistrationPage;
import static io.qameta.allure.Allure.step;
import static testExamples.tests.TestData.*;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;



public class ExRegistrationForm extends TestBase {
    ExRegistrationPage exRegistrationPage = new ExRegistrationPage();


    @Test
    void successTest() {

        step("Открытие страницы DemoQA", () -> {
            exRegistrationPage.openPage();
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