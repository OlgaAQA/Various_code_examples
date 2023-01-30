package testExamples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ExRegistrationForm {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1900x1080";
    }


    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");


        //Ввести нейм и ласт нейм
        $("[id=firstName]").setValue("Name");
        $("[id=lastName]").setValue("Last Name");

        //Ввести мыло
        $("[id=userEmail]").setValue("email@gmail.com");

        //Проверка чекбоксов
        $(".custom-radio",0).click();
        $(".custom-radio",1).click();
        $(".custom-radio",2).click();

        //Ввести мобильный
        $("[id=userNumber]").setValue("0123456789");

        //Проверка календаря
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("September")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1997")).click();
        $(".react-datepicker__navigation--next").click();
        $(".react-datepicker__day",0).click();

        //Проверка пердметов
        $("#subjectsInput").setValue("p");
        $(".subjects-auto-complete__option").click();
        $("#subjectsInput").setValue("p");
        $(".subjects-auto-complete__option").click();
        $(".subjects-auto-complete__multi-value__remove").click();

        //Проверка чек боксы
        $(".custom-checkbox",0).click();
        $(".custom-checkbox",1).click();
        $(".custom-checkbox",2).click();

        // Загрузить файл
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/catrider.jpg"));

        // Проверка текстового поля
        $("#currentAddress").setValue("10101010100010101");

        // Проверка двух селектов
        $("#state").$(byText("Select State")).scrollTo().click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        // подтвердить
        $("#submit").scrollTo().click();
        // Проверка успешного результата
    }

}