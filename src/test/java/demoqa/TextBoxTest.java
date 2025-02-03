package demoqa;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {
    TextBoxPage TextBoxPage = new TextBoxPage();

    @Test
    void textBoxTest() {
        TextBoxPage.openPage()
                .setName("Kseniia Romanovskaya")
                .setEmail("potato@cat.com")
                .setCurrentAddress("Some address 1")
                .setPermanentAddress("Some address 1")
                .pressSubmit();

        TextBoxPage.checkResults("name", "Kseniia Romanovskaya")
                .checkResults("email", "potato@cat.com")
                .checkResults("currentAddress", "Some address 1")
                .checkResults("permanentAddress", "Some address 1");
    }
}
