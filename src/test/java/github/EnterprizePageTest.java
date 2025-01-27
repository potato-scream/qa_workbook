package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class EnterprizePageTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void  enterprizePageTest() {
        open("https://github.com");
        $("nav.HeaderMenu-nav").$(byText("Solutions")).hover();
        $("[href='https://github.com/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }
}

