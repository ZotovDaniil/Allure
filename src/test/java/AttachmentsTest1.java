import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest1 {
    private static final String REPOSITORY = "технолог";
    private static final String ISSUE = "Работа технологом";


    @BeforeAll

    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
    }
    
    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открывыаем главную страницу", () -> {
            open("https://spb.hh.ru/");
            attachment("Source", webdriver().driver().source());
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("#a11y-search-input").click();
            $("#a11y-search-input").sendKeys(REPOSITORY);
            $("#a11y-search-input").submit();
        });

        step("Проверяем наличие Issue " + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });



    }

    @Test
    public void testAnnotatedAttachments() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.takeScreenshot();

    }
}
