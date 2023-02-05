package testExamples.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExRegistrationPage {
    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement formTitle = $(".practice-form-wrapper"),
            firstName = $("[id=firstName]"),
            lastName = $("[id=lastName]"),
            userEmail = $("[id=userEmail]"),
            radioMale = $(".custom-radio", 0),
            radioFemale = $(".custom-radio", 1),
            radioOther = $(".custom-radio", 2),
            userMobile = $("[id=userNumber]"),
            checkBoxSports = $(".custom-checkbox", 0),
            checkBoxReading = $(".custom-checkbox", 1),
            checkBoxMusic = $(".custom-checkbox", 2);


    // actions
    public ExRegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public ExRegistrationPage typeUserName(String name, String last_name) {
        firstName.setValue(name);
        lastName.setValue(last_name);
        return this;
    }

    public ExRegistrationPage typeUserEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public ExRegistrationPage checkRadio() {
        radioMale.click();
        radioFemale.click();
        radioOther.click();
        return this;
    }

    public ExRegistrationPage typeUserMobile(String mobile) {
        userMobile.setValue(mobile);
        return this;
    }

    public ExRegistrationPage checkCalendar() {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("September")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1997")).click();
        $(".react-datepicker__navigation--next").click();
        $(".react-datepicker__day", 0).click();
        return this;
    }

    public ExRegistrationPage checkSab() {
        $("#subjectsInput").setValue("p");
        $(".subjects-auto-complete__option").click();
        $("#subjectsInput").setValue("p");
        $(".subjects-auto-complete__option").click();
        $(".subjects-auto-complete__multi-value__remove").click();
        return this;
    }

    public ExRegistrationPage checkCheckBox() {
        checkBoxSports.click();
        checkBoxReading.click();
        checkBoxMusic.click();
        return this;
    }

}
