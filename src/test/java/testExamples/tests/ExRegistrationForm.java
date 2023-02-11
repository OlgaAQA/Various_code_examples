package testExamples.tests;

import org.junit.jupiter.api.Test;
import testExamples.pages.ExRegistrationPage;

import static testExamples.tests.TestData.*;


public class ExRegistrationForm extends TestBase {
    ExRegistrationPage exRegistrationPage = new ExRegistrationPage();

    @Test
    void successTest() {

        exRegistrationPage.openPage()
                .typeUserName("Boris", "Godunov")
                .typeUserEmail(emailRandom)
                .checkRadio()
                .typeUserMobile(mobileRandomNumber)
                .checkCalendar()
                .calendar.setDate("30", "July", "1993");
        exRegistrationPage.checkSab()
                .checkCheckBox()
                .uploadFile()
                .checkCurrentAddress(textAddressRandom)
                .checkSelect()
                .checkSuccess();

    }
}