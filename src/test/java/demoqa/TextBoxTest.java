package demoqa;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTest() {
        textBoxPage.openPage()
                .removeBanner()
                .setName("Kseniia Romanovskaya")
                .setEmail("potato@cat.com")
                .setCurrentAddress("Some address 1")
                .setPermanentAddress("Some address 1")
                .pressSubmit();

        textBoxPage.checkResults("name", "Kseniia Romanovskaya")
                .checkResults("email", "potato@cat.com")
                .checkResults("currentAddress", "Some address 1")
                .checkResults("permanentAddress", "Some address 1");
    }
}
