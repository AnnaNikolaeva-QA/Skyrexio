package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TerminalPage;
import pages.LoginPage;
import pages.MainPage;

import static org.openqa.selenium.devtools.v137.network.Network.clearBrowserCache;

public class BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    TerminalPage terminalPage = new TerminalPage();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 30000;
        Configuration.baseUrl = "https://test.skyrexio.com";
        Configuration.browserSize = "1980x1080";
    }

    @AfterMethod
    public void closeWind() {
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}
