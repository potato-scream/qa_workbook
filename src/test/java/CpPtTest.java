import data.Language;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CpPtTest {
    @Tag("WEB")
    @DisplayName("Page heading should be correct when language changed")

    @BeforeEach
    void setUp() {
        open("https://www.cp.pt/passageiros/");
    }
    @EnumSource(Language.class)
    @ParameterizedTest
    void CpPtshouldHaveCorrectDescription(Language language) {
        $$(".user-nav a").find(text(language.name())).click();
        $("h1").shouldHave(text(language.description));
    }
}
