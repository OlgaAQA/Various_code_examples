package testExamples.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExRegistrationPage {
    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement formTitle = $(".practice-form-wrapper");

    // actions
    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeUserName(String name, String last_name) {
        $("[id=firstName]").setValue(name);
        $("[id=lastName]").setValue(last_name);
    }
}
