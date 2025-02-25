package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class CfiercePage {

    public CfiercePage openPage() {
        open("https://www.cfierce.com/");
        return this;
    }

    private final ElementsCollection navItems = $$(".site-nav__dropdown li");
    private final ElementsCollection productItems = $$("#Collection li");
    private final SelenideElement buttonAll = $("#SiteNav").$(byText("ALL"));
    private final SelenideElement pageHeading = $(".section-header");
    private final SelenideElement navButton = $("#SiteNav");

    public CfiercePage searchByProductType(String value) {
        buttonAll.click();
        navItems.findBy(text(value)).click();
        return this;
    }

    public CfiercePage searchResultsShouldNotBeEmpty() {
        productItems.shouldHave(sizeGreaterThan(0));
        return this;
    }

    public CfiercePage checkHeadingText(String value, String arg) {
        navButton.$(byText(value)).click();
        pageHeading.shouldHave(text(arg));
        return this;
    }
}
