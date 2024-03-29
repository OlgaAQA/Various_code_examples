package memosTestExamples;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.*;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.Keys;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Это не полный список, - это примеры
public class CommandEx {

    void browserCommandExamples() {

        open("https://google.com");
        open("/customer/orders");
        open("/", AuthenticationType.BASIC, "user", "password");

        Selenide.back();
        Selenide.refresh();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        Selenide.confirm(); // Подтверждение в стндартных окнах браузера (диалоговые окна предупреждений)
        Selenide.dismiss(); // Отмена

        Selenide.closeWindow(); // Закрыть активную табу
        Selenide.closeWebDriver(); // Закрыть все активные табы

        Selenide.switchTo().frame("new"); // Для фреймов
        Selenide.switchTo().defaultContent();

        Selenide.switchTo().window("The Internet"); // Перейти по имени окна

        executeJavaScript("$('footer').remove()"); // Убираем банеры на сайте
    }

    void actionsExamples() {
        $("").click();
        $("").doubleClick();
        $("").contextClick(); //Правый клик

        $("").hover();
        $("").scrollIntoView(true); //Скролл
        $("").scrollTo().click();

        $("").setValue("text"); // Очищает поле и вписывает текст
        $("").append("text");  // Не очищает поле и дополняет текст
        $("").clear();
        $("").setValue(""); // Если не работает clear

        $("").selectOption("text"); // Выбор значения из простого селекта выбора


        $("div").sendKeys("c"); // горячие клавиши внутри элемента
        actions().sendKeys("c").perform(); // горячие клавиши вне элемента
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // Ctrl + F
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();


        // Пример как захватить и сдвинуть подвижный элемент
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        // Для старых дропдаунов и радио
        $("").selectOption("dropdown_option");
        $("").selectRadio("radio_options");

    }

    void assertionsExamples() {
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("abc"));
        $("").shouldNotHave(text("abc"));
        $("").should(appear);
        $("").shouldNot(appear);


        // Примеры проверки по времени
        $("").shouldBe(visible, Duration.ofSeconds(30));


    }

    void conditionsExamples() {
        $("").shouldBe(visible);
        $("").shouldBe(hidden); // Противотоложность визибл

        // Примеры проверок по тексту
        $("").shouldHave(text("abc"));
        $("").shouldHave(exactText("abc"));
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").should(matchText("[0-9]abc$"));

        // Приммеры проверок по сселектору
        $("").shouldHave(cssClass("red"));
        $("").shouldHave(cssValue("font-size", "12"));

        // Примеры проверок по велью
        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        // Примеры проверок по атрибуту
        $("").shouldHave(attribute("disabled"));
        $("").shouldHave(attribute("name", "example"));
        $("").shouldHave(attributeMatching("name", "[0-9]abc$"));

        $("").shouldBe(checked); // Проверка для чек боксов и радиобаттонов

        // Проверяет наличие в DOM
        $("").should(exist);

        // Проверяет задизейбленность , только если есть атрибут disabled
        $("").shouldBe(disabled);
        $("").shouldBe(enabled);
    }

    void collectionsExamples() {


        // Примеры нахождения всех элементов div и их проверка
        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1));

        $$("div").first().click();
        elements("div").first().click();

        $$("div").last().click();
        $$("div").get(1).click();
        $("div", 1).click();
        $$("div").findBy(text("123")).click();

        // Примеры проверок
        $$("").shouldHave(size(0));
        $$("").shouldBe(CollectionCondition.empty);

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma"));
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma"));

        $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa"));
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa"));

        $$("").shouldHave(itemWithText("Gamma"));

        $$("").shouldHave(sizeGreaterThan(0));
        $$("").shouldHave(sizeGreaterThanOrEqual(1));
        $$("").shouldHave(sizeLessThan(3));
        $$("").shouldHave(sizeLessThanOrEqual(2));


    }

    void fileOperationExamples() throws IOException, CsvException {

        // Работа с файлами
        File file1 = $("a.fileLink").download(); // Только для <a href=".."> ссылок
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // Привязываемся к кнопке div

        // Пример загрузки файла
        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file); // Можно загрузить массив файлов uploadFile(file,file1,file2)
        $("#file-upload").uploadFromClasspath("readme.txt");
        $("uploadButton").click();

        $("input[type='file']").uploadFile(file); // Загрузка файла всегда с типом инпута type=file!!!

        //Короткий вариант
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));

        //Скачивание текстового файла и проверка его содержимого !!!Если у кнопки есть href
        File download = $("#raw-url").download();
        String fileContent = IOUtils.toString(new FileReader(download));
        assertTrue(fileContent.contains("Проверка текста"));

        //Скачивание текстового файла и проверка его содержимого !!!Если у кнопки нет href
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = FileDownloadMode.PROXY;




        File download1 = $("#raw-url").download();
        String fileContent1 = IOUtils.toString(new FileReader(download1));
        assertTrue(fileContent1.contains("Проверка текста"));


        //Скачивание PDF файла
        File pdf = $(byText("PDF download")).download();
        PDF parsedPdf = new PDF(pdf);
        assertEquals(164, parsedPdf.numberOfPages);

        //Скачивание XLS файла
        File fileXls = $(byText("XLS download")).download();
        XLS parsedXls = new XLS(fileXls);
        boolean checkPassed = parsedXls.excel
                .getSheetAt(0)
                .getRow(11)
                .getCell(1)
                .getStringCellValue()
                .contains("693010, Сахалинская обл, Южно-Сахалинск г, им Анкудинова Федора Степановича б-р, дом № 15, корпус А");
        assertTrue(checkPassed);

        //Парсинг CSV файлов
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("csv.csv");
             Reader reader = new InputStreamReader(is)) {
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> strings = csvReader.readAll();
            assertEquals(3, strings.size());
        }
        //Парсинг ZIP файлов
        ClassLoader classLoader1 = this.getClass().getClassLoader();
        try (InputStream is = classLoader1.getResourceAsStream("zip_2MB.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    void javascriptExamples() {

        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7);


    }
}

