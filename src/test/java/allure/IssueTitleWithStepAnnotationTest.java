package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class IssueTitleWithStepAnnotationTest extends allure.TestBase {
    private static final String repository = "selenide/selenide";
    private static final String issueTitle = "CombinedAttribute works for iOS (value) but fails for Android (text)";

    @Feature("Issue в репозитории")
    @Story("Проверка заголовка Issue с аннотацией @Step")
    @Owner("kromanovskaia")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Проверка заголовка Issue")
    @Test
    public void issueTitleTestWithStepsAnnotation() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.searchForRepo(repository);
        steps.clickRepoLink(repository);
        steps.openIssueTab();
        steps.checkIssueTitle(issueTitle);
    }
}
