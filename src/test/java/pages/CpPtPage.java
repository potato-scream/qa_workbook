package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CpPtPage {

    public CpPtPage openPage() {
        open("https://www.cp.pt/passageiros/");
        return this;
    }

    private final ElementsCollection languageButtons = $$(".user-nav a");
    private final SelenideElement pageHeading = $("h1");

    public  CpPtPage changeLanguage(String value) {
        languageButtons.find(text(value)).click();
        return this;
    }

    public  CpPtPage checkDescription(String value) {
        pageHeading.shouldHave(text(value));
        return this;
    }
}
