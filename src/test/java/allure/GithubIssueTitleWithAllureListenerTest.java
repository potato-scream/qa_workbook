package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

import static org.openqa.selenium.By.linkText;

public class GithubIssueTitleWithAllureListenerTest extends  allure.TestBase {
    private static final String repository = "selenide/selenide";
    private static final String issueTitle = "CombinedAttribute works for iOS (value) but fails for Android (text)";

    @Feature("Issue в репозитории")
    @Story("Проверка заголовка Issue c подключением Allure listener")
    @Owner("kromanovskaia")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Проверка заголовка Issue")
    @Test
    public void issueTitleTestWithListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        $(".search-input").click();
        $(".FormControl-input").sendKeys("selenide");
        $(".FormControl-input").submit();
        $(linkText(repository)).click();
        $("#issues-tab").click();
        $(withText(issueTitle)).should(Condition.exist);
    }
}
