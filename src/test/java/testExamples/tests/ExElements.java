package testExamples.tests;

import org.junit.jupiter.api.Test;
import testExamples.pages.ExElementsPage;
import java.io.IOException;

public class ExElements extends TestBase {
    // Степы внутри пейджи

    ExElementsPage exElementsPage = new ExElementsPage();

    @Test
    void testBox() {

        exElementsPage.openPageExEl("https://demoqa.com/text-box")
                .checkOpenPageExEl("Text Box")
                .setUserName()
                .typeUserEmail()
                .typeСurrentAddress()
                .typePermanentAddress()
                .clickSubmit()
                .checkTextBox();

    }

    @Test
    void checkBox() {

        exElementsPage.openPageExEl("https://demoqa.com/checkbox")
                .checkOpenPageExEl("Check Box")
                .expandAndCollapse()
                .expandAndCollapseInOrder()
                .checkAndUncheckAllCheckboxesList()
                .checkAndUncheckAllCheckboxesSection()
                .checkCheckboxesAndCheck();

    }


    @Test
    void webTables() {

        exElementsPage.openPageExEl("https://demoqa.com/webtables")
                .checkOpenPageExEl("Web Tables")
                .enterUserDataInTheTableAndCheckTheResult()
                .userSearch()
                .userEditing()
                .userDelete();

    }

    @Test
    void clickButton() {

        exElementsPage.openPageExEl("https://demoqa.com/buttons")
                .checkOpenPageExEl("Buttons")
                .doubleClick()
                .rightClick()
                .dynamicClick();

    }

    @Test
    void uploadAndDownload() throws IOException {

        exElementsPage.openPageExEl("https://the-internet.herokuapp.com/upload")
                .checkOpenPageExElUploadAndDownload("File Uploader")
                .uploadFile()
                .openPageExEl("https://demoqa.com/upload-download")
                .downloadFile();

    }


}
