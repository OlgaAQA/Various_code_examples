package memosTestExamples;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CssXpathEx {
    public CssXpathEx() throws FileNotFoundException {
    }

    void cssXpathExamples() {

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]");
        $(by("data-testid", "email"));

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]");
        $("#email");
        $(byId("email"));
        $x("//*[@id='email']");
        $(byXpath("//*[@id='email']"));

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]");
        $(byName("email"));

        // <input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]");
        $(".login_form_input_box");
        $(".inputtext.login_form_input_box");
        $(byClassName("login_form_input_box"));
        $("input.inputtext.login_form_input_box");
        $(byXpath("//input[@class='login_form_input_box']"));

        // <div class="inputtext">
        //      <input type="email" class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box");

        // <div>Hello qa.guru</div>
        $(byText("Hello qa.guru"));
        $(withText("lo qa.gu"));

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("input#email.inputtext.login_form_input_box[data-testid=email]");

    }

    void selectorsExamples() {
        $("div").click();
        element("div").click();

        $("div", 2).click(); //Третий элемент

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click(); //Полное совпадение текста
        $(withText("ull tex")).click(); //Частичное совпадение текста

        $("").parent();
        $("").sibling(1); // "Сосед" по дереву вниз
        $("").preceding(1); // "Сосед" по дереву вверх
        $("").closest("div"); // Ближайший вверх по дереву, у которогот есть такой атрибут
        $("").ancestor("div");
        $("div:last-child");

        // Пример поиска элемента
        $("div").$("h1").find(byText("abc")).click();

        // Опциональные сокращения
        $(byAttribute("abc", "x")).click();
        $("[abc=x]").click();

        $(byId("mytext")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();
    }

    //Пример если название ссылки на странице на файл не уникальна
    File file = $$("a[href*='prajs']")
            .find(text("Текст"))
            .download();

}