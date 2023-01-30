package MemosTestExamples;


import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class AAAtestsExamples {

    @Test
    void shouldFindSelenideRepositoryInGithub() {
        // открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        // check: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));

        webdriver().shouldHave(url("saf"));

        //ARRANGE (optional)
        //ACT
        //ASSERT
    }

    @Test
    void searchGoogle() {
        open("https://www.google.com/");
        $("[name=q]").setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

}