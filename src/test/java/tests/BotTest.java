package tests;

import org.testng.annotations.Test;

public class BotTest extends BaseTest {
    private static final String BOT_NAME = "Test";

    @Test
    public void createAlertBot() {
        loginPage.openPage()
                .login()
                .pressLoginButton();
        botPage.addBots()
                .chooseAlertBot()
                .createBot(BOT_NAME)
                .checkCreatedBot(BOT_NAME);
    }
}
