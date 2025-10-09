package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Модуль логин")
public class LoginTest extends BaseTest {
    @Feature("Юр. лицо")
    @Story("ID1")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Nikolaeva Ann niolan007@yandex.ru")
    @TmsLink("SwagLabs")
    @Issue("Sandbox")
    @Test(description = "проверка логина с валидными данными")
    public void checkCorrectLogin() {
        loginPage.openPage()
                .login();
        mainPage.checkCorrectLogin();
    }
}
