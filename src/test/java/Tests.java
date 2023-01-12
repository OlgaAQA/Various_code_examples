import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Tests {

    @Test
    void searchGoogle() {
        open("https://www.google.com/");
        $("[name=q]").setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }

    

}
