package allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Ищем репозиторий {repo}")
    public void searchForRepo(String repo) {
        $(".search-input").click();
        $(".FormControl-input").sendKeys("selenide");
        $(".FormControl-input").submit();
        $(linkText("selenide/selenide")).click();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickRepoLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issue")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("проверяем {issueTitle}")
    public void checkIssueTitle(String issueTitle) {
        $("#issues-tab").click();
        $(withText(issueTitle)).should(Condition.exist);
    }
}