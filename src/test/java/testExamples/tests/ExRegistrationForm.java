package testExamples.tests;

import org.junit.jupiter.api.Test;
import testExamples.pages.components.CalendarComponent;

public class ExRegistrationForm extends TestBase {


    @Test
    void successTest() {

        exRegistrationPage.openPage()
                .typeUserName("Boris", "Godunov")
                .typeUserEmail("User@gmail.com")
                .checkRadio()
                .typeUserMobile("0123456789")
                .checkCalendar()
                .calendar.setDate("30", "July", "1993");
        exRegistrationPage.checkSab()
                .checkCheckBox()
                .uploadFile()
                .checkCurrentAddress("Text address")
                .checkSelect()
                .checkSuccess();

    }
}