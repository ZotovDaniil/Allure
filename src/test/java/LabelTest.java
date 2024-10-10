import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "http://testinh.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels(){

    }

    @Test
    public void testDinamicLabels(){

    }

}
