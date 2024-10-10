import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps1 {
    @Step ("Открывыаем главную страницу")
    public void openMainPageOne(){
        open("https://spb.hh.ru/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepositoryOne(String repo){
        $("#a11y-search-input").click();
        $("#a11y-search-input").sendKeys(repo);
        $("#a11y-search-input").submit();
    }

    @Step("Проверяем наличие Issue {issue}")
    public void shouldSeeIssuesWithNumberOne(String issue){
        $(withText(issue)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshotOne() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
