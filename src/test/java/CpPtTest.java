import data.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.CpPtPage;

public class CpPtTest {
    CpPtPage CpPtPage = new CpPtPage();

    @Tag("WEB")
    @DisplayName("Page heading should be correct when language changed")

    @BeforeEach
    void setUp() {
        CpPtPage.openPage();
    }

    @EnumSource(Language.class)
    @ParameterizedTest
    void CpPtshouldHaveCorrectDescription(Language language) {
        CpPtPage.changeLanguage(language.name());
        CpPtPage.checkDescription(language.description);
    }
}
