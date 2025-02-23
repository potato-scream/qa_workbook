import com.codeborne.selenide.CollectionCondition;
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
    CpPtPage CpPtPage = new CpPtPage();

    @BeforeEach
    void setUp() {
        CpPtPage.openPage();
    }

    @Tag("WEB")
    @DisplayName("Page heading should be correct when language changed")
    @EnumSource(Language.class)
    @ParameterizedTest
    void CpPtshouldHaveCorrectDescription(Language language) {
        CpPtPage.changeLanguage(language.name());
        CpPtPage.checkDescription(language.description);
    }

    static Stream<Arguments> CpPtshouldHaveCorrectButtons() {
        return Stream.of(
                Arguments.of (
                        Language.EN,
                        List.of("times", "Tickets", "Leisure", "travel", "Benefits")
                ),
                Arguments.of (
                        Language.PT,
                        List.of("horários", "bilhetes", "lazer", "viajar", "Vantagens")
                )
        );
    }

    @Tag("WEB")
    @DisplayName("Text in navigation menu buttons should be correct when language changed")
    @MethodSource
    @ParameterizedTest
    void CpPtshouldHaveCorrectButtons(Language language, List<String> expectedButtonText) {
        CpPtPage.changeLanguage(language.name());
        CpPtPage.checkButtonsText(expectedButtonText);
    }
}
