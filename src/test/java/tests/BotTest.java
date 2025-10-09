package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Модуль боты")
public class BotTest extends BaseTest {
    private static final String BOT_NAME = "Test";

    @Feature("Алерт-бот")
    @Story("ID2")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Nikolaeva Ann niolan007@yandex.ru")
    @TmsLink("SwagLabs")
    @Issue("Sandbox")
    @Test(description = "создание алерт-бота")
    public void createAlertBot() {
        loginPage.openPage()
                .login();
        botPage.addBots()
                .chooseAlertBot()
                .createBot(BOT_NAME)
                .checkCreatedBot(BOT_NAME);
    }
}
