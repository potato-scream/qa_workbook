import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CfiercePage;

import static io.qameta.allure.Allure.step;

public class CfierceTest {
    CfiercePage cfiercePage = new CfiercePage();

    @BeforeEach
    void setUp() {
        cfiercePage.openPage();
    }

    @ValueSource(strings = {"TOPS", "Bottoms", "Dress"})
    @Tag("ID 3")
    @DisplayName("Search results should not be empty for product type")
    @ParameterizedTest(name = "For product type \"{0}\", search results should be displayed")
    void searchResultsShouldNotBeEmptyTest(String navItem) {
        step("Search by product type: " + navItem, () -> {
            cfiercePage.searchByProductType(navItem);
        });

        step("Verify that search results are not empty", () -> {
            cfiercePage.searchResultsShouldNotBeEmpty();
        });
    }

    @CsvSource(value = {
            "CONTACT, Contact us",
            "BLOG, News"
    })
    @Tag("ID 4")
    @DisplayName("Navigation items should lead to correct pages")
    @ParameterizedTest(name = "Clicking on \"{0}\" should lead to a page with heading \"{1}\"")
    void navigationShouldLeadToTheCorrectPageTest(String navItem, String pageHeading) {
        step("Navigate to " + navItem + " and verify page heading", () -> {
            cfiercePage.checkNavigationAndHeading(navItem, pageHeading);
        });
    }
}

