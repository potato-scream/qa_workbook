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

public class CpPtTest {
    CpPtPage cpPtPage = new CpPtPage();

    @BeforeEach
    void setUp() {
        cpPtPage.openPage();
    }

    @Tag("ID 1")
    @DisplayName("Page heading should be correct when language changed")
    @EnumSource(Language.class)
    @ParameterizedTest
    void cpPtshouldHaveCorrectDescriptionTest(Language language) {
        cpPtPage.changeLanguage(language.name());
        cpPtPage.checkDescription(language.description);
    }

    static Stream<Arguments> cpPtshouldHaveCorrectButtonsTest() {
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
    @DisplayName("Text in navigation menu buttons should be correct when language changed")
    @MethodSource
    @ParameterizedTest
    void cpPtshouldHaveCorrectButtonsTest(Language language, List<String> expectedButtonText) {
        cpPtPage.changeLanguage(language.name());
        cpPtPage.checkButtonsText(expectedButtonText);
    }
}
