package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import pages.BotPage;
import pages.TerminalPage;
import pages.LoginPage;
import pages.MainPage;

import static org.openqa.selenium.devtools.v137.network.Network.clearBrowserCache;

public class BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    TerminalPage terminalPage;
    BotPage botPage;

    @Step("Открытие браузера")
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        Configuration.browser = browser.equalsIgnoreCase("chrome") ? "chrome" : "edge";
        Configuration.headless = false;
        Configuration.timeout = 30000;
        Configuration.baseUrl = "https://test.skyrexio.com";
        Configuration.browserSize = "1920x1080";
        loginPage = new LoginPage();
        mainPage = new MainPage();
        terminalPage = new TerminalPage();
        botPage = new BotPage();
    }

    @Step("Закртие браузера")
    @AfterMethod(alwaysRun = true)
    public void closeWind() {
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
