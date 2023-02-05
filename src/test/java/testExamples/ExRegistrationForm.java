package testExamples;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ExRegistrationForm extends TestBase {


    @Test
    void successTest() {

        exRegistrationPage.openPage()
                .typeUserName("Boris", "Godunov")
                .typeUserEmail("User@gmail.com")
                .checkRadio()
                .typeUserMobile("0123456789")
                .checkCalendar()
                .checkSab()
                .checkCheckBox();


        // Загрузить файл
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/catrider.jpg"));

        // Проверка текстового поля
        $("#currentAddress").setValue("10101010100010101");

        // Проверка двух селектов
        $("#state").$(byText("Select State")).scrollTo().click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();


        executeJavaScript("$('footer').remove()");

        $("#submit").scrollTo().click();


        // Проверка успешного результата
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Egorov"), text("alex@egorov.com"));

    }

}