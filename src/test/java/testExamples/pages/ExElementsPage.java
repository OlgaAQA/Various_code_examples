package testExamples.pages;

import com.codeborne.selenide.SelenideElement;
import testExamples.tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ExElementsPage extends TestBase {
    // locators & elements
    public static SelenideElement formTitle = $(".main-header");
    // actions
    public ExElementsPage checkOpenPage(String FORM_TITLE) {
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }
}
