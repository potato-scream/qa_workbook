import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CfiercePage;

public class CfierceTest {
    pages.CfiercePage CfiercePage = new CfiercePage();

    @BeforeEach
    void setUp() {
        CfiercePage.openPage();
    }

    @ValueSource(strings = {
            "TOPS", "Bottoms", "Dress"
    })

    @Tag("ID 3")
    @ParameterizedTest(name = "Для поиска по типу товара {0} в меню All нужно получить список карточек")
    void searchResultsShouldNotBeEmpty(String navItem) {
        CfiercePage.searchByProductType(navItem);
        CfiercePage.searchResultsShouldNotBeEmpty();
    }

    @CsvSource(value = {
            "CONTACT, Contact us",
            "BLOG, News"
    })

    @Tag("ID 4")
    @ParameterizedTest(name = "При клику по элементу навигации {0} переходим на страницу с заголовком {1}")
    void navigationShouldLeadToTheCorrectPage(String navItem, String pageHeading) {
        CfiercePage.checkHeadingText(navItem, pageHeading);
    }
}
