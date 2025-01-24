import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DrugAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void  drugAndDropTest() {
        open("/drag_and_drop");
        $("#columns").$$("div").first().shouldHave(text("A"));
        actions()
                .dragAndDrop($("#column-a"), $("#column-b"))
                .perform();
        $("#columns").$$("div").first().shouldHave(text("B"));
    }
}

