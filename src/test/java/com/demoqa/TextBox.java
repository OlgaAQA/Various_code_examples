package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest() {
        open("https://demoqa.com/text-box");

        $("#userName").setValue("ЮзерНейм");
        $("#userEmail").setValue("emain@email.com");
        $("#currentAddress").setValue("Адрес");
        $("#permanentAddress").setValue("Другой Адрес");
        $("#submit").scrollTo().click();

        $("#output").shouldBe(visible);
        $("#name").shouldHave(text("ЮзерНейм"));
        $("#email").shouldHave(text("emain@email.com"));
        $("#output #currentAddress").shouldHave(text("Адрес"));
        $("#output").$("#permanentAddress").shouldHave(text("Другой Адрес"));
    }

}