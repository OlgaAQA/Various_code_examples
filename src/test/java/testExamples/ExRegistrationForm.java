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
                .checkCheckBox()
                .uploadFile()
                .checkCurrentAddress("Text address")
                .checkSelect()
                .checkSuccess();

    }
}