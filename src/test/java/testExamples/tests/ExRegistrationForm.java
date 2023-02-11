package testExamples.tests;

import org.junit.jupiter.api.Test;
import testExamples.pages.ExRegistrationPage;
import static io.qameta.allure.Allure.step;
import static testExamples.tests.TestData.*;


public class ExRegistrationForm extends TestBase {
    ExRegistrationPage exRegistrationPage = new ExRegistrationPage();

    @Test
    void successTest() {

        step("Открытие страницы DemoQA", () -> {
            exRegistrationPage.openPage();
        });

        step("Ввод имени и фамилии", () -> {
            exRegistrationPage.typeUserName("Boris", "Godunov");
        });

        step("Ввод рандомного емейла : "+ emailRandom , () -> {
            exRegistrationPage.typeUserEmail(emailRandom);
        });

        step("Проверка радио-баттонов", () -> {
            exRegistrationPage.checkRadio();
        });

        step("Ввод рандомного номера телефона : " + mobileRandomNumber, () -> {
            exRegistrationPage.typeUserMobile(mobileRandomNumber);
        });

        step("Проверка функциональности календаря", () -> {
            exRegistrationPage.checkCalendar();
        });

        step("Ввод даты в календарь", () -> {
            exRegistrationPage.calendar.setDate("30", "July", "1993");
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
        });

        step("Проверка двух селектов выбора страны и региона", () -> {
            exRegistrationPage.checkSelect();
        });

        step("Проверка данных", () -> {
            exRegistrationPage.checkSuccess();
        });

    }
}