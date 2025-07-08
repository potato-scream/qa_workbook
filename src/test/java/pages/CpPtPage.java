package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CpPtPage {
    private static final String PAGE_URL = "https://www.cp.pt/passageiros/";

    private final ElementsCollection languageSwitchers = $$(".user-nav a");
    private final SelenideElement pageHeading = $("h1");
    private final ElementsCollection mainNavigationButtons = $$(".btn-nav");

    @Step("Open the main page")
    public CpPtPage openPage() {
        open(PAGE_URL);
        return this;
    }

    @Step("Change language to: {languageCode}")
    public CpPtPage changeLanguage(String languageCode) {
        // Filter the collection of language links to find the one we need.
        // This avoids an exception if the element is not found.
        ElementsCollection desiredLanguageLink = languageSwitchers.filterBy(text(languageCode));

        // If the filtered collection is not empty, it means the language is not active, so we click it.
        if (desiredLanguageLink.size() > 0) {
            desiredLanguageLink.first().click();
        }
        // If the collection is empty, the language is already active, and we do nothing.

        return this;
    }

    @Step("Verify page description is: {value}")
    public CpPtPage checkDescription(String value) {
        pageHeading.shouldHave(text(value));
        return this;
    }

    @Step("Verify navigation buttons text")
    public CpPtPage checkButtonsText(List<String> value) {
        mainNavigationButtons.shouldHave(texts(value));
        return this;
    }
}