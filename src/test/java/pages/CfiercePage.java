package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CfiercePage {

    private static final String PAGE_URL = "https://www.cfierce.com/";

    private final ElementsCollection categoryLinks = $$(".site-nav__dropdown li");
    private final ElementsCollection productCards = $$("#Collection li");
    private final SelenideElement allProductsButton = $("#SiteNav").$(byText("ALL"));
    private final SelenideElement pageHeading = $(".section-header");
    private final SelenideElement topNavigationBar = $("#SiteNav");

    @Step("Open the main page")
    public CfiercePage openPage() {
        open(PAGE_URL);
        return this;
    }

    @Step("Search by product type: {productType}")
    public CfiercePage searchByProductType(String productType) {
        allProductsButton.click();
        categoryLinks.findBy(text(productType)).click();
        return this;
    }

    @Step("Verify that search results are not empty")
    public CfiercePage searchResultsShouldNotBeEmpty() {
        productCards.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Navigate to '{navLink}' and check heading for '{expectedHeading}'")
    public CfiercePage checkNavigationAndHeading(String navLink, String expectedHeading) {
        topNavigationBar.$(byText(navLink)).click();
        pageHeading.shouldHave(text(expectedHeading));
        return this;
    }
}

