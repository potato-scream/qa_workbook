import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CfierceTest {
    @Tag("WEB")
    @BeforeEach
    void setUp() {
        open("https://www.cfierce.com/");
    }

    @ValueSource(strings = {
            "Tops", "Bottoms", "Dress"
    })

    @ParameterizedTest(name = "Для поиска по типу товара {0} в меню All нужно получить список карточек")

    void searchResultsShouldNotBeEmpty(String navItem) {
        $("#SiteNav").$(byText("All")).click();
        $$(".site-nav__dropdown li").findBy(text(navItem)).click();
        $$("#Collection li").shouldHave(sizeGreaterThan(0));
    }

    @CsvSource(value = {
            "CONTACT, Contact us",
            "BLOG, News"
    })
    @ParameterizedTest(name = "При клику по элементу навигации {0} переходим на страницу с заголовком {1}")

    void navigationShouldLeadToTheCorrectPage(String navItem, String pageHeading) {
        $("#SiteNav").$(byText(navItem)).click();
        $(".section-header").shouldHave(text(pageHeading));
    }
}
