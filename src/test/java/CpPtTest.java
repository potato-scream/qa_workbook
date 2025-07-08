import data.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CpPtPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class CpPtTest {
    CpPtPage cpPtPage = new CpPtPage();

    @BeforeEach
    void setUp() {
        cpPtPage.openPage();
    }

    @Tag("ID 1")
    @DisplayName("Page heading should be correct when language is changed")
    @EnumSource(Language.class)
    @ParameterizedTest(name = "For language {0}, the description should be correct")
    void cpPtShouldHaveCorrectDescriptionTest(Language language) {
        step("Change language to: " + language.name(), () -> {
            cpPtPage.changeLanguage(language.name());
        });

        step("Verify page description is: \"" + language.description + "\"", () -> {
            cpPtPage.checkDescription(language.description);
        });
    }

    static Stream<Arguments> cpPtShouldHaveCorrectButtonsTest() {
        return Stream.of(
                Arguments.of(
                        Language.EN,
                        List.of("times", "Tickets", "Leisure", "travel", "Benefits")
                ),
                Arguments.of(
                        Language.PT,
                        List.of("horários", "bilhetes", "lazer", "viajar", "Vantagens")
                )
        );
    }

    @Tag("ID 2")
    @DisplayName("Text in navigation menu buttons should be correct when language is changed")
    @MethodSource
    @ParameterizedTest(name = "For language {0}, navigation buttons should be correct")
    void cpPtShouldHaveCorrectButtonsTest(Language language, List<String> expectedButtonText) {
        step("Change language to: " + language.name(), () -> {
            cpPtPage.changeLanguage(language.name());
        });

        step("Verify navigation buttons text", () -> {
            cpPtPage.checkButtonsText(expectedButtonText);
        });
    }
}
