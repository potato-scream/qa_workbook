package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiSearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void  selenideWikiSearchTest() {
//        open("https://github.com/selenide/selenide");
//        $("#wiki-tab").click();
//        $(".wiki-more-pages-link button").click();
//        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
//        $(".markdown-body").shouldHave(text("""
//                @ExtendWith({SoftAssertsExtension.class})
//                class Tests {
//                  @Test
//                  void test() {
//                    Configuration.assertionMode = SOFT;
//                    open("page.html");
//
//                    $("#first").should(visible).click();
//                    $("#second").should(visible).click();
//                  }
//                }
//                """));
    }
}


